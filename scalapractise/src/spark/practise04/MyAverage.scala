package spark.practise04

import org.apache.spark.sql.{Encoder, Encoders, Row, SparkSession}
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._

/**
  * 用户定义类型安全的函数
  * Created by admin on 2017/12/19.
  */


case class Employee(name: String, salary: Long)
case class Average(var sum: Long, var count: Long)
object MyAverage extends Aggregator[Employee, Average, Double] {


  override def zero: Average = Average(0L, 0L)

  override def reduce(buffer: Average, employee: Employee): Average = {
    buffer.sum += employee.salary
    buffer.count += 1
    buffer
  }

  override def merge(aver1: Average, aver2: Average): Average = {
    aver1.sum += aver2.sum
    aver1.count += aver2.count
    aver1
  }

  override def finish(reduction: Average): Double = {
    reduction.sum.toDouble / reduction.count
  }

  override def bufferEncoder: Encoder[Average] = Encoders.product

  override def outputEncoder: Encoder[Double] = Encoders.scalaDouble


  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().master("local").appName("MyAverage").getOrCreate()
    import sparkSession.implicits._
    val ds = sparkSession.read.json("D://employees.json").as[Employee]
    val averageSalary = MyAverage.toColumn.name("average_salary")
    val result = ds.select(averageSalary)
    result.show()
  }
}
