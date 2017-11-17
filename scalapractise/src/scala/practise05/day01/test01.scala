package scala.practise05.day01

/**
  * Created by Melon on 2017/11/17.
  */

object test01 {
  def main(args: Array[String]): Unit = {

    val x = -1
    val s = if(x>0) 1 else -1

    //1.高级for循环
//    for(i <- -1 to 3; j<- -1 to 3)
//    for(i <- -1 to 3; j <- -1 to 3 if i != j)
//    for(i <- 1 to 3; from = 4 - i; j <- from to 3)
      //for循环推导式
//    val l1 = for(i <- 1 to 3; j <- 1 to 3) yield i*j

    //2.变长参数
    def sum(args: Int*) = {
      var result = 0
      for(arg <- args) result += arg
      result
    }
    var summ = sum(1,2,3)
    var summm = sum(1 to 3: _*)

    //3.lazy关键字延迟初始化，直到调用才初始化
    lazy val te = "hello"

    //4.利用yield生成一个集合
    val list = List(2,-1,3,-4,9)
    var b = true
    val l2 = for(i <- 0 until list.length) yield {
      if(list(i) < 0)
        list(i)
    }

    //5.以指定分隔符显示字符串
    val l3 = list.mkString(",")
    println(l3)

















  }
}
