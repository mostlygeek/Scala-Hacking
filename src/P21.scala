// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
object P21 extends App {
	def insertAt[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match { // 1
	  case (pre, post) => pre ::: e :: post										// 2
	}
	
	/**
	 * 1. This is pretty interesting using a match to reduce the amount of code
	 *   - splitAt(n) will return a tuple of (pre, post)
	 * 
	 *  2. the case will always match, and it will return the pre, the new 
	 *     element e, and post 
	 */
	
	def insertAt2[A](e: A, n: Int, ls: List[A]): List[A] = {
	  val (pre, post) = ls.splitAt(n)		// 1
	  pre ::: e :: post						// 2
	}
	
	/**
	 * This version (mine) is hopefully a little easier to understand and 
	 * less clever. :) 
	 * 
	 * 1. we do an assignment of a tuple, and vals to what is returned 
	 *    from splitAt
	 * 
	 * 2. We return the new list 
	 */
	
	val ls = List('a, 'b, 'c, 'd)
	Console.println("InsertAt:" + insertAt('new, 1, ls))	
	Console.println("InsertAt2:" + insertAt2('new, 1, ls))
}