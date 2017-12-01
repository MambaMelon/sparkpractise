package scala.practise09

/**
  * Created by Melon on 2017/11/30.
  */
trait Animal {
  var name = "animal"
  val color = "colourful"
}

class Cat extends Animal{
  //重写父特质中的var字段不需要override，而val字段需要
  name = "cat"
  override val color = "white"
}

object Test extends App{
  new Animal {}
}
