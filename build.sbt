val commonSettings = List(
  scalaVersion := "3.2.2-RC2",
  scalacOptions -= "-Xfatal-warnings",
  libraryDependencies ++= List(
    "org.typelevel" %% "cats-effect" % "3.4.4",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7",
  ),
)

val shared = project.settings(commonSettings)

val server = project.settings(commonSettings).dependsOn(shared)

val client = project.settings(commonSettings).dependsOn(shared)

val root = project
  .in(file("."))
  .settings(publish := {})
  .aggregate(server, client, shared)
