// P03 (*) Find the Kth element of a list.
//     By convention, the first element in the list is element 0.
//
//     Example:
//     scala> nth(2, List(1, 1, 2, 3, 5, 8))
//     res0: Int = 2
object PO3 extends App{
	
	def nthBuiltin[A](n: Int, ls: List[A]) : A =
	    if (n >= 0) ls(n) // = ls.apply(2) || ls apply 2, apply is implicit
	    else throw new NoSuchElementException
	    
	/**
	 * What does this do? 
	 * 
	 * Pattern matches: 
	 * 
	 * n = 0 && there is a head, return the first element
	 * n > 0 && there is a tail, reduce n by 1, remove first element, do it again
	 * n = anything, empty list, throw exception
	 */
	def nthRecursive[A](n: Int, ls:List[A]) : A = (n, ls) match {
	      case (0, h :: _ ) 	=> h
	      case (n, _ :: tail)	=> nthRecursive(n - 1, tail)
	      case (_, Nil)			=> throw new NoSuchElementException
	    }
	
	val ls = List(1,2,3,4,5,6,7,8)
	
	// both prints 1
	Console.println("built in: " + nthBuiltin(0, ls))
	Console.println("recursive: " + nthRecursive(0, ls))
	
	// both prints 5
	Console.println("built in: " + nthBuiltin(4, ls))
	Console.println("recursive: " + nthRecursive(4, ls))
  
}