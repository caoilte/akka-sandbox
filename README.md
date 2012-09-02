Akka Sandbox
============

Creating a Deadline
-------------------

In the Sandbox Actor example I create a deadline using

    val timeLimit:Deadline = 5 seconds fromNow

This doesn't compile with error

    [error] /Users/caoilteoconnors/scala/akka-sandbox/src/main/scala/org/caoilte/SandboxApp.scala:16: polymorphic expression cannot be instantiated to expected type;
    [error]  found   : [CC <: akka.util.duration.package.Classifier[akka.util.duration.package.fromNow.type]]CC#R
    [error]  required: akka.util.Deadline
    [error]   val timeLimit:Deadline = 5 seconds fromNow
    [error]                              ^

If I add periods like so,

    val timeLimit:Deadline = 5.seconds.fromNow

it compiles fine and works as expected. This seems to break the documentation as described here,

    http://doc.akka.io/docs/akka/2.0.3/common/duration.html

Discussion of this on mailing list

    https://groups.google.com/forum/?fromgroups=#!topic/akka-user/tyGfsBJeB5c