package scala.practise06

/**
  * Created by Melon on 2017/11/19.
  */
class Employee extends People {

  //01.People.toString
  override def toString: String = super.toString

  //03.在子类中重写超类中的抽象方法时，不需要override关键字

  //04.抽象字段是一个没有初始值的字段
//  val name: String
}

object Employee {
  def main(args: Array[String]): Unit = {
    //02.检查对象是否属于某个类
    val e = new Employee
    if(e.isInstanceOf[People]){
      val s = e.asInstanceOf[Employee]
      println("是子类")
    } else {
      println("不是子类")
    }



  }
}
