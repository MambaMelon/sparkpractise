package spark.practise04

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Melon on 2017/12/17.
  */
object Sougou {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test01").setMaster("local")
    val sc = new SparkContext(conf)

    val sogou = sc.textFile("D://SogouQ.txt")
    //日志的第四列以及第五列都为1
    val sogourdd = sogou.map(_.split("\t")).filter(_(3).toInt == 1).filter(_(4).toInt == 1)
    println(sogourdd.count)
  }
}
