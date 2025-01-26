pipeline{
    
    agent {label 'ubuntu'}

	environment {
		DOCKERHUB_CREDENTIALS=credentials('dockertoken')
	}

	stages {
	    
	    stage('gitclone') {
			steps {
				git 'https://github.com/sreyadilshob/Market.git'
			}
		}
		
		stage('Maven Build') {
			steps {
              sh 'mvn clean install'
            }
		}
		
		

		stage('Build') {
			steps {
				sh 'docker build -t dilshobkk/market:latest .'
				sh 'docker images'
			}
		}

		stage('Login') {
			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {
			steps {
				sh 'docker push dilshobkk/market:latest'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}