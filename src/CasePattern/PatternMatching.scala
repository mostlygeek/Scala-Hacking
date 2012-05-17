package CasePattern

import Console._
import CasePattern.CaseClasses._

object PatternMatching extends App {
	
    // example of pattern matching against case classes
    def simplifyTop(expr: Expr): Expr = expr match {
        case UnOp("-", UnOp("-", e))  => e	// double negation
        case BinOp("+", e, Number(0)) => e 	// Adding Zero
        case BinOp("*", e, Number(1)) => e  // multiply by 1
        case _ => expr
    }
    println(simplifyTop(UnOp("-", UnOp("-", Var("x")))))
    
    /****
     * Simple pattern matching... just messin' around
     */
    def matchNumber(x :Int) : String = x match {
        case 5 => "five"
        case 4 => "four"
        case 3 => "three"
        case 2 => "two"
        case 1 => "one"
        case _ => "unknown"
    }
    
    for (x <- List(6,5,4,3,2,1,0)) 
        println(matchNumber(x))
        
    // this will throw a MatchError exception
    val results = try {
	    5 match { 
	        case 4 => "four"
	    }                
    } catch {
        case e: MatchError => "!! Match Error"        
	}
    println (results)

    
    /**
     * You can match against anything..
     */
    def describe(x: Any) = x match {
        case 5 => "five"
        case true => "truth"
        case "hello" => "hi"
        case Nil => "the empty list"
        case _ => "something else"
    }
    
    val ls = List[Any](5, true, "hello", Nil, "??")
    ls.foreach { x => println( describe(x) ) }
    	
    /**
     * Using Pattern Guards
     */
    def guardPlay(x: Int) = x match {
        case x if x > 5 =>  "%s is Greater than 5".format(x)
        case x if x == 5 => "%s is Equal to 5".format(x)
        case x if x < 5 && x > 0 => "%s is between 1 and 5".format(x)
        case _ => "%s is zero or less".format(x)
    }
    
    List(0,1,2,3,4,5,6,7).reverse.foreach { x => println(guardPlay(x))}
    
    
}