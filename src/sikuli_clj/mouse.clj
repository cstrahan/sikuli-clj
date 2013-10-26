(ns sikuli-clj.mouse
  (:require [sikuli-clj.screen :as screen])
  (:import [org.sikuli.api DefaultScreenLocation]
           [org.sikuli.api.robot.desktop DesktopMouse]))

(def ^:dynamic *mouse*
  (DesktopMouse.))

(defn desktop-mouse
  []
  (DesktopMouse.))

(defn position
  ([]
   (position *mouse*))
  ([mouse]
   (.getLocation mouse)))

(defn down
  ([]
   (.mouseDown *mouse*))
  ([buttons]
   (.mouseDown *mouse* buttons)))

(defn up
  ([]
   (.mouseUp *mouse*))
  ([buttons]
   (.mouseUp *mouse* buttons)))

(defn click
  [& args]
  (.click *mouse* (apply screen/location args)))

(defn double-click
  [& args]
  (.doubleClick *mouse* (apply screen/location args)))

(defn right-click
  [& args]
  (.rightClick *mouse* (apply screen/location args)))

(defn drag
  [& args]
  (.drag *mouse* (apply screen/location args)))

(defn drop
  [& args]
  (.drop *mouse* (apply screen/location args)))
