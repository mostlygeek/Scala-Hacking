// P04 (*) Find the number of elements of a list.
//     Example:
//     scala> length(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 6

object P04 extends App 
{
	def lengthBuiltin[A](ls : List[A]) : Int = ls.length
	
	/**
	 * remember Nil == List()
	 * _ :: tail ... keep adding 1 for ever element of the list
	 */
	def lengthRecursive[A](ls: List[A]) : Int = ls match {
	  case Nil => 0
	  case _ :: tail => 1 + lengthRecursive(tail)
	}
	
	/*
	 * Tail recursive solution
	 * 
	 *  - java does not optimize tail recursive calls
	 *  - scala will *if* method is final or it is a
	 *    local method
	 *    
	 *  Tail recursive essentially optimizes it into a loop
	 *  where that does not add stack frames. so the state 
	 *  is only available in the params
	 */
	def lengthTailRecursive[A](ls: List[A]) : Int = {
	  def lengthR(result: Int, curList: List[A]): Int = curList match {
	    case Nil 		=> result
	    case _ :: tail	=> lengthR(result + 1, tail)
	  }
	  
	  lengthR(0, ls) // get it started
	}
	
	// more pure functional solution, with folds
	def lengthFunctional[A](ls:List[A]) : Int = ls.foldLeft(0) { (c, _) => c + 1 }
	
	/*
	 * What is foldLeft? 
	 * signature: def foldLeft[B](z: B)(f: (B,A) => B) : B
	 * 
	 * so what the above does is:
	 * 
	 *  - start at 0, foldLeft(0), c=0
	 *  - for every element add: +1 to c 
	 * 
	 */
	
	val ls = List(1,2,3,4,5)
	Console.println("lengthBuiltin: "  + lengthBuiltin(ls));
	Console.println("lengthRecursive: " + lengthRecursive(ls))
	Console.println("lengthTailRecursive: " + lengthTailRecursive(ls));
}