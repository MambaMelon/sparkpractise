package scala.practise11

import scala.util.Sorting
import scala.util.Sorting.quickSort

/**
  * 自定义排序：Ordering与Ordered
  * Created by Melon on 2017/12/14.
  */
object Test01 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,3,4,5,2)
    quickSort(arr)

    val pairs = Array(("a",5,3),("c",3,1),("b",1,3))
//    根据第二个元素排序
    quickSort(pairs)(Ordering.by[(String, Int, Int), Int](_._2))
//    根据第三个元素，以及第一个元素排序
    quickSort(pairs)(Ordering[(Int, String)].on(x => (x._3, x._1)))

    val p1 = Person("rain", 13)
    val p2 = Person("rain", 14)
    val p3 = Person("lily", 15)
    val list = List(p1, p2, p3)

    implicit object PersonOrdering extends Ordering[Person] {
      override def compare(p1: Person, p2: Person): Int = {
        p1.name == p2.name match {
          case false => -p1.name.compareTo(p2.name)
          case _ => p1.age - p2.age
        }
      }
    }
    //需要指定隐式函数
    list.sorted

    list.sortWith{(p1: Person, p2: Person) => p1.name == p2.name match {
      case false => -p1.name.compareTo(p2.name) < 0
      case _ => p1.age - p2.age < 0
    }}

    //需要指定隐式函数
    list.sortBy[Person](t => t)

  }
}
case class Person(name: String, age: Int){
  override def toString: String = {
    "name: " + name + ", age: " + age
  }
}

