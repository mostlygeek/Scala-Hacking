package chap32Actors

import scala.actors.Actor._
import Console._

object Actor2 extends App {
    /**
     * Creating actors via a utility method
     */

    val seriousActor2 = actor {
        for (i <- 1 to 5) {
            println("That is the question")
            Thread.sleep(1000)
        }
    }

    /**
     * note, no need to call seriousActor2.start()
     * the actor starts immediately when it is
     * defined.
     */

}