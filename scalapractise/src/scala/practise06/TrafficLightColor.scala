package scala.practise06

/**
  * Created by Melon on 2017/11/18.
  *
  * 枚举
  */
object TrafficLightColor extends Enumeration {

  val Red, Yellow, Green = Value

  def main(args: Array[String]): Unit = {
    //01.初始化
//    val Red = Value
//    val Yellow = Value
//    val Green = Value

    //02.也可以传入id以及名称两个参数
    val Red = Value(0, "Stop")
    val Yellow = Value(10)
    val Green = Value("Start")  //id为11

  }
}











