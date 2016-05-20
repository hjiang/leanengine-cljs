# leanengine-cljs

This is a minimal project to demonstrate how to run server-side ClojureScript on [LeanEngine](https://leancloud.cn/docs/leanengine_overview.html)

## Setup

* Install the Clojure build tool [Leiningen](http://leiningen.org).
* Create an app on [LeanCloud](https://leancloud.cn)
* Install the JS dependencies:

        npm install
* Build the project:

        lein cljsbuild once
* Link the project with the LeanCloud app you just created:

        lean app add <name> <appId>
* You can then test the app locally:

        lean up
* Or deploy it to LeanCloud:

        lean deploy
