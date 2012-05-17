package CasePattern

/**
 * trying code examples from Programming in Scala, 
 * chapter on Case Classes... 
 * 
 */

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, Arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

import Console._
object CaseClasses extends App {
	val v = Var("x")
	
	println(v)
	
	// no need to use "new" keyword
	val op = BinOp("+", Number(1), v)
	println(op)
	
	// args automatically become 'val's
	println(op.left)
	
	/*
	 * compile adds 'natural' implementations of toString, 
	 * hashCode and equals to the case class...
	 */
	val theyEqual = (v == Var("x"))
	println("v = Var(\"x\"): " + theyEqual)
	
	// to make an new object, the copy() method is available
	println(op.copy(operator = "-"))
	
	
}