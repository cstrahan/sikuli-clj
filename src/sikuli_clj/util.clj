(ns sikuli-clj.util
  (:import [javax.imageio ImageIO]
           [java.awt Rectangle]))

(defn save-image
  [image format-str path]
  (with-open [writer (clojure.java.io/writer path)]
    (ImageIO/write image format-str writer)))

(defn rectangle->vector
  [rect]
  (let [x      (.x rect)
        y      (.y rect)
        width  (.width rect)
        height (.height rect)]
    [x y width height]))

(defn vector->rectangle
  [rect]
  (let [x      (nth rect 0)
        y      (nth rect 1)
        width  (nth rect 2)
        height (nth rect 3)]
    (Rectangle. x y width height)))

(defn location->vector
  [loc]
  [(.getX loc) 
   (.getY loc) 
   (.getId (.getScreen loc))])

(defn- set-static-double
  [klass field value]
  (let [f (.getDeclaredField klass field)]
    (.setAccessible f true)
    (.setDouble f klass (double value))))

(defn- set-static-float
  [klass field value]
  (let [f (.getDeclaredField klass field)]
    (.setAccessible f true)
    (.setFloat f klass (float value))))

; default: 0.5
(defn set-move-mouse-delay
  [seconds]
  (set-static-float org.sikuli.api.robot.desktop.AWTRobot
                    "MoveMouseDelay"
                    seconds))

; default: 0.3
(defn set-delay-before-drop
  [seconds]
  (set-static-double org.sikuli.api.robot.desktop.AWTRobot
                     "DelayBeforeDrop"
                     seconds))

; default: 0.3
(defn set-delay-after-drag
  [seconds]
  (set-static-double org.sikuli.api.robot.desktop.AWTRobot
                     "DelayAfterDrag"
                     seconds))
