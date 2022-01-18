class Config {

    static applicationId = 'com.andychen1024.learnandroidjava'
    static appName = 'LearnAndroidJava'

    static compileSdkVersion = 31
    static minSdkVersion = 21
    static targetSdkVersion = 31
    static versionCode = 1
    static versionName = '1.0.0'

    static kotlin_version = '1.3.10'
    static support_version = '27.1.1'
    static leakcanary_version = '1.6.3'

    static appcompat_version = "1.4.0"
    static material_version = "1.4.0"
    static constraintlayout_version = "2.1.2"

    static junit = "4.+"
    static android_junit = "1.1.3"
    static android_espresso = "3.4.0"

    static depConfig = [
            plugin       : [
                    gradle: "com.android.tools.build:gradle:7.0.4",
                    kotlin: "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version",
            ],
            support      : [
                    appcompat_v7    : "com.android.support:appcompat-v7:$support_version",
                    design          : "com.android.support:design:$support_version",
                    multidex        : "com.android.support:multidex:1.0.2",
                    constraintlayout: "com.android.support.constraint:constraint-layout:1.1.3",
            ],
            androidx     : [
                    appcompat       : "androidx.appcompat:appcompat:$appcompat_version",
                    material        : "com.google.android.material:material:$material_version",
                    constraintlayout: "androidx.constraintlayout:constraintlayout:$constraintlayout_version",
            ],
            junit        : "junit:junit:$junit",
            test         : [
                    android_junit   : "androidx.test.ext:junit:$android_junit",
                    android_espresso: "androidx.test.espresso:espresso-core:$android_espresso",
            ],

            kotlin       : "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version",
            utilcode     : "com.blankj:utilcode:1.25.0",
            free_proguard: "com.blankj:free-proguard:1.0.1",
            swipe_panel  : "com.blankj:swipe-panel:1.1",

            leakcanary   : [
                    android         : "com.squareup.leakcanary:leakcanary-android:$leakcanary_version",
                    android_no_op   : "com.squareup.leakcanary:leakcanary-android-no-op:$leakcanary_version",
                    support_fragment: "com.squareup.leakcanary:leakcanary-support-fragment:$leakcanary_version",
            ],
    ]
}