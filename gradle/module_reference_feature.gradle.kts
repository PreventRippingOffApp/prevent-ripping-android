dependencies {
    File("$rootDir/feature")
            .listFiles()
            .forEach {
                project(path = ":${it.name}")
            }
}