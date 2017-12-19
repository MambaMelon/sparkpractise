package spark.practise04

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._

/**
  * 用户自定义聚合函数的使用
  * Created by admin on 2017/12/19.
  */


object UDAF extends UserDefinedAggregateFunction {

  override def inputSchema: StructType = StructType(StructField("inputColumn", LongType) :: Nil)

  override def bufferSchema: StructType = {
    StructType(StructField("sum", LongType) :: StructField("count", LongType) :: Nil)
  }

  override def dataType: DataType = DoubleType

  override def deterministic: Boolean = true

  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = 0L
  }

  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    if(!input.isNullAt(0)){
      buffer(0) = buffer.getLong(0) + input.getLong(0)
      buffer(1) = buffer.getLong(1) + 1
    }
  }

  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }

  override def evaluate(buffer: Row): Double = buffer.getLong(0).toDouble / buffer.getLong(1)


  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().master("local").appName("MysqlOperation").getOrCreate()
    sparkSession.udf.register("UDAF", UDAF)

    val df = sparkSession.read.json("D://employees.json")
    df.createOrReplaceTempView("employees")
    df.show()
    val result = sparkSession.sql("select UDAF(salary) as average_salary from employees")
    result.show()

  }




}
