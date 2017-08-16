lazy val compilerSettings = Seq(
  scalacOptions ++= Seq(
    "-language:higherKinds",
    "-Ypartial-unification",
    "-Yliteral-types",
    "-encoding", "UTF-8",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-language:existentials"
  ),
  addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3"),
  addCompilerPlugin("com.github.mpilquist" %% "simulacrum" % "0.10.0")
)

lazy val commonResolvers = Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.jcenterRepo
)

lazy val buildSettings = Seq(
  scalaOrganization := "org.typelevel",
  scalaVersion := "2.12.1",
  name := "$name$",
  version := "$version$-SNAPSHOT"
)

lazy val catsVersion = "0.9.0"
lazy val circeVersion = "0.8.0"
lazy val shapelessVersion = "2.3.2"
lazy val gogglesVersion = "1.0"
lazy val http4sVersion = "0.17.0-M3"
lazy val singletonOpsVersion = "0.0.4"
lazy val spireVersion = "0.14.1"

lazy val commonSettings = Seq(
  resolvers := commonResolvers,
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-core" % catsVersion,
    "org.typelevel" %% "cats-free" % catsVersion,
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-optics" % circeVersion,
    "com.chuusai" %% "shapeless" % shapelessVersion,
    "com.github.kenbot" %%  "goggles-dsl"     % gogglesVersion,
    "com.github.kenbot" %%  "goggles-macros"  % gogglesVersion,
    "org.http4s" %% "http4s-dsl" % http4sVersion,
    "org.http4s" %% "http4s-blaze-server" % http4sVersion,
    "org.http4s" %% "http4s-blaze-client" % http4sVersion,
    "org.http4s" %% "http4s-server-metrics" % http4sVersion,
    "org.http4s" %% "http4s-circe" % http4sVersion,
    "eu.timepit" %% "singleton-ops" % singletonOpsVersion,
    "org.typelevel" %% "spire" % spireVersion,

    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
  )
) ++ compilerSettings

lazy val root = (project in file(".")).settings(
  buildSettings,
  commonSettings
)
