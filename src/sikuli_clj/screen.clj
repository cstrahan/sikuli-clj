(ns sikuli-clj.screen
  (:require [sikuli-clj.util :as util])
  (:import [javax.imageio ImageIO])
  (:import [org.sikuli.api DefaultScreenLocation])
  (:import [org.sikuli.api.robot.desktop DesktopScreen]))

(def ^:dynamic *screen*
  (DesktopScreen. 0))

(defn screen
  [screen-id]
  (if (integer? screen-id)
    (DesktopScreen. screen-id)
    screen-id))

(defn screen-id
  [screen]
  (.getId screen))

(defn bounds
  [screen]
  (util/rectangle->vector (.getBounds screen)))

(defn size
  [screen]
  (let [s      (.getSize screen)
        width  (.width s)
        height (.height s)]
    [width height]))

(defn location
  ([args]
   (if (or (vector? args) (seq? args))
     (apply location args)
     args))
  ([a b]
   (if (integer? a)
     (location a b *screen*)
     (location (first a) (second a) b)))
  ([x y s]
   (DefaultScreenLocation. (screen s) x y)))

(defn screenshot
  ([x y w h]
   (screenshot x y w h *screen*))
  ([x y w h s]
   (.getScreenshot s x y w h)))
