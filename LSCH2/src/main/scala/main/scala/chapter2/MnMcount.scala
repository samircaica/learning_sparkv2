package main.scala.chapter2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MnMcount {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      //.master("local")
      .appName("MnMcount")
      .getOrCreate()

    if (args.length < 1) {
      print("Usage: MnMcount <mnm_file_dataset>")
      sys.exit(1)
    }

    val mnmFile = args(0)

    val mnmDF = spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(mnmFile)
      //.load("src/main/resources/mnm_dataset.csv")

    //mnmDF.printSchema()

    val countMnMDF = mnmDF.select("State", "Color", "Count")
      .groupBy("State", "Color")
      .sum("Count")
      .orderBy(desc("sum(Count)"))

    countMnMDF.show(10)
    println(s"Total Rows = ${countMnMDF.count()}")
    println()


  }

}
