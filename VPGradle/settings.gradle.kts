
pluginManagement {
    repositories.gradlePluginPortal()
//    repositories.mavenCentral()
//    repositories.google()
//    repositories.maven("https://my.location/repo") {
//        credentials.username = "..."
//        credentials.password = "..."
//    }

    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
//    repositories.google()
//    repositories.maven("https://my.location/repo") {
//        credentials.username = "..."
//        credentials.password = "..."
//    }

//    includeBuild("../my-other-project")
    includeBuild("gradle/platform") // platform project option 1
}

rootProject.name = "VPGradle"

include("app")
include("business-logic")
include("data-model")