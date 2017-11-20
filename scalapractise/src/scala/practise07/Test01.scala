package scala.practise07

/**
  * Created by Melon on 2017/11/20.
  *
  * 高阶函数
  */
object Test01 {
  def main(args: Array[String]): Unit = {

    val s = "i love scala, no way!".split(" ").sortWith(_.length < _.length)

    val prices = List(5.0, 20.0)
    val quant = List(10, 2)
    //拉链操作求价钱
    val p = (prices zip quant).map(x => x._1 * x._2)
    //返回字符串中最大字符的下标值
    val c = "scala".zipWithIndex.max._2
    println(c)

  }
}































