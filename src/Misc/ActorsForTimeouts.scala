package Misc

import actors.{Actor, TIMEOUT}

// ref: http://stackoverflow.com/a/1226841/445792 
object ActorsForTimeouts extends App {  

	// from the SO answer...
	def scheduler(time: Long)(f: => Unit) = {
	  def fixedRateLoop { // <- scala workaround for tail recursion on the JVM
	    Actor.reactWithin(time) {
	      case TIMEOUT => f; fixedRateLoop
	      case 'stop => 
	    }
	  }
	  Actor.actor(fixedRateLoop)
	}
	
	// ported to run only once... :b
	def runIn(time: Long)(f: => Unit) = {
	  Actor.actor({
		  Actor.reactWithin(time) {
		    case TIMEOUT => f;
		    case 'abort =>
		  }	    
	  })
	}
	
	val interval:Long = 500
	
	Console.println("Start, output ever ~" + interval + "ms")
	val start = System.currentTimeMillis
	
	for (i <- 0 to 5) {
		runIn(interval * i) { Console.println("Diff " + i + ": " + (System.currentTimeMillis - start))}	  
	}
}