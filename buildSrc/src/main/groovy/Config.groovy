class Config {

    static applicationId = 'com.andychen1024.learnandroidjava'
    static appName = 'LearnAndroidJava'

    static compileSdkVersion = 31
    static minSdkVersion = 21
    static targetSdkVersion = 31
    static versionCode = 1
    static versionName = '1.0.0'

    static gradlePluginVersion = '7.0.4'

    static kotlin_version = '1.3.50'
    static support_version = '27.1.1'
    static leakcanary_version = '1.6.3'

    static appcompat_version = "1.4.0"
    static material_version = "1.5.0"
    static constraintlayout_version = "2.1.3"

    static junit = "4.13.2"
    static android_junit = "1.1.3"
    static android_espresso = "3.4.0"

    static depConfig = [
            lib_base                   : new DepConfig(true, true, "lib:base"),
            lib_common                 : new DepConfig(true, true, "lib:common"),

            plugin_gradle              : new DepConfig(pluginPath: "com.android.tools.build:gradle:$gradlePluginVersion"),
            plugin_kotlin              : new DepConfig(pluginPath: "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"),

            support_appcompat_v7       : new DepConfig("com.android.support:appcompat-v7:$support_version"),
            support_design             : new DepConfig("com.android.support:design:$support_version"),
            support_multidex           : new DepConfig("com.android.support:multidex:1.0.2"),
            support_constraintlayout   : new DepConfig("com.android.support.constraint:constraint-layout:1.1.3"),

            androidx_appcompat         : new DepConfig("androidx.appcompat:appcompat:$appcompat_version"),
            androidx_material          : new DepConfig("com.google.android.material:material:$material_version"),
            androidx_constraintlayout  : new DepConfig("androidx.constraintlayout:constraintlayout:$constraintlayout_version"),

//            junit                      : new DepConfig("junit:junit:$junit"),
//            test_android_junit         : new DepConfig("androidx.test.ext:junit:$android_junit"),
//            test_android_espresso      : new DepConfig("androidx.test.espresso:espresso-core:$android_espresso"),

            kotlin                     : new DepConfig("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"),
//            utilcode                   : new DepConfig("com.blankj:utilcode:1.25.0"),
//            free_proguard              : new DepConfig("com.blankj:free-proguard:1.0.1"),
//            swipe_panel                : new DepConfig("com.blankj:swipe-panel:1.1"),

//            leakcanary_android         : new DepConfig("com.squareup.leakcanary:leakcanary-android:$leakcanary_version"),
//            leakcanary_android_no_op   : new DepConfig("com.squareup.leakcanary:leakcanary-android-no-op:$leakcanary_version"),
//            leakcanary_support_fragment: new DepConfig("com.squareup.leakcanary:leakcanary-support-fragment:$leakcanary_version"),

    ]
}