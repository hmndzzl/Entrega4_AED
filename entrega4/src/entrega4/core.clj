(ns entrega4.core
  (:require [clojure.set :as set])
  (:gen-class))

(def usuarios
  {"Ana"    #{"Luis" "Carlos" "Maria"}
   "Luis"   #{"Ana" "Carlos"}
   "Carlos" #{"Luis" "Ana" "Pedro"}
   "Pedro"  #{"Carlos"}
   "Maria"  #{"Ana"}})

(defn amigos-en-comun [usuario1 usuario2]
  (clojure.set/intersection (usuarios usuario1) (usuarios usuario2)))

(defn usuario-con-mas-amigos []
  (apply max-key #(count (val %)) usuarios))

(defn -main []
  (println "Número de amigos por usuario:")
  (doseq [[usuario amigos] usuarios]
    (println usuario ":" (count amigos) "amigos"))

  (let [[u mas-amigos] (usuario-con-mas-amigos)]
    (println "\nUsuario con más amigos:" u "con" (count mas-amigos) "amigos"))

  (println "\nAmigos en común entre Ana y Carlos:" (amigos-en-comun "Ana" "Carlos")))
