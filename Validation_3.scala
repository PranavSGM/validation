package com.sapient.scala.project_validation

object Validation_3 {
  //First Name
  def fname(fn: String): String = {
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
  def lname(ln: String): String = {
    val pattern_c = """\b.*[a-zA-Z].*\b""".r
    val pattern = """\b[a-zA-Z0-9'_.-]{1,}\b""".r
    val x = pattern_c.findFirstIn(ln)
    if (x.nonEmpty) {
      ln match {
        case pattern(_*) => s"$ln"
        case _ => "--- Invalid ! ---"
      }
    } else "--- Invalid: Char-missing ! ---"
  }

  //User-ID
  def userid(uid: String): String = {
    val pattern = """\b[0-9]{1,}\b""".r
    uid match {
      case pattern(_*) => s"$uid"
      case _ => "--- Invalid ! ---"
    }
  }

  //Salary
  def salary(sal: String): String = {
    val pattern ="""\b[0-9]{1,}\b""".r
    sal match {
      case pattern(_*) => s"$sal"
      case _ => "--- Invalid ! ---"
    }
  }

  //designation
  def desig(des: String): String = {
    des match {
      case "A" | "a" | "S" | "s" | "D" | "d" | "m" | "M" | "P" | "p" => s"$des"
      case _ => "--- Invalid ! ---"
    }
  }


  //Email_ID
  def emailfunc(email: String): String = {
    val pattern ="""\b[a-zA-Z0-9\.]+[\@]{1}[a-zA-Z0-9\.]+[\.]{1}[a-zA-Z0-9]{2,6}\b""".r
    email match {
      case pattern(_*) => s"$email"
      case _ => "--- Invalid ! ---"
    }
  }

  //Timestamp
  def timefunc(time: String): String = {
    import java.text.SimpleDateFormat
    import java.util.Date
    import scala.util.Try

    val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS")
    val test = Try[Date](formatter.parse(time)).toString
    if (test matches "Success.*") s"$test"
    else "--- Invalid ! ---"
  }


  //Main Function
  def main(args: Array[String]): Unit =
  {
    import scala.io
    var records: List[String] = List()
    var recordf: List[String] = List()


      val bufferedSource = io.Source.fromFile("C:/IntelliJ_IDEA_Projects/src/com/sapient/scala/project_validation/data1.csv")

      for (line <- bufferedSource.getLines) {
        val Array(fn, ln, uid, sal, des, email, time) = line.split(",").map(_.trim)

        val fnv = fname(fn)
        val lnv = lname(ln)
        val uidv = userid(uid)
        val salv = salary(sal)
        val desigv = desig(des)
        val emailv = emailfunc(email)
        val timev = timefunc(time)

        var recordf: String = ""
        var records: String = ""

        if (fnv != fn | lnv != ln | uidv != uid | salv != sal | desigv != des |
          emailv != email | (timev matches ("Failure.*"))) {
          recordf = s"\n############### InValid Record ! #######################" +
            s"\nFirstName = $fnv\nLastName = $lnv\nUserId = $uidv\nSalary = $salv" +
            s"\nDesignation = $desigv\nEmail ID = $emailv\nTimeStamp = $timev"

          //println(s"\n***** The Invalid Entries Here are  ***** \n$fnv \n$lnv " +
          // s"\n$uidv \n$salv \n$desigv \n$emailv \n$timev")
        }
        else {
          records = s"\n############## Valid Record ! #####################" +
            s"\nFirstName = $fnv\nLastName = $lnv\nUserId = $uidv\nSalary = $salv" +
            s"\nDesignation = $desigv\nEmail ID = $emailv\nTimeStamp = $timev"
        }
      }
      bufferedSource.close
      println("\nWhich type of records, you want to see :\n1 - Success \n2 - Failed")
      val inp = readLine()
      //inp match
      // {
      //   case "1" => println(record)
      // case "2" => println
      //}



  }

}