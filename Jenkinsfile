node {
    withEnv(["LT_USERNAME=rakeshslambdatest",
    "LT_ACCESS_KEY="MHu1nfiZVVPSteHsFVqybmvsxePoFJq0j8htKDk7uHcRwPgLGg"]){
    echo env.LT_USERNAME
    echo env.LT_ACCESS_KEY 
    
   stage('setup') { 
   
      // Get some code from a GitHub repository
    try{
      git 'https://github.com/LambdaTest/LT-appium-java.git'
    }
    catch (err){
      echo err
   }
    
   }
   stage('build') {
      // Installing Dependencies
      sh 'mvn clean install'
    }
   
   stage('test') {
          try{
          sh 'mvn test -P android'
          }
          catch (err){
          echo err
          }  
   }
   stage('end') {  
     echo "Success" 
     }
 }
}
