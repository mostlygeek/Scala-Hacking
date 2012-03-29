// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)
object P07 extends App {
	
	/**
	 * this example is a pretty advanced scala problem, it 
	 * requires that you know some of the more terse scala syntax
	 */
	def flatten(ls: List[Any]): List[Any] = ls flatMap 	   // 1 
	{   												   // 2
	  case ms : List[_] => flatten(ms)					   // 3
	  case e  => List(e)								   // 4
	}
	
	
	/**
	 * what the heck does the above do? 
	 * 
	 * 1. What is flatMap()?
	 *  def flatMap[B](f: (A) => List[B]): List[B]
	 *  
	 *  - apply function f to each element 
	 *  - f should return List[B]
	 *  - takes all those lists and flattens them into one List
	 *  
	 * 2. This is the start of the "function"
	 * 
	 * 3. Checks if it is an embedded list, so basically if type is a
	 *    List[List[Any]], return (recursive) flatten(ms). 
	 *    
	 *    - ms is just a reference to the value
	 *    - "_" is the first parameter passed to this function, in this
	 *      case the element
	 *      
	 *    
	 * 
	 * 4. if it is a value, convert it into List and return it
	 * 
	 */
		
	Console.println("Flatten Example: " + flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
}