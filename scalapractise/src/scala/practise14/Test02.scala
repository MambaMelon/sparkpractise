package scala.practise14

/**
  * Created by Melon on 2017/12/29.
  */

class Foo
trait TypeHolder[T] {
  type ElementType = T
}
class FooTypeHolder extends TypeHolder[Foo]
class Client[T <: TypeHolder[_]](val holder: T) {
  def showElementType(t: T#ElementType): Unit = {
    println("show element type " + t.toString)
    println(t.getClass)
  }
}

object Test02 extends App {

//  val list = List[(Int, Int)]((9, 4), (1, 5), (4, 6))
//  val res = list.map({
//    case (a,b) => a * b
//  }).sum

//  def unapplySeq(email: String):
//    Option[(String, Seq[String])] = {
//    val parts = email split "@"
//    if(parts.length == 2)
//      Some(parts(0), parts(1).split("\\.").reverse)
//    else
//      None
//  }

//    private val foo = new Foo
//    private val holder = new FooTypeHolder
//    private val client = new Client(holder)
//    client.showElementType(foo)

  //val和var修饰可变对象与不可变对象
  val m1 = scala.collection.mutable.Map(('a',1), ('b', 2))
  //可以修改
  m1 += (('c', 3))

  //但是不能指向其它对象，会报错
  //map = scala.collection.mutable.Map(('a',1), ('b', 2))

  var m2 = scala.collection.mutable.Map(('a',1), ('b', 2))
  m2 += (('c', 3))

  val a = Set("element is contained in set")
//  type Set = Int => Boolean
  val b1  = a.contains("element is contained in set")
  val b2 = a.contains("element is not contained in set")
  println(b1)
  def custom_fc(x:Double): scala.collection.immutable.Set[String] = Set(x.toString)
  custom_fc(3.15)





}

