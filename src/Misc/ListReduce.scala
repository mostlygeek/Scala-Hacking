package Misc
import Console._

object ListReduce extends App {
	
    val ls = List("A", "B", "C", "D", "E")
    
    val reduceFn = { (left:String, right:String) =>
    	println("left: %-16s, right: %s" format (left, right) )
    	left + ", " + right
    }
    
    /**
     * Reduce works like fold except it does not require a starting value
     */
    println("reduce()")
    ls.reduce(reduceFn)
    println
    
    println("reduceLeft()")
    ls.reduceLeft(reduceFn)
    println
    
    println("reduceRight()")
    ls.reduceRight(reduceFn)
}