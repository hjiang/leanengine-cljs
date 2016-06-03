(ns leanengine-cljs.cloud
  (:require [cljs.nodejs :as node]))

(def lean (node/require "leanengine"))

(node/enable-util-print!)

(-> lean (.-Cloud) (.define "hello" 
  (fn [req res]
    (println "hello world from lean")
    (.success res "hey lean"))))