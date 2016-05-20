(defproject leanengine-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-cljsbuild "1.1.3"]]
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release"]
  :target-path "target"
  :cljsbuild {:builds[{:id "default"
                       :source-paths ["src"]
                       :compiler {:main leanengine-cljs.core
                                  :output-to "out/leanengine_cljs.js"
                                  :output-dir "out"
                                  :target :nodejs
                                  :optimizations :none
                                  :source-map true}}]})
