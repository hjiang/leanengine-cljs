(ns leanengine-cljs.core
  (:require [cljs.nodejs :as nodejs]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(def leanengine (nodejs/require "leanengine"))
(def express (nodejs/require "express"))

(nodejs/enable-util-print!)

(defn -main [& args]
  (.initialize leanengine
               (-> js/process (.-env) (.-LC_APP_ID))
               (-> js/process (.-env) (.-LC_APP_KEY))
               (-> js/process (.-env) (.-LC_APP_MASTER_KEY)))
  (-> leanengine (.-Cloud) (.useMasterKey))
  ;; initialize app
  (let [port (js/parseInt (or (-> js/process (.-env) (.-LC_APP_PORT)) 3000))
        app (express)]
    (.use app (.-Cloud leanengine))
    (.get app "/" (fn [req res] (.send res "Hello LeanEngine!")))
    (.listen app port (fn [] (println "App is running!")))))

(set! *main-cli-fn* -main)
