//package scala.practise10
//
//import akka.actor.{Actor, ActorSystem, Props}
//
///**
//  * actor的生命周期
//  * Created by admin on 2017/12/21.
//  */
//case object ForceRestart
//
//class Kenny extends Actor {
//  println("enter Kenny constructor!")
//
//  override def preStart(): Unit = {
//    println("preStart!")
//  }
//
//  override def postStop(): Unit = {
//    println("postStop!")
//  }
//
//  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
//    println("Attention, preRestart!")
//    println(s"MESSAGE: ${message.getOrElse("")}")
//    println(s"REASON: ${reason.getMessage}")
//    super.preRestart(reason, message)
//  }
//
//  override def postRestart(reason: Throwable): Unit = {
//    println("Attention, preRestart!")
//    println(s"REASON: ${reason.getMessage}")
//    super.postRestart(reason)
//  }
//
//  override def receive: Receive = {
//    case ForceRestart => throw new Exception("Boom!")
//    case _ => println("kenny received message...")
//  }
//}
//
///**
//  * enter Kenny constructor!
//  * preStart!
//  * kenny received message...
//  * Attention, preRestart!
//  * MESSAGE: ForceRestart
//  * REASON: Boom!
//  * postStop!
//  * enter Kenny constructor!
//  * Attention, preRestart!
//  * REASON: Boom!
//  * preStart!
//  * [ERROR] [12/21/2017 17:21:15.059] [LifeCycleDemo-akka.actor.default-dispatcher-4] [akka://LifeCycleDemo/user/Kenny] Boom!
//  * java.lang.Exception: Boom!
//  */
//
//object LifeCycleDemo extends App {
//  val system = ActorSystem("LifeCycleDemo")
//  val kenny = system.actorOf(Props[Kenny], name = "Kenny")
//
//  kenny ! "hello"
//  Thread.sleep(1000)
//
//  kenny ! ForceRestart
//  Thread.sleep(1000)
//
//  system.stop(kenny)
//
//  system.shutdown()
//
//}
