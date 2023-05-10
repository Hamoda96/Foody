import app.cash.sqldelight.gradle.SqlDelightExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import java.util.Locale

class SqlDelightModuleConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(catalog.plugin("sqldelight"))

        dependencies {
            add("implementation", catalog.library("sqldelight.runtime"))
            add("implementation", catalog.library("sqldelight.coroutines"))
            add("implementation", catalog.library("sqldelight.primitive.adapters"))

            add("testImplementation", catalog.library("sqldelight.sqlite.driver"))
        }
    }
}

fun Project.createSqlDelightDatabase(name: String, dependency: Project? = null) {
    extensions.configure<SqlDelightExtension> {
        val database = this.databases.create(name)

        database.packageName.set(namespace())
        database.verifyMigrations.set(true)
        database.generateAsync.set(true)
        database.deriveSchemaFromMigrations.set(true)
        database.sourceFolders.set(listOf("db/${name.toLowerCase(Locale.getDefault())}"))
        database.schemaOutputDirectory.set(file("src/main/sqldelight/databases"))

        if (dependency != null) {
            database.dependency(project)
        }
    }
}