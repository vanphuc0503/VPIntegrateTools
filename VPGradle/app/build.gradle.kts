plugins {
    id("my-application")
}

application {
    mainClass.set("com.example.MyApplication")
}

dependencies {
    implementation(project(":data-model"))
    implementation(project(":business-logic"))
    implementation("org.apache.commons:commons-lang3:3.12.0")
    runtimeOnly("org.slf4j:slf4j-simple:1.7.36")
}
