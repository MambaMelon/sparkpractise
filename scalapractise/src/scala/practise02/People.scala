package scala.practise02

/**
  * Created by ThinkPad on 2017/11/14.
  */

//主构造器，直接在类名后加参数
class People {

}

object People{
  def main(args: Array[String]): Unit = {
    val p = new People
    println(p)

    //单例对象
    val singleP = People
    println(singleP)
  }
}
