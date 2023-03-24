plugins {
    id("my-java-library")
}

dependencies {
    implementation(platform("com.example:platform"))
    integrationTestImplementation(platform("com.example:platform"))

    implementation(project(":data-model"))
    implementation(libs.commons.lang)
    implementation(libs.slf4j.api)

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    integrationTestImplementation("org.junit.jupiter:junit-jupiter-api")
    integrationTestRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
//    integrationTestImplementation("...")

//    integrationTestImplementation("")

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
