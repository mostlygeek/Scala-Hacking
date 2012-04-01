// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
object P20 extends App {
	def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
	  case (Nil, _) if n < 0 => throw new NoSuchElementException	// 1
	  case (pre, e :: post)	 => (pre ::: post, e)					// 2
	  case (pre, Nil)		 => throw new NoSuchElementException	// 3 
	}
	/**
	 * scala> List(1,2,3,4,5).splitAt(2)
	 * res4: (List[Int], List[Int]) = (List(1, 2),List(3, 4, 5))
	 * 
	 * So splitAt() returns a tuple with two lists
	 * 
	 * 1. handles a case where n < 0, remember List() == Nil
	 * 2. Splits the list and creates the result
	 * 3. handles case where n > List.length-1
	 */

	// Alternate with fewer builtins
	def removeAt2[A](n: Int, ls: List[A]): (List[A], A) = 
	  if (n < 0) throw new NoSuchElementException
	  else (n, ls) match {
	    case (_, Nil) => throw new NoSuchElementException		// 1
	    case (0, h :: tail) => (tail, h)						// 2
	    case (_, h :: tail) => {								// 3
	      val (t, e) = removeAt(n - 1, ls.tail)					// 3
	      (ls.head :: t, e)										// 4
	    }
	  }
	
	/**
	 * 1. If the list is empty, throw NoSuchElementException
	 * 2. If n = 0, first element, return the tuple (tail, the extracted element)
	 * 3. any n, use removeAt() ... wtf... how is this with fewer builtins?!
	 * 4. return it... 
	 */
	
	val ls = List('a, 'b, 'c, 'd)
	val tup = removeAt(1, ls)
	Console.println("removeAt: " + tup)
	
	Console.println("removeAt2: " + removeAt2(1, ls))
}