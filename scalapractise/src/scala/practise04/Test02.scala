package scala.practise04

/**
  * Created by admin on 2017/11/17.
  *
  * 常用变换操作
  */
object Test02 {

  def main(args: Array[String]): Unit = {
    //map
    val list = List(1, 2, 3)
    val square = (x: Int) => x*x
    val s1 = list.map(x => x*x)
    val s2 = list.map(math.pow(_, 2))
    val s3 = list.map(square)

    //保存文本数据的几列
    val text = List("Homeway, 25, Male", "XSDYM, 23, Female")
    val uL = text.map(_.split(",")(0))
    val uList = text.map(line => {
      val fields = line.split(",")
      val user = fields(0)
      val age = fields(1)
    })

    //flatMap以及flatten
    val text1 = List("A, B, C", "D, E, F")
    val textMapped = text1.map(_.split(",").toList)
    val textFlattened = textMapped.flatten
    val textFlatMapped = text1.flatMap(_.split(",").toList)

    //求和等操作
    val nums = List(1.0, 2.0, 3.0)
    val sum1 = nums.reduce((a,b) => a+b)
    val sum2 = nums.reduce(_+_)
    val sum3 = nums.sum
    val sum4 = nums.reduceLeft(_ - _)
    val sum5 = nums.reduceRight(_ - _)
    val sum6 = nums.fold(0.0)(_ + _)
    val sum7 = nums.foldLeft(4.0)(_ - _)
    val sum8 = nums.foldRight(4.0)(_ - _)

    //排序
    val users = List(("Hua", 25), ("Ming", 23))
    val sortedByAge = users.sortBy({
      case(user, age) => age
    })
    val sortedByAgeDef = users.sortWith({  //自定义比较规则
      case(user1, user2) =>
        user1._2 < user2._2
    })

    //过滤
    val l2 = List(1, 2, 3, 4)
    val even = l2.filter(_ % 2 == 0)
    val odd = l2.filterNot(_ % 2 == 0)

    //分组
    val data = List(("HomeWay","Male"),("XSDYM","Femail"),("Mr.Wang","Male"))
    val g1 = data.groupBy(_._2)
    val g2 = data.groupBy({
      case(name, sex) => sex
    })
    val g3 = data.grouped(2).toList  //按固定大小分组\

    //工单组合
    val combinations = l2.combinations(2).toList
    val permutatipons = l2.permutations.toList

    val ls1 = l2.sliding(2, 3)

    //更新某个元素
    val ll = l2.updated(0, 5)

    println(ll.toBuffer)









  }

}
