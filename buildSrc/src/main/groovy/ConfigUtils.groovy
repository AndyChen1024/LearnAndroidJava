import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Project
import org.gradle.api.ProjectEvaluationListener
import org.gradle.api.ProjectState
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class ConfigUtils {
    static init(gradle) {
        GLog.l('ConfigUtils init start...')
        generateDep(gradle)
        addCommonGradle(gradle)
        TaskDurationUtils.init(gradle)
    }

    static addBuildListener(Gradle g) {
        g.addBuildListener(new BuildListener() {
//            @Override
//            void buildStarted(Gradle gradle) {
//                GLog.d("buildStarted")
//            }

            @Override
            void settingsEvaluated(Settings settings) {
                GLog.d("settingsEvaluated")
            }

            @Override
            void projectsLoaded(Gradle gradle) {
                GLog.d("projectsLoaded")
            }

            @Override
            void projectsEvaluated(Gradle gradle) {
                GLog.d("projectsEvaluated")
            }

            @Override
            void buildFinished(BuildResult buildResult) {
                GLog.d("buildFinished")
            }
        })
    }

    private static void generateDep(Gradle gradle) {
        def configs = [:]
//        for (Map.Entry<String, DepConfig> entry : Config.testConfig.entrySet()) {
//            def (name, config) = [entry.key, entry.value]
//            config.dep = config.remotePath
//            configs.put(name, config)
//        }
//        for (Map.Entry<String, DepConfig> entry : Config.libConfig.entrySet()) {
//            def (name, config) = [entry.key, entry.value]
//            if (config.useLocal) {
//                config.dep = config.localPath
//            } else {
//                config.dep = config.remotePath
//            }
//            configs.put(name, config)
//        }
//        for (Map.Entry<String, DepConfig> entry : Config.pluginConfig.entrySet()) {
//            def (name, config) = [entry.key, entry.value]
//            config.dep = config.pluginPath
//            configs.put(name, config)
//        }
        for (Map.Entry<String, DepConfig> entry : Config.depConfig.entrySet()) {
            def (name, config) = [entry.key, entry.value]
            if (name.startsWith("plugin_")) {
                config.dep = config.pluginPath
            } else {
                if (config.useLocal) {
                    config.dep = gradle.rootProject.findProject(config.localPath)
                } else {
                    config.dep = config.remotePath
                }
            }

            configs.put(name, config)
        }
        GLog.l("generateDep = ${GLog.object2String(configs)}")
    }

    private static addCommonGradle(Gradle gradle) {
        gradle.addProjectEvaluationListener(new ProjectEvaluationListener() {
            @Override
            void beforeEvaluate(Project project) {
                // 在 project 的 build.gradle 前 do sth.
                if (project.subprojects.isEmpty()) {
                    if (project.path.contains(":plugin:")) {
                        return
                    }
//                    if (project.name.endsWith("_app")) {
                    if (project.name.contains("app")) {
                        GLog.l(project.toString() + " applies buildApp.gradle")
                        project.apply {
                            from "${project.rootDir.path}/buildApp.gradle"
                        }
                    } else {
                        GLog.l(project.toString() + " applies buildLib.gradle")
                        project.apply {
                            from "${project.rootDir.path}/buildLib.gradle"
                        }
                    }
                }
            }

            @Override
            void afterEvaluate(Project project, ProjectState state) {
                // 在 project 的 build.gradle 末 do sth.
            }
        })
    }

    static getApplyPlugins() {
        def plugins = [:]
        for (Map.Entry<String, DepConfig> entry : Config.depConfig.entrySet()) {
            if (entry.value.isApply && entry.key.startsWith("plugin_")) {
                plugins.put(entry.key, entry.value)
            }
        }
        GLog.d("getApplyPlugins = ${GLog.object2String(plugins)}")
        return plugins
    }

//    static getTestDeps() {
//        def pkgs = [:]
//        for (Map.Entry<String, DepConfig> entry : Config.testConfig.entrySet()) {
//            if (entry.value.isApply) {
////            if (entry.value.isApply) {
//                pkgs.put(entry.key, entry.value)
//            }
//        }
//        GLog.d("getTestDeps = ${GLog.object2String(pkgs)}")
//        return pkgs
//    }

    static getAppDeps() {
        def pkgs = [:]
        for (Map.Entry<String, DepConfig> entry : Config.depConfig.entrySet()) {
            def isApply = entry.key.startsWith("leakcanary_") || entry.key.startsWith("lib_") || entry.key.startsWith("plugin_")

            if (entry.value.isApply && !isApply) {
                pkgs.put(entry.key, entry.value)
            }
        }
        GLog.d("getAppDeps = ${GLog.object2String(pkgs)}")
        return pkgs
    }

    static getApplyLibs() {
        def pkgs = [:]
        for (Map.Entry<String, DepConfig> entry : Config.depConfig.entrySet()) {
            if (entry.value.isApply && entry.key.startsWith("lib_")) {
                pkgs.put(entry.key, entry.value)
            }
        }
        GLog.d("getApplyLibs = ${GLog.object2String(pkgs)}")
        return pkgs
    }

}
