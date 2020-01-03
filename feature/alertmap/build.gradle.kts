apply {
    from("$rootDir/gradle/feature.gradle.kts")
    project(":record")
    project(":setting")
}
