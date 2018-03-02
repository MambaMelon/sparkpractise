package scala.practise13.page04

/**
  * 删除公共字符串
  * Created by Melon on 2017/12/24.
  */
object DeleteZiFu extends App {
  val str = "They are students"
  val word = "aeiou"
  val newStr = str.replaceAll("[" + word.toSet + "]", "")
  println(newStr)
}
