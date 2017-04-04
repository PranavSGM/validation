package com.sapient.scala.project_validation
import scala.util.{Failure, Success, Try}
import scala.util.matching.Regex

/*ase class  ValidationResult(
                             validatedFieldName : String,
                             validationResult : Boolean,
                             errorMessage : Option[String]
                           )*/
object sid {
  def validateFirstName(firstName:String) : ValidationResult= {

    val firstNamePattern: Regex = """\b[a-z\sA-Z0-9'_.-]{1,}\b""".r
    firstName.nonEmpty match {
      case true =>
        firstName match {
          case firstNamePattern(_) => ValidationResult(
            validatedFieldName = "FirstName",
            validationResult = true,
            errorMessage = None)
          case _ => ValidationResult(
            validatedFieldName = "FirstName",
            validationResult =  false,
            errorMessage=Some("Input FirstName is not a valid first name pattern.")
          )
        }
      case false => ValidationResult(
        validatedFieldName = "FirstName",
        validationResult =  false,
        errorMessage=Some("FirstName is empty."))
    }
  }

  //First Name
  def fname(fn:String):String= {
    val pattern = """\b[a-z\sA-Z0-9'_.-]{1,}\b""".r
    if (fn.nonEmpty) {
      fn match {
        case pattern(_) => s"$fn"
        case _ => "--- Invalid ! ---"
      }
    } else "--- Invalid: Char-missing ! ---"
  }

}
object TestData extends App{
  val startTime = System.currentTimeMillis()
  for(i <- 1 to 100000){
    Validation_2.fname("PRANAV")
  }
  val endTime = System.currentTimeMillis()
  println(s"Time taken by fname [${endTime-startTime}]ms")

  val startTime1 = System.currentTimeMillis()
  for(i <- 1 to 100000){
    Validation_2.validateFirstName("PRANAV")
  }
  val endTime1 = System.currentTimeMillis()
  println(s"Time  validateFirstName taken [${endTime1-startTime1}]ms")
}