(ns sikuli-clj.target
  (:import [org.sikuli.api ImageTarget TextTarget]))

(defn- try-parse-url
  [url]
  (try
    (java.net.URL. url)
    (catch Exception e nil)))

(defn text
  [txt]
  (TextTarget. txt))

(defn image
  [arg]
  (if (string? arg)
    (ImageTarget. (or (try-parse-url arg)
                      (clojure.java.io/file arg)))
    (ImageTarget. arg)))
