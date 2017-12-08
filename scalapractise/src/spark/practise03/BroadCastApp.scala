package spark.practise03

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by admin on 2017/12/8.
  */
object BroadCastApp {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test03").setMaster("local")
    val sc = new SparkContext(conf)

    //(110,huhuniao,ustc)
    mapJoin(sc)


  }

  def mapJoin(sc: SparkContext): Unit ={
    val peopleInfo = sc.parallelize(Array(("110", "huhu"),("110", "huhuniao"), ("222", "loser"))).collectAsMap()
    val broadCastValue = sc.broadcast(peopleInfo)
    val peopleSchoolInfo = sc.parallelize(Array(("110", "ustc", "211"), ("111", "xxxx", "001")))
    peopleSchoolInfo.mapPartitions(iter => {
      val peopleMap = broadCastValue.value
      val arrayBuffer = ArrayBuffer[(String, String, String)]()
      iter.foreach { case (x, y, z) => {
        if (peopleMap.contains(x)) {
          arrayBuffer.+=((x, peopleMap.getOrElse(x, ""), y))
        }
      }
      }

      arrayBuffer.iterator
    }).foreach(println)
//    println(peopleInfo)
  }
}
