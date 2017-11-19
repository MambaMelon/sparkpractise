package scala.practise06

/**
  * Created by Melon on 2017/11/19.
  *
  * 继承
  */
class People {

  //01.重写一个非抽象方法，必须使用override关键字
  override def toString: String =   "name[=" + getClass.getName + "]"

}
