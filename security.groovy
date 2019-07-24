Instances = userInput (
  type: "ARTIFACTORY",
  multivalued: true,
  description: "All Instances"
  )

userName = userInput (
    type: "STRING",
    value : "itamarb",
    description : "please provide a user name"
  )

groupName = userInput (
    type: "STRING",
    value : "test_group",
    description : "please provide a group name"
  )

permission = userInput (
    type: "STRING",
    value : "test_permission",
    description : "please provide a permission target name"
  )

repositories = userInput (
    type: "REPOSITORY",
    value : " ",
    description : "please select repositories"
  )

artifactory('hts-itamarb-db-lb'){
security {

groups {
    group(groupName) {
      description 'desc_1'
      autoJoin false
    }
  }

  users {
    user(userName) {
      email 'itamarb@jfrog.com'
      password 'password'
      admin false
      profileUpdatable false
      internalPasswordDisabled false
      groups ([groupName]) // values (['groupA', 'groupB']) are examples. Please set existing values from the instance
    }
  }
  
  permissions {
    permission(permission) {
      includesPattern '**'
      excludesPattern ''
      anyLocal false
      anyRemote false
      anyDistribution false
      repositories (repositories) // values (["local-rep1", "local-rep2", ...]) are examples. Please set existing values from the instance
      users {
        "$userName" (['manage', 'delete', 'deploy', 'annotate', 'read']) // value userA - is example. Please set existing user names from the instance
      }
      groups {
        "$groupName" (['manage', 'delete', 'deploy', 'annotate', 'read']) // value groupsG1 - is example. Please set existing group names from the instance
      }
    }
  }
} 
}
