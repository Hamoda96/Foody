plugins {
    `kotlin-dsl`
    alias(foody.plugins.kotlin.android) apply false
}

java {
    sourceCompatibility = JavaVersion.toVersion(foody.versions.javaCompatibility.get())
    targetCompatibility = JavaVersion.toVersion(foody.versions.javaCompatibility.get())
}

dependencies {
    compileOnly(foody.android.gradle.plugin)
    compileOnly(foody.kotlin.gradle.plugin)
    compileOnly(foody.sqldelight.gradle.plugin)
    compileOnly(foody.ktlint.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("kotlinModule") {
            id = "kotlin.module"
            implementationClass = "KotlinModuleConventionPlugin"
        }
        register("shipBluDataModule") {
            id = "shipblu.data.module"
            implementationClass = "ShipBluDataModuleConventionPlugin"
        }
        register("sqldelightModule") {
            id = "sqldelight.module"
            implementationClass = "SqlDelightModuleConventionPlugin"
        }
        register("androidModule") {
            id = "android.module"
            implementationClass = "AndroidModuleConventionPlugin"
        }
        register("composeModule") {
            id = "compose.module"
            implementationClass = "ComposeModuleConventionPlugin"
        }
        register("featureModule") {
            id = "feature.module"
            implementationClass = "FeatureModuleConventionPlugin"
        }
    }
}