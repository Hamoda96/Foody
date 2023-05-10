dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    versionCatalogs {
        create("foody") {
            from(files("../gradle/foody.versions.toml"))
        }
    }
}

rootProject.name = "foody-build-logic"
include(":convention")
