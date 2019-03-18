instance = userInput (
  type : "ARTIFACTORY",
  description : "Please select the artifactory instance to run against"
)

repoName = userInput (
    type: "STRING",
    value : "generic-local",
    description : "please provide a repository name"
  )
repoType = userInput (
  type: "STRING",
  value : "Maven",
  description : "please choose a repository type"
  )
artifactory(instance){
   localRepository(repoName) {
     packageType repoType
   }
}
