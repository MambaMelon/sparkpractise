package scala.practise10

import akka.actor.{Actor, ActorRef, ActorSystem, Kill, PoisonPill, Props}

/**
  * actor之间通信
  * Created by admin on 2017/12/21.
  */

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong: ActorRef) extends Actor {

  //监控pong的状态
  context.watch(pong)

  var count = 0
  def incrementAndPrint: Unit = {
    count += 1;
    println("ping")
  }
  def receive = {
    case StartMessage => incrementAndPrint
      pong ! PingMessage
    case PongMessage => incrementAndPrint
      if(count > 99){
        //sender为隐式引用，可以给源actor回复消息
        sender ! StopMessage
        println("ping stopped")
        //②在actor级别使用context来停止actor
        context.stop(self)
      } else {
        sender ! PingMessage
      }
    case _ => println("Ping got something unexcepted.")
  }
}

class Pong extends Actor {
  override def receive: Receive = {
    case PingMessage =>
      println("pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
    case _ => println("Pong got something unexcepted.")
  }
}

object PingPongTest extends App{
  val system = ActorSystem("PingPongTest")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")

  ping ! StartMessage

  /** **********停止actor的几种方式********* **/
  //①在ActorSystem级别停止
  system.stop(ping)

  //③通过发送PoisonPill停止actor
  ping ! PoisonPill

  //④发送Kill消息
  ping ! Kill

  /** **********优雅的关闭akka actor系统*********** **/
  system.shutdown()

}
