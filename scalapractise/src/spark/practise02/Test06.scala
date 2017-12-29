package spark.practise02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * combineByKey
  * groupBy
  * keyBy
  * lookUp
  *
  * Created by admin on 2017/12/29.
  */
object Test06 extends App {
  val conf = new SparkConf().setAppName("Test06").setMaster("local")
  val sc = new SparkContext(conf)

  //combineByKey
  val a1 = sc.parallelize(List("dog", "bee", "cat", "bee", "dog"))
  val b1 = sc.parallelize(List(1, 2, 1, 3, 2))
  val baRdd = b1.zip(a1)
  val ba = baRdd.combineByKey(List(_), (x: List[String], y: String) => y :: x, (x: List[String], y: List[String]) => y ::: x)

  val abRdd = sc.parallelize(List((1, "www"), (1, "iteblog"), (1, "com"), (2, "bbs"), (2, "iteblog"), (2, "com"), (3, "good")))
  val cRdd = abRdd.combineByKey(
    List(_),
    (x: List[String], y: String) => y :: x,
    (x: List[String], y: List[String]) => x ::: y)

  //groupBy
  val a2 = sc.parallelize(1 to 10, 2)
  val gRdd = a2.groupBy(x => {if(x % 2== 0) "even" else "odd"})

  //keyBy
  val kbRdd = a1.keyBy(x => 1)

  //lookUp
  val lRdd = kbRdd.lookup(3)

  println(gRdd.toDebugString)
}
