package com.sapient.scala.project_validation

import scala.util.matching.Regex

case class recordFields(
                       firstName :String,
                       lastName :String,
                       userId : Int,
                       salary : Double,
                       designation : Char,
                       emailId : String,
                       timeStamp : String
                       )

/*case class  validationResult3(
                               validatedFieldName : String,
                               validationResult : Boolean,
                               errorMessage : Option[String]
                             )*/

object Validation_Final extends App {

  def validateFirstName(firstName:String) : validationResult = {
    val firstNamePattern: Regex = """\b[a-z\sA-Z0-9'_.-]{1,}\b""".r
    if (firstName.nonEmpty) {
      firstName match {
        case firstNamePattern(_) => validationResult(
          validatedFieldName = "FirstName",
          validationResult = true,
          errorMessage = None)
        case _ => validationResult(
          validatedFieldName = "FirstName",
          validationResult = false,
          errorMessage = Some("Input FirstName is not a valid first name pattern."))
      }
    } else {
      validationResult(
        validatedFieldName = "FirstName",
        validationResult = false,
        errorMessage = Some("FirstName is empty."))
    }
  }


}
