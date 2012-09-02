package org.caoilte

import _root_.akka.actor.{Props, ActorSystem, ActorLogging, Actor}
import _root_.akka.util.{Deadline, Duration}
import _root_.akka.util.duration._
import java.util.concurrent.{TimeUnit, CountDownLatch}
import org.caoilte.SandboxActor.Test


object SandboxActor {
  case object Test
}

class SandboxActor extends Actor with ActorLogging {

  val timeLimit:Deadline = 5 seconds fromNow

  protected def receive = {
    case Test => {
      log.info("Test fired");

      if (timeLimit.isOverdue()) {
        log.info("time limit reached")
      }
    }

  }
}

object SandboxApp extends App {
  val latch = new CountDownLatch(1)
  val system = ActorSystem("BuildNotifierSystem");
  system.registerOnTermination(latch.countDown())

  val supervisor = system.actorOf(Props[SandboxActor]);

  supervisor ! Test

  val cancellable = system.scheduler.schedule(0 milliseconds, 10 seconds, supervisor, Test);

  val input = readLine("prompt> ")

  System.out.println("shutting down akka");
  cancellable.cancel();
  system.shutdown();
  System.out.println("awaiting shutdown");
  latch.await();
  System.out.println("latch fired");


}
