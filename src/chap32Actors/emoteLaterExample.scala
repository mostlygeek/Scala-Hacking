package chap32Actors

import scala.actors.Actor._

object emoteLaterExample extends App {

    val sillyActor2 = actor {
        def emoteLater() {
            val mainActor = self
            actor {
                Thread.sleep(1000)
                mainActor ! "Emote"
            }
        }

        var emoted = 0
        emoteLater()
        loop {
            react {
                case "Emote" =>
                    println("I'm acting")
                    emoted += 1
                    if (emoted < 5)
                        emoteLater()
                case msg =>
                    println("Received: " + msg)
            }
        }
    }

}