package scala.practise08

/**
  * Created by Melon on 2017/11/27.
  */
case class Person(var age: Int, var sex: String)

object Person{

  def apply() = new Person(0, "no person")
  def apply(age: Int) = new Person(age, "man")

}

object casePersonTest extends App{
  val p1 = Person();
  println(p1.sex+p1.age)
}
