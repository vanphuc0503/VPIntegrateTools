plugins {
    id("java-platform") // Similar to Boom == Bill Of Material
}

group = "com.example"

javaPlatform.allowDependencies()
dependencies {
    api(platform("com.fasterxml.jackson:jackson-bom:2.13.3"))
}

dependencies.constraints {
    api("org.apache.commons:commons-lang3:3.12.0")
    api("org.slf4j:slf4j-api:1.7.36")
    api("org.slf4j:slf4j-simple:1.7.36")

    /*api("com.google.guava:guava:28.0-jre") {
        version {
            strictly("...")
            reject("...")
        }
    }*/ // might select higher like 30.0-jre
}