name := "Docker-Multistage-Scala"

version := "1.0.0-RELEASE"

scalaVersion := "2.12.11"

resolvers ++= Seq(
  Resolver.jcenterRepo,
  Resolver.typesafeRepo("releases")
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

scalacOptions ++= Seq("-unchecked", "-deprecation")

assemblyJarName in assembly := s"multistagedocker-assembly-${version.value}.jar"
