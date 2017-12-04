package scala.practise10

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by Melon on 2017/12/4.
  */
class HelloActor extends Actor {
  override def receive: Receive = {
    case "hello" => println("hello back at you")
    case _ => println("hun?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "hello"
  helloActor ! "world"
  system.stop(helloActor)
}
