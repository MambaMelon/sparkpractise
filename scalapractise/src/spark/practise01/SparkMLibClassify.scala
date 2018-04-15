package spark.practise01

import org.apache.spark.mllib.classification.{LogisticRegressionWithSGD, NaiveBayes, SVMWithSGD}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.configuration.Algo
import org.apache.spark.mllib.tree.impurity.Entropy
import org.apache.spark.{SparkConf, SparkContext}

/**
  * SparkMLib操作之分类
  * Created by admin on 2017/04/10.
  */
object SparkMLibClassify {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkMLibClassify").setMaster("local")
    val sc = new SparkContext(conf)

    val rawData = sc.textFile("F:\\ml-100k\\u.data");
    //URL 页面ID  文本内容  页面类别  ... 目标值
    val records = rawData.map(line => line.split("\t"))
    //数据格式清理,去掉额外的；，用0代替?
    val data = records.map{ r =>
      val trimmed = r.map(_.replaceAll("\"", ""))
      val label = trimmed(r.size-1).toInt
      val features = trimmed.slice(4, r.size-1).map(d =>
        if(d == "?") 0.0 else d.toDouble)
      LabeledPoint(label, Vectors.dense(features))
    }

    data.cache()
//    val numData = data.count()

    //将负特征值设为0
    val nbData = records.map { r =>
      val trimmed = r.map(_.replaceAll("\"", ""))
      val label = trimmed(r.size-1).toInt
      val features = trimmed.slice(4, r.size-1).map(d => if(
        d == "?") 0.0 else d.toDouble).map(d => if(d<0) 0.0 else d)
      LabeledPoint(label, Vectors.dense(features))
    }

    //逻辑回归和SVM的迭代次数
    val numInterations = 10
    //决策树的最大深度
    val maxTreeDepth = 5

    //训练逻辑回归模型
    val lrModel = LogisticRegressionWithSGD.train(data, numInterations)
    //训练SVM模型
    val svmModel = SVMWithSGD.train(data, numInterations)
    //训练朴素贝叶斯
    val nbModel = NaiveBayes.train(nbData)
    //训练决策树
    val dtModel = DecisionTree.train(data, Algo.Classification, Entropy, maxTreeDepth)

    //应用训练出来的逻辑回归模型进行预测
    val dataPoint = data.first()
    //对训练数据的第一个样本预测值为1.0
    val prediction = lrModel.predict(dataPoint.features)
    //实际值为0.0
    val trueLabel = dataPoint.label
    //整体预测
    val predictions = lrModel.predict(data.map(lp => lp.features))

    //平均分类正确率
    val lrTotalCorrect = data.map{ point =>
      if(lrModel.predict(point.features) == point.label) 1 else 0
    }.sum
    val lrAccuracy = lrTotalCorrect / data.count

  }
}
