package spark.practise04

import java.util.Properties

import org.apache.spark.sql.SparkSession


/**
  * spark操作数据库
  * Created by admin on 2017/12/18.
  */
object MysqlOperation {
  def main(args: Array[String]): Unit = {
    //    val conf = new SparkConf().setAppName("MysqlOperation").setMaster("local")
    //    val sc = new SparkContext(conf)
    val sparkSession = SparkSession.builder().master("local").appName("MysqlOperation").getOrCreate()
    import sparkSession.implicits._  //并非spark.implicits._
    val properties = new Properties()
    properties.put("user","root")
    properties.put("password","123456")
    val url = "jdbc:mysql://192.168.0.39:3306/newgps?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull"
    val d_app_token = sparkSession.read.jdbc(url,"d_app_token",properties)
    //    d_app_token.printSchema();
    //    d_app_token.select("id", "token", "createTime").show()
//    d_app_token.filter($"id" > 50).show()
//    d_app_token.groupBy("id").count().show()
  }
}
