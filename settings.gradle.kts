include(":app")

listOf("feature", "data", "core")
    .forEach { folderName ->
        file(folderName)
            .listFiles { file ->
                include(file.name)
                project(":${file.name}").projectDir = file
                true
            }
    }

rootProject.name = "prevent Ripping"
