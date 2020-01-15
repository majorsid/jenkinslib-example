node {
    stage('checkout') {
        sh 'rm -Rf *'
        checkout scm
    }

    stage('build') {
        def GRADLE_HOME = tool name: 'gradle', type: 'hudson.plugins.gradle.GradleInstallation'
        sh "${GRADLE_HOME}/bin/gradle build"
        junit 'build/test-results/**/*.xml'
    }
}
