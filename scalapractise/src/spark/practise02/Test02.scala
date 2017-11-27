package spark.practise02

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
  * Created by Melon on 2017/11/24.
  */

object Test02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test01").setMaster("local")
    val sc = new SparkContext(conf)

    //count
    val counts = sc.parallelize(List(1,2,3,4), 3)
    val resCounts = counts.count()

    //countByKey
    val cbk = sc.parallelize(List(("3","cat"),("2","dog"),("3","rabbit"),("2","pig")))
    val resCbk = cbk.countByKey()   //Map(2 -> 2, 3 -> 2)

    //countByValue
    val cbv = sc.parallelize(List(1,1,1,2,3,4,1,6,3,7,8,9,8,8,9))
    val resCbv = cbv.countByValue()   //Map(1 -> 4, 6 -> 1, 9 -> 2, 2 -> 1, 7 -> 1, 3 -> 2, 8 -> 3, 4 -> 1)

    //distinct
    val resDis = cbv.distinct()   //ArrayBuffer(4, 1, 6, 3, 7, 9, 8, 2)

    //collect
    val col = sc.parallelize(List("dog","cat", 3.12, 3))
    val resCol = col.collect({
      case x: String => "is string"
      case x: Int => "is int"
      case _ => "other"
    }).collect()                 //ArrayBuffer(is string, is string, other, is int)


    //flatMap
    val fm = sc.parallelize(1 to 3,2)
    val fm1 = sc.parallelize(List(1,2,3),2)
    val resFw = fm.flatMap(1 to _).collect().toBuffer   //ArrayBuffer(1, 1, 2, 1, 2, 3)
    val resFw1 = fm1.flatMap(x => List(x,x)).collect().toBuffer   //ArrayBuffer(1, 1, 2, 2, 3, 3)


    println(resFw1)

  }

}
