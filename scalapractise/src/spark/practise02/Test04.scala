package spark.practise02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by admin on 2017/12/1.
  */
object Test04 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Test03").setMaster("local")
    val sc = new SparkContext(conf)

    //groupBy
    val gb = sc.parallelize(1 to 9, 3)
    val resgb = gb.groupBy(x => {if (x % 2 == 0) "even" else "odd"})

    //groupByKey
    val gbk = sc.parallelize(List("one","two","two","three","three","three"))
    val pairgbk = gbk.map(x => (x, 1))
    val resgbk = pairgbk.groupByKey().map(x => (x._1, x._2.sum))

    //keyBy
    //ArrayBuffer((3,one), (3,two), (3,two), (5,three), (5,three), (5,three))
    val reskb = gbk.keyBy(_.length)

    //join
    //ArrayBuffer((3,one), (3,two), (3,two), (5,three), (5,three), (5,three))
    val j1 = sc.parallelize(List("one","two","three"))
    val resj1 = j1.keyBy(_.length)
    val j2 = sc.parallelize(List("one","three"))
    val resj2 = j2.keyBy(_.length)
    val ress = resj2.join(resj1)

    //mapPartitions
    //ArrayBuffer((3,6), (2,4), (1,2), (6,12), (5,10), (4,8), (9,18), (8,16), (7,14))
    val mp = sc.parallelize(1 to 9, 3)
    def mpFunc(iter: Iterator[Int]) : Iterator[(Int, Int)] = {
      var res = List[(Int, Int)]()
      while(iter.hasNext){
        val cur = iter.next()
        res.::= (cur, cur*2)
      }
      res.iterator
    }
    val resmp = mp.mapPartitions(mpFunc)


    println(ress.collect().toBuffer)
  }

}
