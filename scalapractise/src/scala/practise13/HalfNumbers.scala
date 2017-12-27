package scala.practise13

import scala.collection.mutable.ListMap

/**
  * 输出n个整数中出现次数超过一半的整数
  * Created by admin on 2017/12/26.
  */
object HalfNumbers extends App {
  val nums = ListMap((3,1), (2,1), (5,1), (6,1), (7,1), (9,1))
  val list = List(3, 9, 3, 2, 5, 6, 7, 3, 2, 3, 3, 3)
  for(l <- list){
    for(m <- nums.keys){
      if(l == m){
        nums(m) += 1
      }
    }
  }
  for(m <- nums.keys){
    if(nums(m) > list.length/2){
       println(m)
    }
  }
}
