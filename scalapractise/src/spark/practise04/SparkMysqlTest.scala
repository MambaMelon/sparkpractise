package spark.practise04


import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}


/**
  * spark操作数据库
  * Created by admin on 2017/12/18.
  */
object SparkMysqlTest {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().master("local").appName("SparkMysqlTest").getOrCreate()

    val schema = StructType(
      List(
        StructField("name", StringType, nullable = true),
        StructField("sector", StringType, nullable = true),
        StructField("age", IntegerType, nullable = true)
      )
    )

    val row1 = Row("Andy","aaa",20)
    val row2 = Row("Berta","bbb",30)
    val row3 = Row("Joe","ccc",40)

    val data = Seq(row1, row2, row3)

    //获取sparkcontext
    val conf = new SparkConf().setMaster("local").setAppName("SparkMysqlTest").set("spark.driver.allowMultipleContexts","true")
    val df = sparkSession.createDataFrame(new SparkContext(conf).parallelize(data), schema)

    df.createOrReplaceTempView("people")
    val sqlDF = sparkSession.sql("select * from people")

    sqlDF.foreach(x => x.toSeq.foreach(col => println(col)))

    //有三种方式创建dataframe

  }
}


