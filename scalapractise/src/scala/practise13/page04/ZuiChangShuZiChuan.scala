package scala.practise13.page04

/**
  * Created by admin on 2018/3/2.
  * 读入一个字符串str，输出字符串str中的连续最长的数字串
  */
object ZuiChangShuZiChuan extends App {
  var str = new StringBuilder("w123eeee2323ewed")
  var count = 0
  var len = 0
  var end  = 0
  for(i <- 0 until str.size){
    if(str(i).isDigit){
      count = count + 1
      if(len < count)
        len = count
        end = i
    }else{
      count = 0
    }
  }
  println(str.substring(end-len+1, end+1))

  println("===================================")

  for(i <- 0 until str.size){
    if(str(i).isLetter){
      str(i) = 'L'
    }
  }
  val arr = str.split('L')

}
