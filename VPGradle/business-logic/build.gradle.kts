plugins {
    id("my-java-library")
}

dependencies {
    implementation(platform("com.example:platform"))

    implementation(project(":data-model"))
    implementation("org.apache.commons:commons-lang3")
    implementation("org.slf4j:slf4j-api")

//    api("") <-- dependency is transitively visible as compilation
//    runtimeOnly("group:name") <-- only at runtime
//    compileOnly("group:name") <-- only at compile time
}

//configurations {
//    compileClasspath // <- Compile time "view" (aka Variant)
//    runtimeClasspath // <- Runtime "view" (aka Variant)
//    compileClasspath.extendsFrom(implementation, compileOnly, ...)
//    runtimeClasspath.extendsFrom(implementation, compileOnly, ...)
//}
