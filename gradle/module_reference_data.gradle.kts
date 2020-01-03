dependencies {
    File("$rootDir/data")
        .listFiles()
        .forEach {
            project(path = ":${it.name}")
        }
}