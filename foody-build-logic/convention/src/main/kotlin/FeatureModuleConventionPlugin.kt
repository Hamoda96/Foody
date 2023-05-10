
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeatureModuleConventionPlugin: Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        pluginManager.apply("android.module")
        pluginManager.apply("compose.module")

        dependencies {
            add("implementation", catalog.library("androidx.lifecycle.runtime"))
            add("implementation", catalog.library("androidx.lifecycle.viewmodel"))
            add("implementation", catalog.library("androidx.navigation.fragment"))
            add("implementation", catalog.library("androidx.navigation.ui"))
            add("implementation", catalog.library("androidx.work.runtime"))
            add("implementation", catalog.library("koin.androidx.navigation"))
            add("implementation", catalog.library("koin.androidx.workmanager"))

            add("androidTestImplementation", catalog.library("androidx.lifecycle.runtime.testing"))
            add("androidTestImplementation", catalog.library("androidx.navigation.test"))
            add("androidTestImplementation", catalog.library("androidx.work.testing"))
        }
    }
}