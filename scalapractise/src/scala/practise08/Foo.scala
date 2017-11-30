package scala.practise08

/**
  * Created by Melon on 2017/11/29.
  */
class Foo {

  //将方法标记为对象私有作用域 private[this]
  private[this] def isFoo1 = true

  //将方法标记为私有作用域 private
  private def isFoo2 = true

  //保护作用域
  protected def isFoo3 = true

  //包作用域 private[packagename],包下其它类可见
  private[practise08] def isFoo4 = true

  //公开作用域
  def isFoo5 = true

}
