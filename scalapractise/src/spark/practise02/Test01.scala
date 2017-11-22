package spark.practise02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Melon on 2017/11/23.
  */
object Test01 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test01").setMaster("local")
    val sc = new SparkContext(conf)

    /**
      * combineByKey
      * 1.聚合前后K不变，V变为C
      */
    //求平均数
    val initialScores = Array(("Fred", 88.0), ("Fred", 95.0), ("Fred", 93.0), ("Wilma", 95.0), ("Wilma", 98.0))
    val rdd01 = sc.parallelize(initialScores)
    type MVType = (Int, Double)
    val res01 = rdd01.combineByKey(
      score => (1, score),
      (c1: (Int, Double), newScore: Double) => (c1._1 + 1, c1._2 + newScore),
      (c1: (Int, Double), c2: (Int, Double)) => (c1._1 + c2._1, c1._2 + c2._2)
    ).map{ case (name, (num, score)) => (name, score/num) }.collect()

    //单词计数
    val rdd02 = sc.parallelize(List(("iteblog", 1), ("bbs", 1), ("iteblog", 3)))
    val res02 = rdd02.combineByKey(x => x, (x: Int, y:Int) => x + y, (x:Int, y: Int) => x + y).collect()



    println(res02.toBuffer)




  }

}
