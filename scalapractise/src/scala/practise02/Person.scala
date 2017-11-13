package scala.practise02


/**
  * Created by ThinkPad on 2017/11/14.
  */
class Person {

  val id = "9527"
  var name = "华安"
  var age: Int = 23
  //只能在其伴生对象访问
  private var sex = "男"
  //只能在本类使用
  private[this] var hight: String = "1.75"
  def printHeight(height: String): String = {
    println(height)
    return "Hello World!"
  }

}

//伴生对象
object Person{
  def main(args: Array[String]): Unit = {
    val p = new Person()
    println(p.age)
    println(p.id)
    println(p.name)
    p.sex = "man"
    println(p.sex)
    println(p.printHeight("1.80"))
  }
}
