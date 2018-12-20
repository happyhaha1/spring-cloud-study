package cn.kxlove

import io.kotlintest.matchers.startWith
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 *
 * <p>Example</p>
 *
 * @author zhengkaixin
 * @since 2018-12-19 19:32
 */
class MyTests : StringSpec({
    "length should return size of string" {
        println("happyHaHa test")
        "hello".length shouldBe 5
    }
    "startsWith should test for a prefix" {
        "world" should startWith("wor")
    }
})