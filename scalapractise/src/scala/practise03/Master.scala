//package scala.practise03
//
//import akka.actor.{Actor, ActorSystem, Props}
//
///**
//  * Created by ThinkPad on 2017/11/15.
//  */
//class Master extends Actor {
//  //主构造器
//  println("constructor 调用！")
//
//  override def preStart(): Unit = {
//    println("preStart 调用！")
//  }
//
//  override def receive: Receive = {
//    case "connect" => {
//      println("receive 调用！")
//    }
//  }
//}
//
//object Master {
//  def main(args: Array[String]): Unit = {
//    val host = args(0)
//    val port = args(1).toInt
//    val configStr =
//      s"""
//         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
//         |akka.remote.netty.tcp.hostname = "$host"
//         |akk.remote.netty.tcp.port = "$port"
//       """.stripMargin
//    val config = ConfigFactory.parseString(configStr)
//    //单例，负责创建和监督子Actor
//    val actorSystem = ActorSystem("MasterSystem", config)
//    val master = actorSystem.actorOf(Props(new Master), "Master")
//    master ! "hello"
//    actorSystem.awaitTermination()
//  }
//}
