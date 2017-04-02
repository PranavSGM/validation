package com.sapient.scala.project_validation


object Regex
{
  //First Name
  def fname():String=
  {
    println("\rEnter First Name =>")
    val fn = readLine()
    val pattern_c = """\b.*[a-zA-Z].*\b""".r
    val pattern = """\b[a-z\sA-Z0-9,'_.-]{1,}\b""".r
    val x = pattern_c.findFirstIn(fn)
    var ans:String =" "
    if (x.nonEmpty)
    {
      fn match
      {
        case pattern(_*) => ans = "Valid !"
        case _ => ans = "Invalid !"
      }
    } else ans = "\rNeed atleast '1' Char !"
    if(ans != "Valid !"){println(ans); fname()}
    else ans

  }
  //Last Name
  def lname():String=
  {
    println();println("Enter Last Name =>")
    val ln = readLine()
    val pattern_c= """\b.*[a-zA-Z].*\b""".r
    val pattern = """\b[a-zA-Z0-9,'_.-]{1,}\b""".r
    val x = pattern_c.findFirstIn(ln)
    var ans:String =""
    if (x.nonEmpty)
    {
      ln match
      {
        case pattern(_*) => ans = "Valid !"
        case _ => ans = "Invalid !"
      }
    } else ans = "\rNeed atleast '1' Char !"
    if(ans != "Valid !"){println(ans); lname()}
    else ans

  }
  //User-ID
  def userid():String=
  {
    println();println("Enter UserID(Digits- 1-6) =>")
    val uid = readLine()
    val pattern = """\b[0-9]{1,6}\b""".r
    var ans:String =""
    uid match
      {
      case pattern(_*) => ans ="Valid !"
      case _ => ans = "Invalid !"
      }
    if(ans != "Valid !"){println(ans);userid()}
    else ans

  }
  //Salary
  def salary():String=
  {
    println();println("Enter Salary(PA In INR) =>")
    val sal =readLine()
    val pattern ="""\b[0-9.]{6,}\b""".r
    var ans:String=""
    sal match
    {
      case pattern(_*) =>ans = "Valid !"
      case _ => ans ="Invalid !"
    }
    if(ans != "Valid !"){println(ans);salary()}
    else ans
  }

  //designation
  def desig():String=
  {
    println() ;println("Enter your designation =>\nA - Associate \nS - Senior Associate \nM - Manager \nD - Director \nP - President ")
    val des = readLine()

    var ans:String=""
    des match
  {
    case "A"|"a"|"S"|"s"|"D"|"d"|"m"|"M"|"P"|"p" =>ans = "Valid !"
    case _ => ans ="Invalid !"
  }
    if(ans != "Valid !"){println(ans);desig()}
    else ans
  }

  //Email_ID
  def email1():String=
  {
    println();println("Enter your emailID =>")
    val email =readLine()
    val pattern ="""\b[a-zA-Z0-9\.]+[\@]{1}[a-zA-Z0-9\.]+[\.]{1}[a-zA-Z0-9]{2,6}\b""".r
    var ans:String=""
    email match
    {
      case pattern(_*) =>ans = "Valid !"
      case _ => ans ="Invalid !"
    }
    if(ans != "Valid !"){println(ans);email1() }
    else ans
  }

  //Timestamp
  def time1():String=
  {
    import java.text.SimpleDateFormat
    import java.util.Date
    import scala.util.Try

    println();println("Enter the timestamp(yyyy-MM-dd hh:mm:ss.SSSSSS)=>")
    val time =readLine()
    val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS")
    val test = Try[Date](formatter.parse(time)).toString
    var ans:String = ""
    test matches "Success.*" match {
      case true => ans = "valid !"
      case false => ans ="Invalid !"
    }
    if( ans != "valid !"){println(ans);time1()}
    else ans

  }

  def main(args: Array[String]): Unit =
  {
   //First name
    val fn_v = fname()
    println(fn_v)

    //Last Name
    val ln_v = lname()
    println(ln_v)

    //UserID
    val uid_v = userid()
    println(uid_v)

    //Salary
    val sal_v = salary()
    println(uid_v)

    //designation
    val desig_v = desig()
    println(desig_v)

    //EmailID
    val email_v =email1()
    println(email_v)

    //timestamp
    val time_v =time1()
    println(time_v)
  }
}
