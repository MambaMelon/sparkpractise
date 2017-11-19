package scala.practise06

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Melon on 2017/11/18.
  *
  * 嵌套类介绍
  */
class Network {

  //01.每个scala实例都有属于自己的Member类
  class Member(val name: String){
    val contacts = new ArrayBuffer[Member]()
  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}
































