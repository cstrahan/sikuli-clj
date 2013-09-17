(ns sikuli-clj.visual
  (:import [org.sikuli.api.visual ScreenPainter]))

(def ^:dynamic *painter*
  (ScreenPainter.))

(defn box
  [region millis]
  (.box *painter* region millis)
  region)

(defn circle
  [loc-or-region millis]
  (.circle *painter* loc-or-region millis)
  loc-or-region)

(defn image
  [loc image millis]
  (.image *painter* loc image millis)
  loc)

(defn label
  [loc-or-region txt millis]
  (.label *painter* loc-or-region txt millis)
  loc-or-region)
