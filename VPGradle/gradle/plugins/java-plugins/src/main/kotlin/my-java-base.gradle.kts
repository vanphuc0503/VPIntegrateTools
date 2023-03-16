plugins {
    id("java")
    id("com.diffplug.spotless")
//    id("com.autonomousapps.dependency-analysis")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.test {

}
