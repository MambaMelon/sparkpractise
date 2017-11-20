package scala.practise07

import scala.io.Source

/**
  * Created by Melon on 2017/11/20.
  *
  * 文件操作
  */

object FileOperation1 {
  def main(args: Array[String]): Unit = {

    //指定源文件
    val source = Source.fromFile("f://test.txt", "UTF-8")

    //读取一行
//    val lines = source.getLines();
//    for(line <- lines){ }

    //读取单个字符
//    val buffered = source.buffered
//    while(buffered.hasNext){
//      print(buffered.next())
//    }

    //将文件内容作为一个字符展示
    val contents = source.mkString
    println(contents)

    //04.关闭
    source.close()


  }

}
