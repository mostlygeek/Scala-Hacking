package CasePattern

import Console._

/**
 * Case sequences as partial functions
 */
object CaseSequencesAsPartialFunctions extends App {

    val withDefault: Option[Int] => Int = {
        case Some(x) => x
        case None => 0
    }

    println(withDefault(Some(10)))
    withDefault(None)
}