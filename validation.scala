package com.sapient.scala.validation

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
        case _ => "***** Invalid !"
      }
    } else "***** Invalid !"
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
          case _ => "***** Invalid !"
        }
      } else "***** Invalid !"
    }

  //User-ID
  def userid(uid:String):String=
  {
    val pattern = """\b[0-9]{1,}\b""".r
    uid match
    {
      case pattern(_*) => s"$uid"
      case _ => "***** Invalid !"
    }
  }

  //Salary
  def salary(sal:String):String=
  {
    val pattern ="""\b[0-9]{1,}\b""".r
    var ans:String=""
    sal match
    {
      case pattern(_*) => s"$sal"
      case _ => "***** Invalid !"
    }
  }

  //designation
  def desig(des:String):String=
  {
    des match
    {
      case "A"|"a"|"S"|"s"|"D"|"d"|"m"|"M"|"P"|"p" =>s"$des"
      case _ =>"***** Invalid !"
    }
  }

  //Email_ID
  def emailfunc(email:String):String=
  {
    val pattern ="""\b[a-zA-Z0-9\.]+[\@]{1}[a-zA-Z0-9\.]+[\.]{1}[a-zA-Z0-9]{2,6}\b""".r
    email match
    {
      case pattern(_*) =>s"$email"
      case _ =>"Invalid !"
    }
  }

  //Timestamp
  def timefunc(time:String):String= {
    import java.text.SimpleDateFormat
    import java.util.Date
    import scala.util.Try

    val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS")
    val test = Try[Date](formatter.parse(time)).toString
    test matches "Success.*" match {
      case true =>"valid !"
      case false =>"Invalid !"
    }
  }
  def main(args: Array[String]): Unit =
  {
    println("FirstName | LastName | UserID | Salary | Designation | EmailID | TimeStamp")
      val bufferedSource = io.Source.fromFile("c:/Scala_Project/tmpfile/data1.csv")
      for (line <- bufferedSource.getLines)
      {
        val cols = line.split(",").map(_.trim)
        // do whatever you want with the columns here
        println(s"\nInput file values => \n${cols(0)}\n${cols(1)}" +
          s"\n${cols(2)}\n${cols(3)}\n${cols(4)}\n${cols(5)}\n${cols(6)}")
      }
      bufferedSource.close

    val bufferedsource1 = io.Source.fromFile("c:/Scala_Project/tmpfile/data1.csv")
    for(line <- bufferedsource1.getLines)
    {
      val Array(fn, ln, uid, sal, des, email, time)=line.split(",").map(_.trim)
      val fnv = fname(fn)
      val lnv = lname(ln)
      val uidv= userid(uid)
      val salv = salary(sal)
      val desigv = desig(des)
      val emailv= emailfunc(email)
      val timev = timefunc(time)
      println(s"\nvalidation = \n$fnv \n$lnv \n$uidv \n$sal \n$desigv \n$emailv \n$timev")
    }
    bufferedsource1.close
  }
}
