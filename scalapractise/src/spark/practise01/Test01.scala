package spark.practise01

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Melon on 2017/11/22.
  */
object Test01 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Test01").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(1,2,3,4,5), 1)
    println(rdd1)
    sc.stop()

  }

}
