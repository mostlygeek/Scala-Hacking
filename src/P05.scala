// P05 (*) Reverse a list.
//     Example:
//     scala> reverse(List(1, 1, 2, 3, 5, 8))
//     res0: List[Int] = List(8, 5, 3, 2, 1, 1)

object P05 extends App 
{
	
	def reverseBuiltin[A](ls :List[A]) : List[A] = ls.reverse
	
	/**
	 * O(n^2)
	 * recursively puts the head at the end of the list 
	 * until finished
	 * 
	 */
	def reverseRecursive[A](ls :List[A]) : List[A] = ls match {
	  case Nil => Nil
	  case head :: tail => reverseRecursive(tail) ::: List(head)
	}
	
	// Tail recursive version, remember from P04 that
	// the method needs to be 'local' or 'final'
	def reverseTailRecursion[A](ls : List[A]) : List[A] = {
	  def reverseR(result: List[A], curList: List[A]) : List[A] = curList match {
	    case Nil => result
	    case h :: tail => reverseR(h :: result, tail)	    
	    // keep adding the first element to the result until finished 
	  }
	  
	  reverseR(Nil, ls)
	}
	
	val ls = List(1,2,3,4,5)
	Console.println("Built in: " + reverseRecursive(ls))
	Console.println("Recurse: " + reverseRecursive(ls))
	Console.println("Tail Recurse: " + reverseTailRecursion(ls))
}