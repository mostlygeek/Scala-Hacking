package Misc

// ref: http://stackoverflow.com/questions/2293592/functional-programming-scala-map-and-fold-left

object MapAndFold extends App {
    
    val ls = List(1,2,3,4,5)
	val letters = List("a", "b", "c", "d", "e")

	val doubleFn = (x:Int) => x * 2
    /**
     * map() will iterate over a list and apply the function to each element
     * in the example below, each number is doubled
     */
	Console.println("Map: " + ls.map(doubleFn))
	Console.println
	
	/**
	 * foldLeft, collects results, starts from the left side, moving to the 
	 * right. 
	 * 
	 * Results: fn( fn( fn(b0, a1), a2), ... aN)
	 */
	val foldFn = (left:String, right:String) => {
	    
	    /**
	     * Use a side effect see what's going on :) 
	     */
	    val out = left + right
	    Console.println("> left: [" + left + "], right: [" + right + "]= " + out) 
		out
	} 
	
	/**
	 * Run this code... see the difference between foldRight / foldLeft
	 */	
	// what does a regular fold do? http://stackoverflow.com/a/6254112/445792
	Console.println("fold(), no guarantee of order, for parallel collections...")
	val folded = letters.fold("-")( foldFn )
	Console.println("Results:" +  folded)
	Console.println
	
	Console.println("foldLeft()") // -abcde
	val foldedLeft = letters.foldLeft("-")(foldFn)
	Console.println("Results: " + foldedLeft)
	Console.println
	
	Console.println("folding Right") // -abcde
	val foldedRight = letters.foldRight("-")(foldFn)
	Console.println("Results: " + foldedRight)
	Console.println
	
	/**
	 * When do you use foldLeft vs foldRight? 
	 * http://stackoverflow.com/a/1446478/445792
	 * 
	 * List(1,2,3,4) foldLeft = ( ( (1 + 2) + 3 ) + 4)
	 * List(1,2,3,4) foldRight = (1 + (2 + (3 + 4) ) )
	 */	
}