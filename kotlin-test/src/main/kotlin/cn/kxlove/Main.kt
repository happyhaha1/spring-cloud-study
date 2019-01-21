package cn.kxlove

import java.math.BigDecimal

/**
 *
 * <p>`cn.kxlove.TestKotlin`</p>
 *
 * @author zhengkaixin
 * @since 2018-12-17 16:18
 */
fun main(args: Array<String>) {
//    val nameToTeam = listOf("Alice" to "Marketing", "Bob" to "Sales", "Carol" to "Marketing")
//
//    val mutableNamesByTeam = nameToTeam.groupByTo(HashMap(), { it.second }, { it.first })
//    println(mutableNamesByTeam)
//    fun printAll(vararg messages: String) {                            // 1
//        for (m in messages) print(m)
//    }
//    printAll("Hello", "Hallo", "Salut", "Hola", "你好")
//    println(2 * "Bye ")
//
//    val pair = "Happy" to "haha"
//    println(pair)
//    val a = BigDecimal.valueOf(1)
//    val b = BigDecimal.valueOf(2)
//    if (a == b) {
//        ls

//    }
//    val person = Person()
//
//    person.firstName = "happyhaha"
//
//    person.sayHello()
//    val list : List<Int>? = null
//    println(list.isNotEmpty())
//    val create = MyClass()
//    multiply(10,z = 10)
//    val items = listOf("one" to BigDecimal.ONE,
//        "two" to BigDecimal.ONE,
//        "null" to null)
//    val sumAmount = items.mapNotNull { it.second }.fold(BigDecimal.ZERO, BigDecimal::add)
//    print(sumAmount)

//    val items = listOf(1, 2, 3, 4, 5)

//// Lambdas 表达式是花括号括起来的代码块。
//    items.fold(0) {
//        // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
//            acc: Int, i: Int ->
//        print("acc = $acc, i = $i, ")
//        val result = acc + i
//        println("result = $result")
//        // lambda 表达式中的最后一个表达式是返回值：
//        result
//    }
//    items.reduce { 0, i ->  }

    val one = BigDecimal.valueOf(0)
    val two = BigDecimal.TEN
    if (one >= two) {
        println("equal")
    }else {
        println("not")
    }
}

fun multiply(x: Int, y: Int = 10, z: Int = 20 ) : Int {
//    x = 10
    print(z)
    return x*y*z
}

operator fun Int.times(str: String) = str.repeat(this)        // 1
class Person constructor(var firstName: String = "happy") {

    val firstProperty = firstName

    init {
        println("First initializer block that prints $firstName")
    }

    val secondProperty = "Second property: ${firstName.length}".also(::println)

    init {
        println("Second initializer block that prints ${firstName.length}")
    }

    fun sayHello() {
        println(firstName)
    }
}



fun <T> List<T>?.isNotEmpty() : Boolean {
    return this != null && this.isEmpty()
}

class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}
