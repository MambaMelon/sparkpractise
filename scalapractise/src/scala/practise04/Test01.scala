package scala.practise04

/**
  * Created by Melon on 2017/11/17.
  *
  * 常用操作符
  */
object Test01 {

  def main(args: Array[String]): Unit = {
    val l1 = List(1, 2, 3)
    val l2 = List(4, 5)
    //列表尾部添加另一列表
    println(l1 ++ l2)
    println(l1 ++: l2)
    println(l2.++:(l1))
    println(l2.:::(l1))
    //头部添加元素
    println(0 +: l1)
    println(l1.+:(0))
    println(0 :: l1)
    println(l1.::(0))





  }

}
