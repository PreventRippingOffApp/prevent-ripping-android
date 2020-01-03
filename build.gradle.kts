// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.0.0")
        classpath("com.google.android.gms:oss-licenses-plugin:0.10.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject, ".", buildDir)
}

apply {
    plugin("org.jlleitschuh.gradle.ktlint")
}

ext {
    set("app_gradle", appGradle)
    set("data_gradle", dataGradle)
    set("feature_gradle", featureGradle)
    set("core_gradle", coreGradle)
    set("module_reference_base", moduleReferenceBase)
    set("module_reference_data", moduleReferenceData)
    set("module_reference_feature", moduleReferenceFeature)
}

val baseLocation = "$rootDir/gradle"

val appGradle = "$baseLocation/app.gradle"
val dataGradle = "$baseLocation/data.gradle.kts"
val featureGradle = "$baseLocation/feature.gradle"
val coreGradle = "$baseLocation/core.gradle"
val moduleReferenceBase = "$baseLocation/module_reference_base.gradle"
val moduleReferenceData = "$baseLocation/module_reference_data.gradle"
val moduleReferenceFeature = "$baseLocation/module_reference_feature.gradle"
