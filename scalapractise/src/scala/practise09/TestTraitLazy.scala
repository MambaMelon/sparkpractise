package scala.practise09

/**
  * Created by admin on 2018/1/5.
  */

trait Fruit {
  val name: String
  val commPrint = println("commPrint: " + name)
  lazy val lazyPrint = println("lazyPrint: " + name)
  def defPrint = println("defPrint: " + name)
}

object TestTraitLazy extends App {

  //commPrint: null
  val apple1 = new Fruit {
    val name = "Apple"
  }
  //lazyPrint: Apple
  apple1.lazyPrint
  //defPrint: Apple
  apple1.defaPrint

  //commPrint: Apple
  val apple2= new {
    val name = "Apple"
  } with Fruit
}
