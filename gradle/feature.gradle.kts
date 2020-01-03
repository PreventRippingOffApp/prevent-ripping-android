apply {
    plugin("com.android.library")
    from("$rootDir/gradle/base.gradle")
    from("$rootDir/gradle/module_reference_base.gradle.kts")
    from("$rootDir/gradle/module_reference_data.gradle.kts")
}