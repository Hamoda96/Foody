import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ComposeModuleConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        val extension = extensions.getByType<LibraryExtension>()

        extension.buildFeatures.compose = true
        extension.composeOptions.kotlinCompilerExtensionVersion = catalog.version("composeCompiler").displayName

        dependencies {
            add("implementation", platform(catalog.library("androidx.compose.bom")))
            add("implementation", catalog.library("androidx.compose.material3"))
            add("implementation", catalog.library("androidx.compose.activity"))
            add("implementation", catalog.library("androidx.compose.lifecycle"))
            add("implementation", catalog.library("androidx.compose.ui.tooling.preview"))

            add("debugImplementation", catalog.library("androidx.compose.ui.tooling"))
            add("debugImplementation", catalog.library("androidx.compose.ui.test.manifest"))

            add("androidTestImplementation", catalog.library("androidx.compose.ui.test.junit4"))
        }
    }
}