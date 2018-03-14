package scala.practise14

/**
  * Created by Melon on 2017/12/29.
  */
object Test02 extends App {

//  val list = List[(Int, Int)]((9, 4), (1, 5), (4, 6))
//  val res = list.map({
//    case (a,b) => a * b
//  }).sum

  def unapplySeq(email: String):
    Option[(String, Seq[String])] = {
    val parts = email split "@"
    if(parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else
      None
  }

}
