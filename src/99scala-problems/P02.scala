// P02 (*) Find the last but one element of a list.
//     Example:
//     scala> penultimate(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 5
object P02 extends App {
	
	def penultimateBuiltin[A](ls :List[A]): A = 
		if (ls.isEmpty) throw new NoSuchElementException
		else ls.init.last
	
	def penultimateRecursive[A](ls: List[A]): A = ls match {
		  /**
		   * :: = CONS operator, ref: http://www.artima.com/scalazine/articles/pattern_matchingP.html
		   * 
		   * case head::tail .. 
		   */
		  case h :: _ :: Nil => h  
		  case _ :: tail	 => penultimateRecursive(tail)
		  case _		     => throw new NoSuchElementException
	}
	
	// using the built in.
	def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
	  if (n <= 0) throw new IllegalArgumentException
	  if (ls.length < n) throw new NoSuchElementException
	  ls.takeRight(n).head
	}
		
	Console.println( penultimateBuiltin(List(1,2,3,4,5,6)) )
	Console.println( penultimateRecursive(List(1,2,3,4,5,6)) )
}