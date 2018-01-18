package spark.practise04

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 找出共同好友
  * A:B,C,D,F,E,O
  * B:A,C,E,K
  * C:F,A,D,I
  * D:A,E,F,L
  * E:B,C,D,M,L
  * F:A,B,C,D,E,O,M
  * G:A,C,D,E,F
  * H:A,C,D,E,O
  * I:A,O
  * J:B,O
  * K:A,C,D
  * L:D,E,F
  * M:E,F,G
  * O:A,H,I,J
  * Created by admin on 2018/1/18.
  */
object CommonFriends {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test01").setMaster("local")
    val sc = new SparkContext(conf)

    val friRdd = sc.textFile("D://friends.txt")

    val friKVRdd = friRdd.map(x => {
      val fields = x.split(":")
      val person = fields(0)
      val friends = fields(1).split(",").toList
      (person, friends)
    })

    val mapRdd = friKVRdd.flatMap(x => {
      for(i <- 0 until x._2.length) yield (x._2(i), x._1)
    })

    val reduceRdd = mapRdd.reduceByKey(_ + "::" + _)
    println(reduceRdd.collect().toBuffer)
  }

}
