package context

object Flags {
  val passByValue = 1
  val passByName = 2 //lazy execute
  val passByText = 3 //lazy execute
  var paramaterPassing = passByValue //eager execution, regular one
  var useStaticScopeRule = false
  //if false dynamic scope rule
}