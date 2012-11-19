(ns sikuli-clj.region
  (:require [sikuli-clj.screen :as screen]
            [sikuli-clj.util :as util]
            [sikuli-clj.event :as event])
  (:import [javax.imageio ImageIO]
           [org.sikuli.api DesktopScreenRegion DefaultScreenRegion]
           [org.sikuli.api.event StateChangeListener TargetEventListener]
           [org.sikuli.api.robot.desktop DesktopScreen]))

(defn desktop
  ([]
   (DesktopScreenRegion.))
  ([dimensions]
   (apply desktop dimensions))
  ([x y w h]
   (DesktopScreenRegion. x y w h)))

(defn region
  ([]
   (region screen/*screen*))
  ([screen]
   (DefaultScreenRegion. screen))
  ([x y w h]
   (region screen/*screen* x y w h))
  ([screen-or-region x y w h]
   (DefaultScreenRegion. screen-or-region x y w h)))

(defn relative-to
  [region xoff yoff w h]
  (.getRelativeScreenRegion region xoff yoff w h))

(defn capture
  [region]
  (.capture region)
  region)

(defn score
  [region]
  (.getScore region))

(defn center
  [region]
  (.getCenter region))

(defn wait
  [region target millis]
  (.wait region target millis))

(defn find
  [region target]
  (.find region target))

(defn bounds
  [region]
  (util/rectangle->vector (.getBounds region)))

(defn find-all
  [region target]
  (.find region target))

(defn add-target-listener
  [region target listener]
  (.addTargetEventListener region
                           target
                           (if (fn? listener)
                             (event/target-event-listener listener)
                             listener))
  region)

(defn add-state-change-listener
  [region listener]
  (.addStateChangeEventListener region
                                (if (fn? listener)
                                  (event/state-change-event-listener listener)
                                  listener))
  region)
