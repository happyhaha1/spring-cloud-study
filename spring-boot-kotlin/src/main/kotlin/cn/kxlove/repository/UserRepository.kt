package cn.kxlove.repository

import cn.kxlove.modle.User
import org.springframework.data.repository.CrudRepository

/**
 *
 * <p>UserRepository</p>
 *
 * @author zhengkaixin
 * @since 2018-12-21 15:14
 */
interface UserRepository: CrudRepository<User, Long> {

    fun findByFirstName(firstName: String): Iterable<User>

    fun findByLastName(lastName: String): Collection<User>

    fun findUserByFirstName(firstName: String): User
}