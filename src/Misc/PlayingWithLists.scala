package Misc
import Console._

object PlayingWithLists extends App {

    val ls = List("a", "b", "c", "d", "e")
    
    println("List: " + ls)
    println ("Length: %d elements" format ls.length)
    
    println("Head: " + ls.head)
    println("Tail: " + ls.tail)
    println("Penultimate: " + ls.reverse.tail.head)
    
}