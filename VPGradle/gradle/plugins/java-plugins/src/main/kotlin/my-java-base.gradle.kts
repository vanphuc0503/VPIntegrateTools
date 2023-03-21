plugins {
    id("java")
    id("com.diffplug.spotless")
//    id("com.autonomousapps.dependency-analysis")
}

sourceSets.main {
//    java.setSrcDirs(listOf(layout.projectDirectory.dir("sources")))
}

sourceSets.test

sourceSets.create("integrationTest")

dependencies.components {
    withModule<Slf4jSimpleRule>("org.slf4j:slf4j-simple")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.test {

}
