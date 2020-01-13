node() {
    stage ('Checkout') {
      sh 'rm -Rf *'
      checkout scm
      sh 'git clean -xdf'
    }

    stage('Build') {
      def GRADLE_HOME = tool name: 'gradle', type: 'hudson.plugins.gradle.GradleInstallation'
      sh "${GRADLE_HOME}/bin/gradle build"
      junit 'build/test-results/**/*.xml'
    }
}
