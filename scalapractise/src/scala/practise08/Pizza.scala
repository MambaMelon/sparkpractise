package scala.practise08

/**
  * Created by Melon on 2017/11/27.
  */
class Pizza(var crustSize: Int, var crustType: String) {

  //辅助构造函数必须以this开头
  def this(crustSize: Int){
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }

  def this(crustType: String){
    //每个辅助构造函数必须以调用之前定义过得辅助构造函数开始
    this( Pizza.DEFAULT_CRUST_SIZE)
    this.crustType = crustType
  }

  def this(){
    this(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  }

  override def toString: String = s"A $crustSize inch pizza with a $crustType crust"

}

object Pizza{
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "this"

  def main(args: Array[String]): Unit = {
    val p  = new Pizza("pig")
    println(p.crustSize)

  }
}
