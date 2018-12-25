package cn.kxlove.controller

import cn.kxlove.modle.User
import cn.kxlove.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * <p>UserController</p>
 *
 * @author zhengkaixin
 * @since 2018-12-21 15:17
 */
@RestController
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun findAll(): Iterable<User> = userRepository.findAll()
}