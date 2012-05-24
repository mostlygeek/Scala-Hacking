package chap32Actors

import scala.actors.Actor._
import Console.println

object echoActor extends App {

    val echoActor = actor {
        while (true) {
            /**
             * giving receive a partial function, block of case statements..
             *
             * - receive will call the partial's isDefinedAt() method
             * - if isDefinedAt() returns true, the partial's apply()
             *   method is called ..
             *
             *   basically, if there is a message in the actor's inbox that
             *   matches the partial function, it will be apply()'d, otherwise
             *   the actor will block until there is something to react to
             */
            receive {
                case msg => println("got msg: " + msg)
            }
        }
    }

    /**
     * Sends echoActor 5 messages, 1 / second
     */
    val msgBot = actor {
        for (i <- 1 to 5) {
            echoActor ! "msg #: " + i
            Thread.sleep(1000)
        }

        echoActor ! "All done"
    }

    /**
     * demo of how the inbox only reacts when the partial function can
     * be applied
     */
    val intActor = actor {
        receive {
            case x: Int => println("got int: " + x)
        }
    }

    intActor ! "one"
    intActor ! 2
    intActor ! "three"
    intActor ! 4

}