ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.12"

lazy val root = (project in file("."))
  .settings(
    name := "LSCH2_mnmcount"
  )

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
// https://repository.cloudera.com/artifactory/cloudera-repos/
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.7",
  "org.apache.spark" %% "spark-sql" % "2.4.7"
)