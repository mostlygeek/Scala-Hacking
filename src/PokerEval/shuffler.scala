package PokerEval

/**
 * Test out ways to shuffle some cards...
 */
object shuffler extends App {
	
     val cards = 0 to 51
     val shuffled = util.Random.shuffle(cards.toSeq)
     
     // output the new shuffled array
     for (card <- shuffled)
       Console.println(card)
     
     // or we can output it like this     
     shuffled.foreach(card => Console.println(card))
     
     // or even shorter...
     shuffled.foreach(Console.println _)
}