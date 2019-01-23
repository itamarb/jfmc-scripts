exclude = userInput (
    type: "STRING",
    value : " ",
    description : "please provide an exclude pattern"
  )

artifactory('hts-itamarb-db-lb'){
  localRepository("my-repository") {
  description userInput (
    type : "STRING",
    value : " ",
    description : "Please provide a description"
  )
  includesPattern "**/*" // default
  excludesPattern exclude // default
 }
}