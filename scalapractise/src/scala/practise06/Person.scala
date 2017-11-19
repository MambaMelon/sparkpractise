package scala.practise06

import scala.beans.BeanProperty

/**
  * Created by Melon on 2017/11/18.
  */
class Person {

  //01.此时name生成四个方法：
  //name:String
  //name_=(newValue:String): Unit
  //getName():String
  //setName(newValue:String): Unit
  @BeanProperty var name: String = _
  private var age = 13
  private var sex = ""

  //02.辅助构造器：名称为this；第一行必须调用其它构造器
  def this(name: String){
    this()
    this.name = name
  }

  def this(name: String, age: Int){
    this(name)
    this.age = age
  }

  //03.主构造器
  class Person(val name: String, val age: Int){
    println("主构造器")
  }
//  class Person private(...){ }  主构造器变为私有

}

object Person {
  def main(args: Array[String]): Unit = {
    val p = new Person("hua", 25)
    println(p.age)
  }
}
