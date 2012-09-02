name := "akka-sandbox"

version := "1.0-SNAPSHOT"

scalaVersion := "2.9.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "local-maven" at  "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"

libraryDependencies += "com.typesafe.akka" % "akka-testkit" % "2.0.3"

