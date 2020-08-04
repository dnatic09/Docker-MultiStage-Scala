package com.dnatic.multistagedocker

object App {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val aa = new AppTest(1)
    println(s"Test Param: ${aa.getParam}")
  }
}

class AppTest(testParam: Int) {
  def getParam: Int = testParam
}