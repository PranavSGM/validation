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

  def userid():String=
  {
    println();println("Enter UserID =>")
    val uid = readLine()
    val pattern = """\b[0-9]{1,}\b""".r
    var ans:String =""
    uid match
      {
      case pattern(_*) => ans ="Valid !"
      case _ => ans = "Invalid !"
      }
    if(ans != "Valid !"){println(ans);userid()}
    else ans

  }

  def salary():String=
  {
    println();println("Enter Salary =>")
    val sal =readLine()
    val pattern ="""\b[""".r
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
  }
}
