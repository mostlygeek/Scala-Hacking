// find out if a list is a palindrome
object P06 extends App 
{
	def useBuiltin[A](ls: List[A]) : Boolean = ls == ls.reverse
	
	private val ls = List(1,2,3,4,5)
	private val ls2 = List(1,2,3,2,1)	
	Console.println("builtin: " + ls + ": " + useBuiltin(ls))
	Console.println("builtin: " + ls2 + ": " + useBuiltin(ls2))	
}