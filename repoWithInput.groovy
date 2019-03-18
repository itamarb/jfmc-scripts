instance = userInput (
    type: "STRING",
    value : "",
    description : "please select an Artifactory instance"
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

artifactory(instance) {
  localRepository(repoName) {
  description "Public description"
  notes "Some internal notes"
  includesPattern "**/*" // default
  excludesPattern "" // default
  repoLayoutRef "maven-2-default"
  packageType repoType // "maven" | "gradle" | "ivy" | "sbt" | "nuget" | "gems" | "npm" | "conan" | "helm" |
                        // "bower" | "debian" | "pypi" | "docker" | "vagrant" | "gitlfs" | "yum" | "generic"
  checksumPolicyType "client-checksums" // default | "server-generated-checksums"
  handleReleases true // default
  handleSnapshots true // default
  maxUniqueSnapshots  0 // default
  snapshotVersionBehavior "unique" // "non-unique" | "deployer"
  suppressPomConsistencyChecks false // default
  blackedOut false // default
  propertySets // (["ps1", "ps2"])
  archiveBrowsingEnabled false
  calculateYumMetadata false
  yumRootDepth 0
  xrayIndex false
  dockerApiVersion "V2"
  maxUniqueTags 0

  }

}
