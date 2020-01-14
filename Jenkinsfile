node() {
  properties([
          parameters([
                  string(name: 'tag_name', defaultValue: "NO_TAG"),
          ])
  ])
  stage ("Checkout") {
    checkout scm
    sh 'git clean -xdf'
  }

  stage("Build") {
    def GRADLE_HOME = tool name: 'gradle', type: 'hudson.plugins.gradle.GradleInstallation'
    sh "${GRADLE_HOME}/bin/gradle build"
    junit 'build/test-results/**/*.xml'
    //junit 'build/test-results/test/TEST-TestJenkinsfileNonRegression.xml'
  }

  stage("Creating Tag ${tag_name}") {
    def tagExist = sh "git tag -l '${tag_name}'"
    // sh "git tag '${tag_name}'"
    // //If exist set variable ansibleRoleBranch
    // if (tagExist == tag_name) {
    //     sh "git tag -d '${tag_name}'"

    if("${tag_name}"==tagExist){
        sh"""
                git tag -d '${tag_name}'
            """
    }else {
        sh"""
                git tag '${tag_name}'
            """
        }
    }
}
