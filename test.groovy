artifactory('hts-itamarb-db-lb'){
  localRepository("my-repository") {
  description userInput (
    type : "STRING",
    value : "",
    description : "Please provide a description",
       required: false
  )
 }
}