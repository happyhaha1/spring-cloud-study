package cn.kxlove.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 *
 * <p>UserRepositoryTest</p>
 *
 * @author zhengkaixin
 * @since 2018-12-21 15:43
 */
@ExtendWith(SpringExtension::class)
@DataJpaTest
class UserRepositoryTest(@Autowired val userRepository: UserRepository) {

    @Test
    fun `testSave`() {
        userRepository.findUserByFirstName("Kim").firstName shouldBe "Kim"
    }
}

infix fun <T, U : T> T.shouldBe(any: U?) {
    assertThat(this).isEqualTo(any)
}

