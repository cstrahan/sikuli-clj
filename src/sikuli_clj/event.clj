(ns sikuli-clj.event
  (:require [sikuli-clj.screen :as screen]
            [sikuli-clj.util :as util])
  (:import [javax.imageio ImageIO]
           [org.sikuli.api DesktopScreenRegion DefaultScreenRegion]
           [org.sikuli.api.event StateChangeListener TargetEventListener]
           [org.sikuli.api.robot.desktop DesktopScreen]))

(defn- target-event->hash-map
  [event]
  {:screen-region (.getScreenRegion event)
   :target (.getTarget event)
   :target-region (.getTargetRegion event)})

(defn target-event-listener
  [f]
  (reify TargetEventListener
    (targetAppeared [this event]
      (f (merge {:event :appeared} (target-event->hash-map event))))

    (targetMoved [this event]
      (f (merge {:event :moved} (target-event->hash-map event))))

    (targetVanished [this event]
      (f (merge {:event :vanished} (target-event->hash-map event))))))

(defn state-change-event-listener
  [f]
  (reify StateChangeListener
    (stateChanged [this event]
      (f {:new-state     (.getNewState event)
          :old-state     (.getOldState event)
          :screen-region (.getScreenRegion event)}))))
