package spark.practise01

import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.{SparkConf, SparkContext}
/**
  * SparkMLib操作之推荐
  * Created by admin on 2017/04/10.
  */
object SparkMLibRecommend {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkMLibRecommend").setMaster("local")
    val sc = new SparkContext(conf)
    //用户ID  影片ID  星级  时间戳
    val rawData = sc.textFile("F:\\ml-100k\\u.data")
    //模型训练时不需要时间戳，故过滤
    val rawRatings = rawData.map(_.split("\t").take(3))
    //将用户ID、影片ID和星级转换为Rating对象
    val ratings = rawRatings.map({case Array(user, product, rating) =>
    Rating(user.toInt, product.toInt, rating.toDouble)})
    //训练推荐模型
    val model = ALS.train(ratings, 50, 10, 0.01)
    //预测用户789对电影242的评级为predictedRating
    val predictedRating = model.predict(196, 242)
    //推荐用户789的感兴趣的5个电影
//    val topKRecs = model.recommendProducts(789, 5)
    //检验推荐
    //导入电影数据 电影ID 电影标题
    val movies = sc.textFile("F:\\ml-100k\\u.item")
    val titles = movies.map(line => line.split("\\|").take(2)).
      map(array => (array(0).toInt, array(1))).collectAsMap()
    //找出用户789评级最高的前10部电影
    val moviesForUser = ratings.keyBy(_.user).lookup(789)
    val topN = moviesForUser.sortBy(-_.rating).take(10).
      map(rating => (titles(rating.product),rating.rating))

    println()

  }
}
