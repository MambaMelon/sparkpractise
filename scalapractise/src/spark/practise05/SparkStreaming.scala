package spark.practise05

import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
  * SparkStreaming操作
  * Created by admin on 2017/12/20.
  */
object SparkStreaming {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("SparkStreaming")
    val ssc = new StreamingContext(conf, Seconds(1))

    //基于RDD队列流
    val rddQueue = new mutable.SynchronizedQueue[RDD[Int]]()
    val inputStream = ssc.queueStream(rddQueue)
    val mappedStream = inputStream.map(x => (x%10, 1))
    val reduceStream = mappedStream.reduceByKey(_ + _)
    reduceStream.print
    ssc.start()
    for(i <- 1 to 30){
      rddQueue += ssc.sparkContext.makeRDD(1 to 100, 20)
      Thread.sleep(1000)
    }
    ssc.stop()
  }
}
