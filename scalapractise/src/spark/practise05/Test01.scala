package spark.practise05

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

import scala.util.Sorting

/**
  * Created by Melon on 2018/3/28.
  *
  * 数据样式
  * 2,user2,15200771700,凤凰县,41,男,普通用户,20110108
  * 3,user3,13487837597,吉首市,23,男,普通用户,20110720
  */


object Test01 {
  def main(args: Array[String]): Unit = {
    //1 获取SparkContext环境
    val conf = new SparkConf().setAppName("Test01").setMaster("local")
    val sc = new SparkContext(conf)

    //2 获取本地文件为可操作性的RDD
    val usersRdd = sc.textFile("d:/users.txt")

    //3.1 统计每个地区的人数
    val areaRdd = usersRdd.map(user => {
      val line = user.split(",")
      val area = new String(line(3).getBytes, "UTF-8")
      area
    })
    val pair = areaRdd.map((_, 1)).reduceByKey(_ + _).collect()
    //按第二个元素排序
    Sorting.quickSort(pair)(Ordering.by[(String, Int), Int](_._2))

    //3.2 按手机号前三位统计人数
    val phoneRdd = usersRdd.map(user => {
      val line = user.split(",")(2)
      val phone = line.substring(0, 3)
      phone
    })
    phoneRdd.map((_, 1)).reduceByKey(_ + _).sortByKey()
  }

}
