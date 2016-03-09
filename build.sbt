scalaVersion := "2.11.8"

lazy val commonSettings = Seq(
  licenses := Seq("GPL v3+" -> url("http://www.gnu.org/licenses/gpl-3.0.txt")),
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8", "-Xfuture"),
  libraryDependencies += "de.sciss" %% "swingplus" % "0.2.1"
)

lazy val common = Project(id = "common", base = file("common"))
  .settings(commonSettings)

lazy val current = Project(id = "current", base = file("current"))
  .dependsOn(common)
  .settings(commonSettings)
  .settings(
    libraryDependencies += "de.sciss" % "weblaf" % "1.28"
  )

lazy val next = Project(id = "next", base = file("next"))
  .dependsOn(common)
  .settings(commonSettings)
  .settings(
    libraryDependencies += "de.sciss" % "weblaf" % "1.29-SNAPSHOT"
  )
