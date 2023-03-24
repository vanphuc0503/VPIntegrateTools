package com.example.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.bundling.Zip;

public class MyJavaApplicationPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
//        plugins {
//            id("application")
//            id("my-java-base")
//        }
        project.getPlugins().apply("application");
        project.getPlugins().apply("my-java-base");
//
//        tasks.register("countJars", JarCount) {
//            group = "My Group"
//            description = "Counts!"
//
//            allJars.from(tasks.jar)
//            allJars.from(configurations.runtimeClasspath)
//
//            countFile.set(layout.buildDirectory.file("gen/count.txt"))
//        }
        project.getTasks().register("countJars", JarCount.class, t -> {
            t.setGroup("My Group");
            t.setDescription("Counts!");
            t.getAllJars().from(project.getTasks().named("jar"));
            t.getAllJars().from(project.getConfigurations().getByName("runtimeClasspath"));
            t.getCountFile().set(project.getLayout().getBuildDirectory().file("gen/count.txt"));
        });
//
//        tasks.register("bundle", Zip) {
//            group = "My Group"
//            description = "package it all!"
//            from(tasks.jar)
//            from(configurations.runtimeClasspath)
//
//            destinationDirectory.set(layout.buildDirectory.dir("distribution"))
//        }
        project.getTasks().register("bundle", Zip.class, t -> {
            t.setGroup("My Group");
            t.setDescription("package it all!");
            t.from(project.getTasks().named("jar"));
            t.from(project.getConfigurations().getByName("runtimeClasspath"));
            t.getDestinationDirectory().set(project.getLayout().getBuildDirectory().dir("distribution"));
        });
//
//        tasks.named("build") {
//            dependsOn(tasks.named("bundle"))
//        }
        project.getTasks().named("build", t -> {
            t.dependsOn(project.getTasks().named("bundle"));
        });
//
//        tasks.register("buildAll") {
//            description = "Builds event more!"
//
//            dependsOn(tasks.build)
//            dependsOn(tasks.named("countJars"))
//        }
        project.getTasks().register("buildAll", t -> {
            t.setDescription("Builds event more!");
            t.dependsOn(project.getTasks().named("build"));
            t.dependsOn(project.getTasks().named("countJars"));
        });
    }
}
