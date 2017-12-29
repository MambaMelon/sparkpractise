package scala.practise13

/**
  * 插入排序
  * Created by Melon on 2017/12/27.
  */
object Test01 extends App {
  val iList = isort(List(1,3,4,2,5))
  println(iList)

  def isort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    def insert(x: T, xs: List[T]): List[T] = xs match {
      case List() => List(x)
      case y :: ys => if(ord.lt(x, y))x :: xs else y :: insert(x, ys)
    }
    xs match {
      case List() => xs
      case x :: xs1 => insert(x, isort(xs1))
    }
  }

//  def insertSort(list: List[Int]): List[Int] = {
//    if(list.isEmpty)
//      Nil
//    else
//      insert(list.head, insertSort(list.tail))
//    def insert(x: Int, list: List[Int]): List[Int] = {
//      if(list.isEmpty || x<=list.head) x :: list
//      else list.head :: insert(x, list.tail)
//    }
//  }
}
