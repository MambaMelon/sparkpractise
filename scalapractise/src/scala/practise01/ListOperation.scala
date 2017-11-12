package scala.practise01

import scala.collection.mutable.ListBuffer

/**
  * Created by ThinkPad on 2017/11/12.
  */
object ListOperation {
  def main(args: Array[String]): Unit = {
    //不可变的集合
    val l1 = List(1,2)
    //集合最前面插入元素
//    val l2 = 0::l1
//    val l2 = l1.::(0)
//    val l2 = 0 +: l1
    val l2 = l1.+:(0)

    //可变的ListBuffer
    val l3 = ListBuffer[Int]()
    l3.append(1,2,3,4,5)
    l3(0) = 6
    print(l3)
  }

}
