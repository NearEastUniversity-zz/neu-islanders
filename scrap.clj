(dotimes [i 20]
  (println i)
  (do (motor-command 4 50)
    (Thread/sleep 5000)
    (motor-command 4 0)
    (Thread/sleep 100)
    (kick-command 4 4)
    (Thread/sleep 1000)))

(exec-repl (parallel :sequence
                     (forever
                      (wait-freq
                       (action (println "1")
                               true
                               )))

                     (forever
                      (wait-freq
                       (action (println "2")
                               (throw (Exception. "asd"))
                               true
                               )))
                     ))


(exec-repl (sequence
            (sequence
             (sequence
              (sequence
               (sequence
                (sequence
                 (action (throw (Exception. "asd"))))))))))