package scala.practise08

/**
  * Created by Melon on 2017/11/28.
  */

//定义一个私有的构造函数
class People private (var _name: String){
  //scala中不允许getter方法的名字与参数名一致
  def name = _name
//  def name_ = (namee: String) { _name = namee }

}

object People{
  val p = new People("xiao")
  def getInstance = p
}


//scala中的工具类通常将方法定义在一个object对象中
object FileUtils {
  def read() = { }
  def write()= { }
}

/**
  * case好处：
  * 自动生成一个apply/toString/unapply/equals/hashcode/copy方法
  * 参数默认为val
  */
//设置未初始化的字段类型
case class Register(var username: String, var passwd: String){
  var lname = ""
  var fname = ""
  var address = None: Option[Address]
}
case class Address(city: String, email: String)

object SingleTest extends App{
  val p = People.getInstance
  println(p.name)

  //给Address赋值
  val reg = Register("www", "123")
  reg.address = Some(Address("shenzhen", "111@qq.com"))
}
