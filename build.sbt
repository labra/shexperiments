import sbt._
import sbt.Keys._

lazy val root = project.in(file("."))

organization := "es.weso"

name := "shexperiments"

scalaVersion := "2.11.7"

version := "0.0.1"

libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-simple" % "1.6.4"
  , "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
  , "commons-configuration" % "commons-configuration" % "1.7"
  , "org.rogach" %% "scallop" % "0.9.5" 
  , "com.typesafe" % "config" % "1.0.1"
  , "org.scala-lang" % "scala-compiler" % scalaVersion.value
  , "com.novocode" % "junit-interface" % "0.11" % "test"  
  , "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test"
  ,	"org.scalacheck" %% "scalacheck" % "1.11.4" % "test"
  , "com.storm-enroute" %% "scalameter" % "0.8-SNAPSHOT"
  , "es.weso" % "shexcala_2.11" % "0.6.0" excludeAll(ExclusionRule(organization = "org.slf4j"))  
  )

autoCompilerPlugins := true


// Binari packaging
enablePlugins(JavaAppPackaging)

packageSummary in Linux := "ShEx and SHACL experiments"
packageSummary in Windows := "ShEx and SHACL experiments"
packageDescription := " ShEx and SHACL experiments"

maintainer in Windows := "WESO"
maintainer in Debian := "Jose Emilio Labra <jelabra@gmail.es>"

mainClass in Compile := Some("es.weso.main.Main")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

//resolvers += "Sonatype OSS Snapshots" at
//  "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "Bintray" at "http://dl.bintray.com/weso/weso-releases"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Managed

