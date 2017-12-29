//package scala.practise10
//
//import akka.actor.{Actor, ActorSystem, Props}
//
///**
//  * Created by Melon on 2017/12/4.
//  */
//class HelloActor extends Actor {
//  override def receive: Receive = {
//    case "hello" => println("hello back at you")
//    case _ => println("hun?")
//  }
//}
//
//object Main extends App {
//  //简单入门
//  val system = ActorSystem("HelloSystem")
//  //创建构造函数没有参数的actor
//  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
//  //创建构造函数有参数的actor。注意class HelloActor必须有参数
//  //val helloActor1 = system.actorOf(Props(new HelloActor("Fred"), name="helloactor"));
//  helloActor ! "hello"
//  helloActor ! "world"
//  system.stop(helloActor)
//
//  /** ********************************** */
//
//
//
//}
