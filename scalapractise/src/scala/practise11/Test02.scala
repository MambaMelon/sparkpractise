package scala.practise11

import breeze.util.partition

/**
  * Created by Melon on 2017/12/17.
  */
object Test02 {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
    //(2,4)  (1,3,5)  扫描所有
    val (p1, p2) = list.partition(_%2 == 0)
    //(1, 2)   (3, 4, 5)   遇到不符合条件的即结束扫描
    val (s1, s2) = list.span(_ < 3)
    //(1,2)   (3,4)
    val (l1, l2) = List(1,2,3,4).splitAt(2)

    val map = collection.mutable.Map(1->1,2->2,3->3)
    //Map(2 -> 0, 1 -> 0, 3 -> 0)
    map.transform((x,y) => 0)
    //Map(2 -> 20, 1 -> 10, 3 -> 30)
    map.transform((x,y) => x*10)
    //Map(2 -> 12, 1 -> 11, 3 -> 13)
    map.transform((x,y) => y+10)
    println(map)
  }
}
