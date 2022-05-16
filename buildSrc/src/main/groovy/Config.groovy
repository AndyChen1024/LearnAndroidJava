class Config {

    static applicationId = 'com.andychen1024.learnandroidjava'
    static appName = 'LearnAndroidJava'

    static compileSdkVersion = 31
    static minSdkVersion = 21
    static targetSdkVersion = 31
    static versionCode = 1
    static versionName = '1.0.0'

    static kotlin_version = '1.3.50'
    static support_version = '27.1.1'
    static lifecycle_version = '2.2.0'
    static leakcanary_version = '2.7'

    static appcompat_version = "1.4.0"
    static material_version = "1.4.0"
    static constraint_layout_version = "2.1.2"

    static junit = "4.+"
    static android_junit = "1.1.3"
    static android_espresso = "3.4.0"

    static gradlePluginVersion = '4.1.3'

    static depConfig = [
//            feature_mock               : new DepConfig(false, true , ":feature:mock"),
            feature_launcher_app       : new DepConfig(true , true , ":feature:launcher:app"),
//            feature_feature0_app       : new DepConfig(false, true , ":feature:feature0:app"),
//            feature_feature0_pkg       : new DepConfig(true , true , ":feature:feature0:pkg", "com.blankj:feature-feature0-pkg:1.0"),
//            feature_feature0_export    : new DepConfig(true , true , ":feature:feature0:export"),
//            feature_feature1_app       : new DepConfig(false, true , ":feature:feature1:app"),
//            feature_feature1_pkg       : new DepConfig(true , true , ":feature:feature1:pkg"),
//            feature_feature1_export    : new DepConfig(true , true , ":feature:feature1:export"),
            lib_base                   : new DepConfig(true , true , ":lib:base"),
            lib_common                 : new DepConfig(true , true , ":lib:common"),

            plugin_gradle              : new DepConfig(pluginPath: "com.android.tools.build:gradle:$gradlePluginVersion"),
            plugin_kotlin              : new DepConfig(pluginPath: "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"),
//plugin_api                 : new DepConfig(pluginPath: "com.blankj:api-gradle-plugin:1.2", pluginId: "com.blankj.api"),
//plugin_bus                 : new DepConfig(pluginPath: "com.blankj:bus-gradle-plugin:2.4", pluginId: "com.blankj.bus"),

//            support_appcompat_v7       : new DepConfig("com.android.support:appcompat-v7:$support_version"),
//            support_design             : new DepConfig("com.android.support:design:$support_version"),
            support_multidex           : new DepConfig("com.android.support:multidex:1.0.2"),
//            support_constraint         : new DepConfig("com.android.support.constraint:constraint-layout:1.1.3"),

            appcompat                  : new DepConfig("androidx.appcompat:appcompat:$appcompat_version"),
            material                   : new DepConfig("com.google.android.material:material:$material_version"),
            constraintlayout           : new DepConfig("androidx.constraintlayout:constraintlayout:$constraint_layout_version"),
            annotation                 : new DepConfig( "androidx.annotation:annotation:1.2.0"),
            recyclerview               : new DepConfig( "androidx.recyclerview:recyclerview:1.1.0"),

            kotlin                     : new DepConfig("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"),
            utilcode                   : new DepConfig("com.blankj:utilcode:1.28.0"),
//            free_proguard              : new DepConfig("com.blankj:free-proguard:1.0.1"),
//            swipe_panel                : new DepConfig("com.blankj:swipe-panel:1.1"),

            leakcanary_android         : new DepConfig("com.squareup.leakcanary:leakcanary-android:$leakcanary_version"),

            junit                      : new DepConfig( "junit:junit:$junit"),
//            test               : [
            android_junit              : new DepConfig( "androidx.test.ext:junit:$android_junit"),
            android_espresso           : new DepConfig("androidx.test.espresso:espresso-core:$android_espresso"),
//            ],
//
//            kotlin             : "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version",
//            utilcode           : "com.blankj:utilcode:1.25.0",
//            free_proguard      : "com.blankj:free-proguard:1.0.1",
//            swipe_panel        : "com.blankj:swipe-panel:1.1",
//            lifecycle_livedata : "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version",
//            lifecycle_viewmodel: "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version",
//
//            leakcanary         : [
//                    android         : "com.squareup.leakcanary:leakcanary-android:$leakcanary_version",
//                    android_no_op   : "com.squareup.leakcanary:leakcanary-android-no-op:$leakcanary_version",
//                    support_fragment: "com.squareup.leakcanary:leakcanary-support-fragment:$leakcanary_version",
//            ],
    ]
}