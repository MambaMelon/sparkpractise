package scala.practise05

/**
  * Created by Melon on 2017/12/27.
  */
object Api01 extends App {
  val l = List(1,2,3,4)
  //fold
  val l1 = l.fold(1)(_ * _)
  //forall 【全部为true则返回true，否则返回的是false】
  val l2 = l.forall(x => x%2 == 0)
  //groupBy 【返回false -> ..., true -> ...】
  val l3 = l.groupBy(x => x%2 == 0 )
  //headOption
  val l4 = l.headOption
  //init 【选择除最后一个元素以外的所有元素】
  val l5 = l.init
  //maxBy 【若为一个类时，可指定类的具体属性进行比较】
  val l6 = l.maxBy(x => x)
  //partition 【(List(2, 4),List(1, 3))】
  val l7 = l.partition(x => x%2 == 0)
  //scan  【List(1, 2, 4, 7, 11)】
  val l8 = l.scan(1)(_ + _)
  //slice  【切割操作】
  val l9 = l.slice(0,2)
  //span 【(List(),List(1, 2, 3, 4))碰到不符合条件的就结束】
  val l10 = l.span(_%2 == 0)
  println(l.tail)
}
