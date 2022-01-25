import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class ConfigUtils {
    static init(gradle){
        GLog.l('ConfigUtils init start...')
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
}
