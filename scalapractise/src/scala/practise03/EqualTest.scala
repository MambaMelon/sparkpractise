package scala.practise03

/**
  * scala中的判断相等
  */

case class Bread(brand:String, price:Int)

object EqualTest extends App {
  val b1 = Bread("BreadTalk", 50)
  val b2 = Bread("BreadTalk", 50)
  //判断引用是否相等 false
  println(b1.eq(b2))
  //判断值是否相等 true
  println(b1.equals(b2))

  //Array和Map需要调用方法sameElements方法进行判断
  val arr1 = Array(1,2)
  val arr2 = Array(1,2)
  //true
  println(arr1.sameElements(arr2))
}