package scala.practise13

/**
  * 倒排字符串 i am boy => boy am i
  * Created by admin on 2017/12/26.
  */
object DaoPaiZiFuChuan extends App{
  val str = "i am boy.".split(" ")
  var i = 0
  var sb = new StringBuilder
  for(i <- 0 to str.length-1){
    sb.append(str(str.length-1-i)).append(" ")
  }
  println(sb)
}
