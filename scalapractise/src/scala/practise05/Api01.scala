package scala.practise05

import scala.collection.GenSeq

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
  //collect 【List(2, 3, 4, 5, seven1)  实现原理是偏函数，与map实现稍有不同】
  val collectList = List(1,2,3,4,"seven")
  val l11 = collectList.collect({
    case i: Int => i + 1
    case i: String => i + 1
  })
  //copyToArray 【将列表的值赋值到数组中】
  val arr1 = new Array[Int](4)
  l.copyToArray(arr1)
  //flatMap  【xs:List(11, 111, 22, 222)】 【ys:Map(1 -> 111, 2 -> 222)】
  val xs = Map("a" -> List(11,111), "b" -> List(22,222)).flatMap(_._2)
  val ys = Map("a" -> List(1 -> 11,1 -> 111), "b" -> List(2 -> 22,2 -> 222)).flatMap(_._2)
  //flatten 【f1:List(1, 2, 3, 1, 2, 3)】【f2:Set(1, 2, 3)】
  val f1 = List(Set(1, 2, 3), Set(1, 2, 3)).flatten
  val f2 = Set(List(1, 2, 3), List(3, 2, 1)).flatten
  //zipWithIndex 【List((1,0), (2,1), (3,2), (4,3))】
  val l12 = l.zipWithIndex
  //zipAll 【如果l长度较短，则用x填充；如果l较长，则用y填充】
  val lx = List("a", "b", "c", "d", "e")
  val x = 0
  val y = '_'
  val l13 = l.zipAll(lx, x, y)
  //lastIndexOfSlice  【没有匹配结果则返回-1】
  val l14 = l.lastIndexOfSlice(GenSeq[Int](1, 5), 0)
  //isDefinedAt  【是否存在某元素】
  val l15 = l.isDefinedAt(3)
  //lift  【存在某元素，返回其指数，不存在，返回None】
  val l16 = l.lift(7)

  println(l16)
}
