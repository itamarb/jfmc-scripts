repoName = userInput (
    type: "STRING",
    value : "libs-release-local",
    description : "please provide a repository name"
  )

artifactory ('hts-itamarb-db-lb'){
localRepository('repoName') {
  description "Public description"
  notes "Some internal notes"
  includesPattern "**/*" // default
  excludesPattern "" // default
  repoLayoutRef "maven-2-default"
  packageType "generic" // "maven" | "gradle" | "ivy" | "sbt" | "nuget" | "gems" | "npm" | "conan" | "helm" |
                        // "bower" | "debian" | "pypi" | "docker" | "vagrant" | "gitlfs" | "yum" | "generic"
  debianTrivialLayout false
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
  blockXrayUnscannedArtifacts false
  xrayMinimumBlockedSeverity "" // "Minor" | "Major" | "Critical"
  enableFileListsIndexing ""
  yumGroupFileNames ""
  dockerApiVersion "V2" // default
  maxUniqueTags 0 // default
  optionalIndexCompressionFormats "" // "bz2", "lzma", "xz"
}
}
