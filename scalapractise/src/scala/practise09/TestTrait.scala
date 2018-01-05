package scala.practise09

import scala.collection.mutable.ArrayBuffer

/**
  * Created by admin on 2018/1/5.
  */

abstract class CharBuffer {
  def get: Char
  def put(c: Char)
}

class Overlay extends CharBuffer{
  val buf = new ArrayBuffer[Char]

  override def get: Char = {
    if (buf.length != 0) buf(0) else '@'
  }
  override def put(c: Char): Unit = {
    buf.append(c)
  }
}

trait ToUpper extends CharBuffer {

  // 特质中重写抽象方法  abstract override
  abstract override def put(c: Char) = super.put(c.toUpper)

  // abstract override def put(c: Char): Unit = put(c.toUpper)
  // java.lang.StackOverflowError, 由于put相当于 this.put, 在特质层级中一直调用自己, 死循环
}

trait ToLower extends CharBuffer {
  abstract override def put(c: Char) = super.put(c.toLower)
}

object TestTrait extends App {
  val cb1 = new Overlay with ToLower with ToUpper
  cb1.put('A')
  println(cb1.get)  //a

  val cb2 = new Overlay with ToUpper with ToLower
  cb2.put('a')
  println(cb2.get)  //A
}
