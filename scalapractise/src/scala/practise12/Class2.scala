package scala.practise12

import scala.collection.mutable.ArrayBuffer

/**
  * 扩大内部类作用域方式之一：类型投影
  * Created by Melon on 2017/12/20.
  */
object Class2 {
  def main(args: Array[String]): Unit = {
    val c1 = new Class2
    val leo = c1.register("leo")
    c1.students += leo

    val c2 = new Class2
    val jack = c2.register("jack")
    c1.students += jack
  }
}
class Class2 {
  class Student(val name: String)
  val students = new ArrayBuffer[Class2#Student]
  def register(name: String) =  {
    new Student(name)
  }
}
