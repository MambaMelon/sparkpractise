package scala.practise02

/**
  * Created by ThinkPad on 2017/11/14.
  */
object Dog {

  //apply方法的使用
  def apply(): Unit = {
    println("无参数")
  }

  def apply(name: String): Unit = {
    println("有参数")
  }
  def main(args: Array[String]): Unit = {
    val d = Dog("ni")
    println(d)
  }

}
