(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'leanengine-cljs.core
   :output-to "out/leanengine_cljs.js"
   :output-dir "out"})
