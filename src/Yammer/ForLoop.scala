package Yammer

object ForLoop extends App {
	
	val iterations = 10000000
	val forStart = System.currentTimeMillis();
	var total:Long = 0
	for (i <- 0 until iterations) total += i
	
	val forEnd = System.currentTimeMillis() - forStart
		
	Console.println(forEnd)
	Console.println(total)
		
	val whileStart = System.currentTimeMillis()
	var total2:Long = 0
	var i = 0
	while (i < iterations) {
	  total2 += i
	  i += 1
	}
	val whileEnd = System.currentTimeMillis() - whileStart
	
	Console.println(whileEnd)
	Console.println(total2)
	
	val diff = scala.Math.abs(whileEnd - forEnd)
	if (whileEnd > forEnd) 
		Console.println("whileTime slower by: " + diff + "ms")
	else if (forEnd > whileEnd)
		Console.println("forTime slower by: " + diff + "ms")
	else 
		Console.println("whileTime and fortime are equal")
	  
}