package cn.kxlove.modle

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 *
 * <p>User</p>
 *
 * @author zhengkaixin
 * @since 2018-12-21 15:10
 */

@Entity
data class User(
    val firstName: String,
    val lastName: String,
    @Id @GeneratedValue
    val id: Long? = null
)