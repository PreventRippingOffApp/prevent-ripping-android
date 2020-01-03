dependencies {
    File("$rootDir/core")
        .listFiles()
        .forEach {
            project(path = ":${it.name}")
        }
}