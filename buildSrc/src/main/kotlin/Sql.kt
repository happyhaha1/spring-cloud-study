import org.gradle.api.logging.Logging
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.StatementContext
import org.jetbrains.exposed.sql.statements.expandArgs
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

/**
 *
 * <p>Sql</p>
 *
 * @author zhengkaixin
 * @since 2018-12-18 13:40
 */

object SqlTask {
    fun test(): Unit {
        Database.connect("jdbc:mysql://192.168.5.241:3306/loandb", driver = "com.mysql.cj.jdbc.Driver",
            user = "root", password = "dashu0701")
        transaction {
            addLogger(GradleLogger)
            for (ver in VaVer.selectAll()) {
                println("${ver[VaVer.id]}: ${ver[VaVer.globalId]}")
            }
        }
    }
}

object GradleLogger: SqlLogger {
    val logging = Logging.getLogger(this.javaClass)
    override fun log(context: StatementContext, transaction: Transaction) {
        logging.info(context.expandArgs(TransactionManager.current()))
    }
}

object VaVer: Table("qs_va_version") {
    val id = integer("id").autoIncrement().primaryKey()
    val globalId = integer("global_id")
    val ver = integer("ver")
    val vaVer = integer("va_ver")
    val card = integer("card")
}

fun main(args: Array<String>) {
    SqlTask.test()
}