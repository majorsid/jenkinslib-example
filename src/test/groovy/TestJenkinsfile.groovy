import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

import static com.lesfurets.jenkins.unit.MethodCall.callArgsToString
import static org.assertj.core.api.AssertionsForClassTypes.assertThat

class TestJenkinsfile extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
        binding.setVariable('scm', [$class: 'GitSCM'])

        helper.registerAllowedMethod("tool", [Map.class], { c -> '/bin/gradle' })
        helper.registerAllowedMethod("tool", [String.class], { c -> '/bin/gradle' })

    }


    @Test
    void should_execute_without_errors_and_gradle_build() throws Exception {
        runScript("Jenkinsfile")
        printCallStack()
    }

    // @Test
    // void should_execute_without_errors_and_gradle_clean_build() throws Exception {
    //     binding.setVariable('env', [PATH: "/bin", "CLEAN":"true"])
    //     runScript("Jenkinsfile")
    //     printCallStack()
    //     assertJobStatusSuccess()
}
