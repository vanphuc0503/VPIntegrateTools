plugins {
    id("java-gradle-plugin")
//    id("groovy-gradle-plugin")
//    `kotlin-dsl`//  !  id("kot lin-dsl")
}

gradlePlugin {
    plugins.create("MyJavaBase") {
        id = "my-java-base"
        implementationClass = "com.example.gradle.MyJavaBasePlugin"
    }

    plugins.create("MyJavaLibrary") {
        id = "my-java-library"
        implementationClass = "com.example.gradle.MyJavaLibraryPlugin"
    }

    plugins.create("MyJavaApplication") {
        id = "my-application"
        implementationClass = "com.example.gradle.MyJavaApplicationPlugin"
    }
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.17.0")
}