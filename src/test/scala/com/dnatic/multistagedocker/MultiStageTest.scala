package com.dnatic.multistagedocker

import org.scalatest.{FlatSpec, Matchers}

class MultiStageTest extends FlatSpec with Matchers {
  "Multistage" should "run a test" in {
    val expected = 2
    val cc = new AppTest(expected)
    cc.getParam shouldBe expected
  }
}
