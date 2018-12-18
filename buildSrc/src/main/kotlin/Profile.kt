import org.gradle.internal.nativeintegration.filesystem.DefaultFileMetadata.file
import java.io.File
import java.util.*

/**
 *
 * <p>Profile</p>
 *
 * @author zhengkaixin
 * @since 2018-12-18 16:28
 */

object Profile {
    fun change(profile: String?): Unit {
        val thisProfile = profile ?: "company"
        val applicationFile = File("src/main/resources/application.properties")
        if (applicationFile.exists()) {
            val properties = Properties()
            properties.load(applicationFile.inputStream())
            properties["spring.profiles.active"] = thisProfile
            properties.store(
                File("build/classes/main/application.properties").outputStream(),
                "Change active profile to $thisProfile"
            )
        }
        val bootstrapFile  = File("src/main/resources/bootstrap.properties")
        if (bootstrapFile.exists()) {
            val properties = Properties()
            properties.load(bootstrapFile.inputStream())
            properties["spring.profiles.active"] = thisProfile
            properties.store(
                File("build/classes/main/bootstrap.properties").outputStream(),
                "Change active profile to $thisProfile"
            )
        }
    }
}