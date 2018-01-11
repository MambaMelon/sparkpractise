package scala.practise07

import scala.collection.mutable.ArrayBuffer

/**
  * 让可变集合非变
  * Created by admin on 2018/1/10.
  */
trait Animal {
  def speak
}

class Dog(var name: String) extends Animal {
  def speak: Unit = {
    println("woof")
  }

  override def toString: String = name
}

class SuperDog(name: String) extends Dog(name) {
  def useSuperPower = {
    println("Useing my superpower!")
  }
}

object Test03 extends App {
  val fido = new Dog("Fido")
  val wonderDog = new SuperDog("Wonder Dog")
  val shaggy = new SuperDog("Shaggy")

  def makeDogsSpeak(dogs: ArrayBuffer[Dog]): Unit ={
    dogs.foreach(_.speak)
  }

  val dogs = ArrayBuffer[Dog]()
  dogs += fido
  dogs += wonderDog

  makeDogsSpeak(dogs)

  val superDogs = ArrayBuffer[SuperDog]()
  superDogs += shaggy
//  makeDogsSpeak(superDogs)  无法编译

}
