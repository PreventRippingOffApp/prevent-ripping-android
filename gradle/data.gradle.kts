apply(plugin = "com.android.library")

apply {
    from("$rootDir/gradle/base.gradle")
    from("$rootDir/gradle/module_reference_base.gradle.kts")
}
