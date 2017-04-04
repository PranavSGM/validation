package com.sapient.scala.project_validation

import scala.util.{Failure, Success, Try}

object Validation_2
  {
    //First Name
    def fname(fn:String):String= {
      val pattern_c ="""\b.*[a-zA-Z].*\b""".r
      val pattern = """\b[a-z\sA-Z0-9'_.-]{1,}\b""".r
      val x = pattern_c.findFirstIn(fn)
      if (x.nonEmpty) {
        fn match {
          case pattern(_*) => s"$fn"
          case _ => "--- Invalid ! ---"
        }
      } else "--- Invalid: Char-missing ! ---"
    }
    //Last Name
    def lname(ln:String):String=
    {
      val pattern_c= """\b.*[a-zA-Z].*\b""".r
      val pattern = """\b[a-zA-Z0-9'_.-]{1,}\b""".r
      val x = pattern_c.findFirstIn(ln)
      if (x.nonEmpty)
      {
        ln match
        {
          case pattern(_*) =>  s"$ln"
          case _ => "--- Invalid ! ---"
        }
      } else "--- Invalid: Char-missing ! ---"
    }

    //User-ID
    def userid(uid:String):String=
    {
      val pattern = """\b[0-9]{1,}\b""".r
      uid match
      {
        case pattern(_*) => s"$uid"
        case _ => "--- Invalid ! ---"
      }
    }

   /* def validateUserId(userId:String) : ValidationResult = {
      Try(userId.toInt) match {
        case Success(d) => ValidationResult(
          validatedFieldName = "UserId",
          validationResult =  true,
          errorMessage=None
        )
        case Failure(t) => ValidationResult(
          validatedFieldName = "UserId",
          validationResult =  false,
          errorMessage=Some("UserId is not a valid Integer.")
        )
      }
    }
*/

    //Salary
    def salary(sal:String):String=
    {
      val pattern ="""\b[0-9]{1,}\b""".r
      sal match
      {
        case pattern(_*) => s"$sal"
        case _ => "--- Invalid ! ---"
      }
    }

    //designation
    def desig(des:String):String=
    {
      des match
      {
        case "A"|"a"|"S"|"s"|"D"|"d"|"m"|"M"|"P"|"p" =>s"$des"
        case _ =>"--- Invalid ! ---"
      }
    }


    //Email_ID
    def emailfunc(email:String):String=
    {
      val pattern ="""\b[a-zA-Z0-9\.]+[\@]{1}[a-zA-Z0-9\.]+[\.]{1}[a-zA-Z0-9]{2,6}\b""".r
      email match
      {
        case pattern(_*) =>s"$email"
        case _ =>"--- Invalid ! ---"
      }
    }

    //Timestamp
    def timefunc(time:String):String= {
      import java.text.SimpleDateFormat
      import java.util.Date
      import scala.util.Try

      val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS")
      val test = Try[Date](formatter.parse(time)).toString
      if(test matches "Success.*") s"$test"
      else "--- Invalid ! ---"
    }


    //Main Function
    def main(args: Array[String]): Unit =
    {
      import scala.io

      val bufferedSource = io.Source.fromFile("C:/IntelliJ_IDEA_Projects/src/com/sapient/scala/project_validation/data1.csv")

      for (line <- bufferedSource.getLines)
      {
        val Array(fn, ln, uid, sal, des, email, time)=line.split(",").map(_.trim)

        val fnv = fname(fn)
        val lnv = lname(ln)
        val uidv= userid(uid)
        val salv = salary(sal)
        val desigv = desig(des)
        val emailv= emailfunc(email)
        val timev = timefunc(time)

        if(fnv!=fn | lnv!=ln | uidv != uid | salv != sal | desigv != des |
          emailv !=email |( timev matches ("Failure.*") ) )
        {
          println(s"\n############### InValid Record ! #######################" +
            s"\nFirstName = $fnv\nLastName = $lnv\nUserId = $uidv\nSalary = $salv" +
            s"\nDesignation = $desigv\nEmail ID = $emailv\nTimeStamp = $timev")
        }
        else
        {
          println(s"\n############## Valid Record ! #####################" +
          s"\nFirstName = $fnv\nLastName = $lnv\nUserId = $uidv\nSalary = $salv" +
          s"\nDesignation = $desigv\nEmail ID = $emailv\nTimeStamp = $timev")
        }

      }
      bufferedSource.close

    }
  }



