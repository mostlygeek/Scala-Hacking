package chap32Actors

import scala.actors._
import Console._

object Actors1 extends App {

    object SillyActor extends Actor {
        def act() {
            for (i <- 1 to 5) {
                println("I'm acting!")
                Thread.sleep(1000)
            }
        }
    }

    object SeriousActor extends Actor {
        def act() {
            for (i <- 1 to 5) {
                println("To be or not to be.")
                Thread.sleep(1000)
            }
        }
    }

    /**
     * Actors run interleaved, on different
     * threads ...
     */
    SillyActor.start()
    SeriousActor.start()
}