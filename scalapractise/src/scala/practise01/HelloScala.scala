package scala.practise01

/**
  * Created by ThinkPad on 2017/11/12.
  */
object HelloScala {

  //定义方法
  def m1(a1: Int, a2: Int): Int = a1 + a2

  //定义函数
  val f1 = (a1: Int, a2: Int) => a1 + a2

  //特殊的函数
  val f2: Int => String = {
    x => x.toString
  }

  // _ 将方法转换成函数
  val f3 = m1 _
  def main(args: Array[String]): Unit = {


    print(f3(1,1))


  }

}
