@file:JvmName("Utils")

package cn.kxlove

import kotlinx.coroutines.*

/**
 *
 * <p>KotlinCoroutinesExample</p>
 *
 * @author zhengkaixin
 * @since 2018-12-25 17:51
 */



fun helloWord() = runBlocking {
    val job = launch {
        delay(1000)
        println("world")
    }
    println("Hello,") // 主线程的协程将会继续等待
    job.join()
}
fun moreCoroutines() = runBlocking {
    repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
    }
}

fun main() = runBlocking {
    //sampleStart
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // 一个执行计算的循环，只是为了占用CPU
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消一个任务并且等待它结束
    println("main: Now I can quit.")
//sampleEnd
}
