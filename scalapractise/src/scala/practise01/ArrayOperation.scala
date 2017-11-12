package scala.practise01

import scala.collection.mutable.ArrayBuffer

/**
  * Created by ThinkPad on 2017/11/12.
  */
object ArrayOperation {

  val f1 = (x: Int) => x*x

  def main(args: Array[String]): Unit = {

    //声明数组,必须指明长度
    val arr1 = new Array[Int](2)
    //声明并赋值
    val arr2 = Array[Int](1, 2, 3, 4, 5)
    //缓冲数组追加元素
    val arr3 = ArrayBuffer[Int](1,2)
    arr3 += 3
    arr3 += (4, 5)
    arr3 ++= Array(6, 7)
    arr3 ++= ArrayBuffer(8, 9, 10)
    //去掉某个元素
    arr3.remove(2, 1)  //2是位置指数，1是共删除后面几个元素
    arr3.insert(2, 11, 12, 13)
    //map操作数组
    val arr4  = arr3.map(_ * 10)
    //数组循环
    for(i <- (0 until arr4.length)){}
    for(i <- arr4) {}
    //排序
    val arr5 = arr4.sortWith(_>_)
    val arr6 = arr4.sortWith((x, y) => x>y)
    print(arr6.toBuffer)

  }

}
