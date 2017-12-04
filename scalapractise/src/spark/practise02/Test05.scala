package spark.practise02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by admin on 2017/12/4.
  */
object Test05 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test03").setMaster("local")
    val sc = new SparkContext(conf)

    //mean
    val m = sc.parallelize(List(1,2,3))
    val resm = m.mean   //2.0

    //leftOuterJoin
    //ArrayBuffer((B,(2,None)), (A,(1,Some(a))), (C,(3,Some(c))))
    val rdd1 = sc.makeRDD(Array(("A","1"),("B","2"),("C","3")),2)
    val rdd2 = sc.makeRDD(Array(("A","a"),("C","c"),("D","d")),2)
    val resloj = rdd1.leftOuterJoin(rdd2).collect()

    //rightOuterJoin
    //ArrayBuffer((D,(None,d)), (A,(Some(1),a)), (C,(Some(3),c)))
    val resroj = rdd1.rightOuterJoin(rdd2).collect()

    println(resroj.toBuffer)
  }
}
