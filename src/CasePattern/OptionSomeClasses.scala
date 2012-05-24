package CasePattern

import Console._

object OptionSomeClasses extends App {
    
    def show (x: Option[String]) = x match {
        case Some(s) => s
        case None => "?"
    }
    
    val capitals = Map("France" -> "Paris", 
                       "Japan" -> "Tokyo")
    println(show(capitals get "France"))
    println(show(capitals get "Japan"))
    println(show(capitals get "North Pole"))

}
