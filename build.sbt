ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "Advent of Code 2022",
    idePackagePrefix := Some("com.mycode"),
  
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"   % "2.9.0",
      "org.typelevel" %% "cats-effect" % "3.5.0",
      "co.fs2"        %% "fs2-core"    % "3.7.0",
      "co.fs2"        %% "fs2-io"      % "3.7.0",
    )
    
  )
