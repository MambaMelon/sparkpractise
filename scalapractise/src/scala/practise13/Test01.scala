package scala.practise13

/**
  * 插入排序
  * Created by Melon on 2017/12/27.
  */
object Test01 extends App {
  val iList = quickSort(List(1,3,4,2,5))
  println(iList)

  //插入排序
  def inertSort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    def insert(x: T, xs: List[T]): List[T] = xs match {
      case List() => List(x)
      case y :: ys => if(ord.lt(x, y))x :: xs else y :: insert(x, ys)
    }
    xs match {
      case List() => xs
      case x :: xs1 => insert(x, inertSort(xs1))
    }
  }

  //快速排序
  def quickSort[T <% Ordered[T]](list: List[T]): List[T] = list match {
    case Nil => Nil
    case x :: xs =>
      val (before, after) = xs.partition(_ < x)
      quickSort(before) ++ (x::quickSort(after))
  }


}
