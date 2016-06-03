(ns leanengine-cljs.core
  (:require [cljs.nodejs :as node]
            [leanengine-cljs.cloud]))

(def leanengine (node/require "leanengine"))
(def express (node/require "express"))

(node/enable-util-print!)

(defn -main [& args]
  (let [port (js/parseInt (or (-> js/process (.-env) (.-LC_APP_PORT)) 3000))
        app (express)
        env (.-env js/process)]
    (.initialize leanengine
               (.-LC_APP_ID env)
               (.-LC_APP_KEY env)
               (.-LC_APP_MASTER_KEY env))
    (-> leanengine (.-Cloud) (.useMasterKey))
    (.use app (.-Cloud leanengine))
    (.get app "/" (fn [req res] (.send res "Hello LeanEngine!")))
    (.listen app port (fn [] (println "App is running!")))))

(set! *main-cli-fn* -main)
