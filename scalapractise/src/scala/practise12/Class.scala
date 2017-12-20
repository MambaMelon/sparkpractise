package scala.practise12

import scala.collection.mutable.ArrayBuffer

/** 扩大内部类对象作用域
  * Created by admin on 2017/12/20.
  */

object Class {
  class Class {
    class Student(val name: String)
    val students = new ArrayBuffer[Student]()
    def register(name: String) = {
      new Student(name)
    }
  }

  def main(args: Array[String]): Unit = {
    val c1 = new Class
    val leo = c1.register("leo")
    c1.students += leo



  }

}
