package spark.practise02

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Melon on 2017/11/22.
  *
  * aggregate
  * cartesian
  */
object Test07 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Test01").setMaster("local")
    val sc = new SparkContext(conf)
    val func = (index: Int, iter: Iterator[(Int)]) => {
      iter.toList.map(x => "[partID:" + index + ", val: " + x + "]").iterator
    }

    val rdd1 = sc.parallelize(List(1,2,3,4,5,6), 2)
    //打印分区内的值
    val result = rdd1.mapPartitionsWithIndex(func).collect
    //求分区最大值的和
    val res1 = rdd1.aggregate(2)(math.max(_, _), _ + _)   //11

    //输出各分区最长字符串
    val rdd2 = sc.parallelize(List("12","23","345","4567"), 2)
    val res2 = rdd2.aggregate("")((x, y) => math.max(x.length, y.length).toString, (x, y) => x + y)   //24

    //输出各分区最短字符串
    val rdd3 = sc.parallelize(List("12222","23www","3www4","56www"), 2)
    //此处有坑。空字符串的长度为0，toString之后，变成"0"，再求长度时，即为1
    val res3 = rdd3.aggregate("")((x, y) => math.min(x.length, y.length).toString, (x, y) => x + y)   //11
    val res4 = rdd3.aggregate("wwwww")((x, y) => math.min(x.length, y.length).toString, (x, y) => x + y)


    //求笛卡尔积
    val list1 = sc.parallelize(List(1,2,3,4,5))
    val list2 = sc.parallelize(List(6,7,8))
    val res5 = list1.cartesian(list2).collect().toBuffer

    //cogroup
    val a = sc.parallelize(List(1,2,1,3), 1)
    val b = a.map((_, "b"))
    val c = a.map((_, "c"))
    val d = a.map((_, "d"))
    val res6 = b.cogroup(c).collect().toParArray
    val res7 = b.cogroup(c,d).collect().toBuffer

    println(res6)
    sc.stop()

  }

}
