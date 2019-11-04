import sbt._

object Dependencies {

  val CatsVersion = "2.0.0"
  val Specs2Version = "4.8.0"
  val LogbackVersion = "1.2.3"


  lazy val cats = Seq(
    "org.typelevel" %% "cats-core"        % CatsVersion,
    "org.typelevel" %% "cats-effect"      % CatsVersion
  )

  lazy val testLib = Seq(
    "org.specs2"      %% "specs2-core"         % Specs2Version % Test,
    "org.typelevel"   %% "cats-testkit"        % CatsVersion % Test,
    "org.typelevel"   %% "cats-laws"           % CatsVersion % Test

  )

  lazy val logging = Seq(
    "ch.qos.logback"  %  "logback-classic"     % LogbackVersion
  )

}
