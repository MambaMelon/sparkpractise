package spark.practise03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by admin on 2017/12/7.
  *
  * 使用Spark Accumulators完成Job的数据量处理
  * 统计emp表中NULL出现的次数以及正常数据的条数 & 打印正常数据的信息
  */
object Accumulator {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test03").setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("E:/emp.txt")
    val nullNum = sc.longAccumulator("NullNumber")
    val normalData = lines.filter(line => {
      var flag = true
      val splitLines = line.split("\t")
      for(splitLine <- splitLines){
        if("".equals(splitLines)){
          flag = true
          nullNum.add(1)
        }
      }
      flag
    })
    normalData.cache()
    normalData.foreach(println)
    println("NORMAL DATA NUMBER: " + normalData.count())
    println("NULL: " + nullNum.count)
  }

}
