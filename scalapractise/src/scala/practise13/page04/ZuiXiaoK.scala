package scala.practise13.page04

/**
  * 输出n个数中最小的k个
  * Created by admin on 2017/12/26.
  */
object ZuiXiaoK extends App {
  val k = 5
  val list = List(3, 9, 6, 8, -10, 7, -11, 19, 30, 12, 23)
  val sl = list.sorted.take(5)
  println(sl)
}
