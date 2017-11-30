package scala.practise08

/**
  * Created by Melon on 2017/11/29.
  */
trait Human {
  def hello = "the Human trait"

  //给方法添加默认参数
  def makeConnection(port: String="8080")

  //返回多个值得方法
  def getStockInfo = {
    ("NFLX", 100, 3000)
  }

  //创建参数个数可变的方法
  def printAll(strs: String*){ }    //调用时，使用_*来适配一个序列
}

trait Mother extends Human {
  override def hello = "Mother trait"
}

trait Father extends Human {
  override def hello = "Father trait"
}

//class Child extends Human with Father with Mother {
//  def printSuper = super.hello
//  def printMother = super[Mother].hello
//  def printFather = super[Father].hello
//  def printHuman = super[Human].hello
//}

object Test extends App {
//  val c = new Child
//  println(s"${c.printSuper}")
    // 变量依次赋值给a1/a2/a3
//  val(a1,a2,a3) = h.getStockInfo
}

