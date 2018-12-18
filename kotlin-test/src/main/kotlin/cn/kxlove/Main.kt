@file:JvmName("Main")
package cn.kxlove

/**
 *
 * <p>`cn.kxlove.TestKotlin`</p>
 *
 * @author zhengkaixin
 * @since 2018-12-17 16:18
 */
fun main(args: Array<String>) {
    val nameToTeam = listOf("Alice" to "Marketing", "Bob" to "Sales", "Carol" to "Marketing")

    val mutableNamesByTeam = nameToTeam.groupByTo(HashMap(), { it.second }, { it.first })
    println(mutableNamesByTeam)

}