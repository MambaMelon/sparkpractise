package scala.practise12

/**
  * 扩大内部类作用域方式之一：关键字outer。内部类引用外部类对象
  * Created by Melon on 2017/12/20.
  */
object Class3 {
  def main(args: Array[String]): Unit = {
    val c1 = new Class3()
    val leo = c1.register("leo")
    leo.introduceMyself
  }
}

class Class3 {
  outer => //名随便
  class Student(val name: String) {
    def introduceMyself = "Hello, I'm " + name + ", I'm very happy to join class " + outer
  }
  def register(name: String) =  {
    new Student(name)
  }
}
