package Yammer

object Collections extends App {
	import Console.println;
	val iterations = 100000
	
	val smHM = new scala.collection.mutable.HashMap[Int, Int]
	var i = 0; 
	val startMutableHM = System.currentTimeMillis()	
	while (i < iterations) { i=i+1; smHM.put(i, i)}	
	println("Scala Mutable Hashmap: " + (System.currentTimeMillis() - startMutableHM) + "ms")
	
	val smcHM = new scala.collection.parallel.mutable.ParHashMap[Int, Int]
	val startMutableCHM = System.currentTimeMillis()
	i=0
	while (i < iterations) { i=i+1; smcHM.put(i, i)}
	println("Scala Parallel Mutable Hashmap: " + (System.currentTimeMillis() - startMutableCHM) + "ms")
	
	val jm = new java.util.HashMap[Int,Int]	
	var startJavaMutableHM = System.currentTimeMillis()
	i=0
	while (i < iterations) { i=i+1; jm.put(i,i)}
	
	println("Java Mutable Hashmap:" + (System.currentTimeMillis() - startJavaMutableHM) + "ms")
	
	val jmc = new java.util.concurrent.ConcurrentHashMap[Int, Int]
	val startJavaConcurrentHM = System.currentTimeMillis()
	i=0
	while (i < iterations) { i=i+1; jmc.put(i, i) }
	
	println("Java Concurrent Mutable Hashmap:" + (System.currentTimeMillis() - startJavaConcurrentHM) + "ms")
	
}