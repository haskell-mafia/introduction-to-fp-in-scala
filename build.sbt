name := "introduction-to-fp-in-scala"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalaz"     %% "scalaz-core"                  % "7.0.5"
, "org.scalaz"     %% "scalaz-scalacheck-binding"    % "7.0.5"    % "test"
, "org.specs2"     %% "specs2"                       % "2.2.2"    % "test"
, "org.scalacheck" %% "scalacheck"                   % "1.10.0"   % "test"
)

resolvers ++= Seq(
  "oss snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
, "oss releases"  at "http://oss.sonatype.org/content/repositories/releases"
)

scalacOptions := Seq(
  "-deprecation"
, "-unchecked"
, "-Ywarn-all"
, "-Xlint"
, "-feature"
, "-language:_"
)
