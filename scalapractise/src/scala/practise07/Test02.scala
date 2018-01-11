package scala.practise07

/**
  * 视界即类型类
  * Created by admin on 2018/1/10.
  */

class Container[A <% Int] {
  def addInt(x: A) = 123 + x
}

class Sum[A](value: A){
  // A =:= B 	A 必须和 B相等
  // A <:< B 	A 必须是 B的子类
  // A <%< B 	A 必须可以被看做是 B
  // def addInt(implicit evidence: A =:= Int) = 123 + value
  // def addInt(implicit evidence: A <%< Int) = 123 + value
  def addInt(implicit evidence: A <:< Int) = 123 + value
}

//视界，在隐式函数可以帮助满足类型推断时，它们允许按需的函数应用
object Test02 extends App {

  implicit def strToInt(x: String) = x.toInt
  val i = (new Container[String]).addInt("123")  //246

//  val j = (new Container[Float]).addInt(3.14F)  compile error



}
