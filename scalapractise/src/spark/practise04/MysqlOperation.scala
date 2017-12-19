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

    //DataFrame
    //注册一个临时的视图表，可以直接查询
    d_app_token.createTempView("t_token")
    val df = sparkSession.sql("select * from t_token")

    //注册全局的临时视图表，在内置的global_temp中。新的sparksession访问结果一致
    d_app_token.createGlobalTempView("t_token")
    sparkSession.sql("select * from global_temp.t_token")
    sparkSession.newSession().sql("select * from global_temp.t_token")

    //DataSets
    val caseClassDS = Seq(Person("Andy", 32)).toDS()

    val primitiveDS = Seq(1, 2, 3).toDS()
    //ArrayBuffer(2, 3, 4)
    val pDS = primitiveDS.map(_+1).collect().toBuffer

    //读取json文件
    val path = "D://people.json"
    val peopleDS = sparkSession.read.json(path).as[Person]

    //通过rdd转化数据为DF
    val peopleDF = sparkSession.read.textFile("D://people.txt")
      .map(_.split(",")).map(attributes => Person(attributes(0), attributes(1).toInt))
    peopleDF.createTempView("people")
    val ageDF = sparkSession.sql(" select * from people p where age > 19 ")
    //ageDF.map(peo => "age:" + peo(1))
    ageDF.map(peo => "age:" + peo.getAs[String]("age")).show()

  }
}

case class Person(name:String, age:Long)
