package scala.practise01

/**
  * Created by ThinkPad on 2017/11/12.
  */
object MapOperation {

  def main(args: Array[String]): Unit = {
    //创建map
    val map1 = Map("zhang" -> 50, "li" -> 60)
    val map2 = Map(("zhang", 50), ("li", 60))
    //列表转换为元组
    val map3 = Array(("zhang", 50),("li", 60),("hua", 70)).toMap
    //拉链命令
    val key = Array("zhang", "li", "hua")
    val value = Array(50, 60, "hua")
    print(key.zip(value).toBuffer)
  }

}
