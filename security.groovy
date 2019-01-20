userName = userInput (
    type: "STRING",
    value : "itamarb",
    description : "please provide a user name"
  )


security {
  users {
    conflictResolutionPolicy "OVERRIDE" // default
    user(userName) {
      email 'iutamarb@jfrog.com'
      password 'password'
      admin false
      profileUpdatable false
      internalPasswordDisabled false
      groups (['groupA', 'groupB']) // values (['groupA', 'groupB']) are examples. Please set existing values from the instance
    }
  }
  
  groups {
    conflictResolutionPolicy "OVERRIDE" // default
    group('test_group') {
      description 'desc_1'
      autoJoin false
    }
  }
  
  permissions {
    conflictResolutionPolicy "OVERRIDE" // default
    permission('test_permission') {
      includesPattern '**'
      excludesPattern ''
      anyLocal false
      anyRemote false
      anyDistribution false
      repositories (["libs-release-local", "generic-local"]) // values (["local-rep1", "local-rep2", ...]) are examples. Please set existing values from the instance
      users {
        userName (['manage', 'delete', 'deploy', 'annotate', 'read']) // value userA - is example. Please set existing user names from the instance
      }
      groups {
        test_group (['manage', 'delete', 'deploy', 'annotate', 'read']) // value groupsG1 - is example. Please set existing group names from the instance
      }
    }
  }
} 
