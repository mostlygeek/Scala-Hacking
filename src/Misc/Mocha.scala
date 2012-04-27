package Misc

// from the Programming in Scala book, 
// Listing 21.6
object Mocha extends App {

	class PreferredDrink(val preference: String)
	
	implicit val pref = new PreferredDrink("mocha")
	
	def enjoy(name: String)(implicit drink: PreferredDrink) {
		print("Welcome, " + name)
		print(". Enjoy a ")
		print(drink.preference)
		println("!")
	}
	
	enjoy("reader") // ("mocha") is implicit
	
}