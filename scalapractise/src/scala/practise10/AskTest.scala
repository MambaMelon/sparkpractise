//package scala.practise10
//
//import akka.actor.{Actor, ActorSystem, Props}
//import akka.util.Timeout
//
//import scala.concurrent.{Await, Future, ExecutionContext}
//
///**
//  * actor等待回复
//  * Created by admin on 2017/12/22.
//  */
//
//case object AskNameMessage
//
//class TestActor extends Actor {
//  override def receive: Receive = {
//    //用！回复消息
//    case AskNameMessage => sender ! "Fred"
//    case _ => println("that was unexcepted")
//  }
//}
//
//object AskTest extends App {
//  val system = ActorSystem("AskTestSystem")
//  val myActor = system.actorOf(Props[TestActor], name = "myActor")
//
//  /**
//  //方式一
//  implicit val timeout = Timeout(5000)
//  //用？向actor发送消息并等待回复
//  val future = myActor ? AskNameMessage
//  val result = Await.result(future, timeout.duration).asInstanceOf[String]
//  print(result)
//
//  //方式二:利用ask方式
//  val future2: Future[String] = ask(myActor, AskNameMessage).mapTo[String]
//  val result2 = Await.result(future2, 1000)
//  println(result2)
//    */
//}
