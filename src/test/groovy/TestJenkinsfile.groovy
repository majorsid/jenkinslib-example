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
        binding.setVariable('env', [PATH: "/bin", "CLEAN":"false"])

        helper.registerAllowedMethod("tool", [Map.class], { c -> '/bin/gradle' })
        helper.registerAllowedMethod("tool", [String.class], { c -> '/bin/gradle' })
        helper.registerAllowedMethod("withEnv", [ArrayList.class, Closure.class], { a, c -> c.call() })
        helper.registerAllowedMethod("fileExists", [String.class], { c -> false })
    }


    @Test
    void test_simple_pipeline() throws Exception {
        // try {
            runScript("Jenkinsfile")
        // } catch (e) {
        //     e.printStackTrace()
        //     exception = true
        // }
        // assertThat(exception).isFalse()
    }
}
