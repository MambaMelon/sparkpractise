package scala.practise08

/**
  * Created by Melon on 2017/11/29.
  */
class Animal {

  /**
    * 链式编程：
    * 如果类会被扩展，则返回值定义为this.type
    * 如果不会被扩展，则可省去this.type
    */

  protected var fname = ""
  protected var lname = ""

  def setFirstName(firstName: String): this.type = {
    fname = firstName
    this
  }

  def setLirstName(lastName: String): this.type = {
    lname = lastName
    this
  }

}

class Dog extends Animal {
  protected var role = ""
  def setRole(role: String): this.type = {
    this.role = role
    this
  }
}

object Main extends App{
  val d = new Dog
  //链式变成风格
  d.setFirstName("dang").setLirstName("dang").setRole("dog")
}
