package com.sapient.scala.project_validation

object validation
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

  def main(args: Array[String]): Unit =
  {
    import scala.io
    println("***** File Schema *****\nFirstName\nLastName" +
                                    "\nUserID\nSalary\nDesignation\nEmailID\nTimeStamp")
      val bufferedSource = io.Source.fromFile("C:/IntelliJ_IDEA_Projects/src/com/sapient/scala/project_validation/data1.csv")
      for (line <- bufferedSource.getLines)
      {
        val Array(fn, ln, uid, sal, des, email, time)=line.split(",").map(_.trim)
        println(s"\n***** File Entry ${line(_)}***** \n$fn\n$ln" +
                s"\n$uid\n$sal\n$des\n$email\n$time")
        val fnv = fname(fn)
        val lnv = lname(ln)
        val uidv= userid(uid)
        val salv = salary(sal)
        val desigv = desig(des)
        val emailv= emailfunc(email)
        val timev = timefunc(time)
        println(s"\n***** Validated Data ***** \n$fnv \n$lnv " +
                s"\n$uidv \n$salv \n$desigv \n$emailv \n$timev")
      }
      bufferedSource.close
  }
}
