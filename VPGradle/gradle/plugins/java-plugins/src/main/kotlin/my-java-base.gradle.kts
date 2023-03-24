plugins {
    id("java")
    id("com.diffplug.spotless")
//    id("com.autonomousapps.dependency-analysis")
}

/*sourceSets.main {
//    java.setSrcDirs(listOf(layout.projectDirectory.dir("sources")))
}

sourceSets.test*/

tasks.register<Test>("integrationTest") {
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath

    useJUnitPlatform()
}

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
    useJUnitPlatform {
        excludeTags("slow")
    }

    maxParallelForks = 4

    maxHeapSize = "1g"
}

tasks.register<Test>("testSlow") {
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath

    useJUnitPlatform {
        includeTags("slow")
    }
}

tasks.check {
    dependsOn(tasks.named("testSlow"))
}
