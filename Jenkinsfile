pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    parameters{
        choice(choices: ['chrome'], name: 'browser')
        choice(choices: ['src/test/resources/uiTests.xml', 'src/test/resources/apiTests.xml'], name: 'surefire')
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Ppolyak/Diplom'

                // Run Maven on a Unix agent.
                bat "-Dmaven.test.failure.ignore=true -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire.suiteXmlFiles} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
        }
    }
}
