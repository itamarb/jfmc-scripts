repoName = userInput (
    type: "STRING",
    value : "libs-release-local",
    description : "please provide a repository name"
  )

artifactory('hts-itamarb-db-lb') {
  localRepository(repoName) {
  packageType "Maven"
  handleSnapshots true
  handleReleases false
  maxUniqueSnapshots 5
  snapshotVersionBehavior "unique"
  }

}
