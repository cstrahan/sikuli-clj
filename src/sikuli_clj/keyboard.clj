(ns sikuli-clj.keyboard
  (:import [org.sikuli.api DefaultScreenLocation]
           [org.sikuli.api.robot.desktop DesktopMouse DesktopKeyboard DesktopScreen]))

(def ^:dynamic *keyboard*
  (DesktopKeyboard.))
