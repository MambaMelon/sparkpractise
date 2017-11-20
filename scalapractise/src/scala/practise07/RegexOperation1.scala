package scala.practise07

/**
  * Created by Melon on 2017/11/20.
  */
object RegexOperation1 {

  def main(args: Array[String]): Unit = {

    //构造Regex对象
    val numPattern = "[0-9]+".r
    //如果有反斜杠或者引号，使用""""""包裹即可
    val numsPattern = """\s+[0-9]+\s+""".r
    //将匹配的转化为数组
    val matArr = numPattern.findAllIn("98 hello 99 scala").toArray
    println(matArr.toBuffer)

  }

}
