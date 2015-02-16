name := "introduction-to-fp-in-scala"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.scalaz"        %% "scalaz-core"                  % "7.1.1"
, "org.scalaz"        %% "scalaz-scalacheck-binding"    % "7.1.1"    % "test"
, "org.scalaz.stream" %% "scalaz-stream"                % "0.6a"
, "org.specs2"        %% "specs2"                       % "2.4.5"    % "test"
, "org.scalacheck"    %% "scalacheck"                   % "1.12.2"   % "test"
)

resolvers ++= Seq(
  "oss snapshots"       at "http://oss.sonatype.org/content/repositories/snapshots"
, "oss releases"        at "http://oss.sonatype.org/content/repositories/releases"
, "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
)

scalacOptions := Seq(
  "-deprecation"
, "-unchecked"
, "-Xfatal-warnings"
, "-Xlint"
, "-feature"
, "-language:_"
)
