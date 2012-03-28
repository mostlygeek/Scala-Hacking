// P01 (*) Find the last element of a list.
//     Example:
//     scala> last(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 8

// The start of the definition of last should be
//     def last[A](l: List[A]): A = ...
// The `[A]` allows us to handle lists of any type.

object P01 {
	/**
	 * this uses the built in scala .last which
	 * is probably the best way
	 */
	def lastBuiltin[A](ls: List[A]): A = ls.last
	
	def lastRecursive[A](ls: List[A]) : A = ls match {
	  case h :: Nil => h
	  case _ :: tail => lastRecursive(tail)
	  case _ => throw new NoSuchElementException
	}
}