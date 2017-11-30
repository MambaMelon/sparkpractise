package spark.practise02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Melon on 2017/11/27.
  */
object Test03 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test03").setMaster("local")
    val sc = new SparkContext(conf)

    //flatMapValues
    val fmv = sc.parallelize(List("dog"), 2)
    val resFmv = fmv.map(x => (x.length, x)).flatMapValues("x" + _ + "x")  //ArrayBuffer((3,x), (3,d), (3,o), (3,g), (3,x))

    //fold
    val fd = sc.parallelize(List(1,2,3),3)
    val resFd = fd.fold(1)(_ + _)   //10

    //foreachPartition
//    val resfp = fd.foreachPartition(x => println(x.reduce(_ + _)))  // 1   2   3

    //foreachWith?

    //glom
    val gm = sc.parallelize(List(1 to 6))
    val resgm = gm.glom().collect()

    println()

  }

}























