package com.example.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.api.tasks.testing.Test;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

public class MyJavaBasePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
//        plugins {
//            id("java")
        project.getPlugins().apply("java");
        project.getPlugins().apply("com.diffplug.spotless");
//            id("com.diffplug.spotless")
////    id("com.autonomousapps.dependency-analysis")
//        }
//
///*sourceSets.main {
////    java.setSrcDirs(listOf(layout.projectDirectory.dir("sources")))
//}
//
//sourceSets.test*/
//
//        sourceSets.create("integrationTest")
        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
        sourceSets.create("integrationTest");


//        tasks.register("integrationTest", Test) {
//            testClassesDirs = sourceSets["integrationTest"].output.classesDirs
//            classpath = sourceSets["integrationTest"].runtimeClasspath
//
//            useJUnitPlatform()
//        }
        project.getTasks().register("integrationTest", Test.class, t -> {
            t.setTestClassesDirs(sourceSets.getByName("integrationTest").getOutput().getClassesDirs());
            t.setClasspath(sourceSets.getByName("integrationTest").getRuntimeClasspath());
            t.useJUnitPlatform();
        });
//
//        dependencies.components {
//            withModule("org.slf4j:slf4j-simple", com.example.gradle.Slf4jSimpleRule)
//        }
        project.getDependencies().getComponents()
                .withModule("org.slf4j:slf4j-simple", Slf4jSimpleRule.class);
//
//        java {
//            toolchain.languageVersion.set(JavaLanguageVersion.of(11))
//        }
        JavaPluginExtension java = project.getExtensions().getByType(JavaPluginExtension.class);
        java.getToolchain().getLanguageVersion().set(JavaLanguageVersion.of(11));
//
//        tasks.withType(JavaCompile).configureEach {
//            options.encoding = "UTF-8"
//        }
        project.getTasks().withType(JavaCompile.class).configureEach(t -> {
            t.getOptions().setEncoding("UTF-8");
        });
//
//        tasks.named("test") {
//            useJUnitPlatform {
//                excludeTags("slow")
//            }
//
//            maxParallelForks = 4
//
//            maxHeapSize = "1g"
//        }
        project.getTasks().named("test", Test.class, t -> {
            t.useJUnitPlatform(junit -> junit.excludeTags("slow"));
            t.setMaxParallelForks(4);
            t.setMaxHeapSize("1g");
        });
//
//        tasks.register("testSlow", Test) {
//            testClassesDirs = sourceSets.test.output.classesDirs
//            classpath = sourceSets.test.runtimeClasspath
//
//            useJUnitPlatform {
//                includeTags("slow")
//            }
//        }
        project.getTasks().register("testSlow", Test.class, t -> {
            t.setTestClassesDirs(sourceSets.getByName("test").getOutput().getClassesDirs());
            t.setClasspath(sourceSets.getByName("test").getRuntimeClasspath());
            t.useJUnitPlatform(junit -> junit.includeTags("slow"));
        });
//
//        tasks.named("check") {
//            dependsOn(tasks.named("testSlow"))
//        }
        project.getTasks().named("check", t -> {
            t.dependsOn(project.getTasks().named("testSlow"));
        });
    }
}
