package scala.practise14

/**
  * Created by Melon on 2017/12/29.
  */
object Test01 extends App {

  println(fib(5))
  val list = List(1 to 5)
  list.tail

  //1.1 定义菲波那切数列
  def fib(n: Int): Int = n match {
    case 0 => 2
    case 1 => 1
    case _ => fib(n - 1) + fib(n - 2)
  }

  //2.1 实现判断集合是否为有序集合
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Unit = {
    def go(n: Int): Boolean = {
      if (n >= as.length-1) true
      else if(ordered(as(n),as(n+1))) false
      else go(n+1)
    }
    go(0)
  }

  //3.2 定义tail函数，删除第一个元素
  def tail(list: List[Int]): List[Int] = {

  }
}
