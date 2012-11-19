(ns sikuli-clj.target
  (:import [org.sikuli.api ColorImageTarget ImageTarget TextTarget]
           [javax.imageio ImageIO]))

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

(defn- read-img
  [path]
  (ImageIO/read (clojure.java.io/file path)))

(defn color-image
  [arg]
  (if (string? arg)
    (ColorImageTarget. (or (try-parse-url arg) (read-img arg)))
    (ColorImageTarget. arg)))
