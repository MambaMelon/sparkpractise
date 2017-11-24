package spark.practise02

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
  * Created by Melon on 2017/11/23.
  */

case class ScoreDetail(studentName: String, subject: String, score: Float)

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
    val res02 = rdd02.combineByKey(
      (x => x),
      ((x: Int, y:Int) => x + y),
      ((x:Int, y: Int) => x + y)).collect()

    //计算平均成绩
    /**
      * createCombiner: (x: ScoreDetail) => (x.score, 1)这是第一次遇到zhangsan，创建一个函数，
      * 把map中的value转成另外一个类型 ，这里是把(zhangsan,(ScoreDetail类))转换成(zhangsan,(91,1))
      * mergeValue: (acc: (Float, Int), x: ScoreDetail) => (acc._1 + x.score, acc._2 + 1) 再次碰到
      * 张三， 就把这两个合并, 这里是将(zhangsan,(91,1)) 这种类型 和 (zhangsan,(ScoreDetail类))这种
      * 类型合并，合并成了(zhangsan,(171,2))mergeCombiners (acc1: (Float, Int), acc2: (Float, Int))
      * 这个是将多个分区中的zhangsan的数据进行合并， 我们这里zhansan在同一个分区，这个地方就没有用上
      */
    val scores = List(ScoreDetail("xiaoming", "Math", 98), ScoreDetail("xiaoming", "English", 88),
      ScoreDetail("wangwu", "Math", 75), ScoreDetail("wangwu", "English", 78), ScoreDetail("lihua", "Math", 90),
      ScoreDetail("lihua", "English", 80), ScoreDetail("zhangsan", "Math", 91), ScoreDetail("zhangsan", "English", 80))

    val scoresWithKey = for(i <- scores) yield (i.studentName, i)

    val scoresWithKeyRDD = sc.parallelize(scoresWithKey).partitionBy(new HashPartitioner(3)).cache

    val avgScoresRDD = scoresWithKeyRDD.combineByKey(
      (x: ScoreDetail) => (x.score, 1),
      (acc: (Float, Int), x: ScoreDetail) => (acc._1 + x.score, acc._2 + 1),
      (acc1: (Float, Int), acc2: (Float, Int)) => (acc1._1 + acc2._2, acc1._2 + acc2._2)
    ).map({ case(k, v) => (k, v._1/v._2) }).collect()

    //单词统计
    val animal = sc.parallelize(List("dog","cat","gnu","salmon","rabbit","turkey","wolf","bear","bee"), 3)
    val num = sc.parallelize(List(1,1,2,2,2,1,2,2,2), 3)
    val anRDD = num.zip(animal)
    val result = anRDD.combineByKey(List(_), (x:List[String], y:String) => y::x, (x:List[String], y:List[String]) => x:::y).collect()

    println(anRDD.collect().toBuffer)
    println(result.toBuffer)

  }

}
