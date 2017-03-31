val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r

"1001-21-99" match {
  case date(year,month,day) => s" was a good year for PLs."
  case _ => "invalid"
}
"2004-01-20" match {
  case date(_*) => "It's a date!"
}
"2003-01-20" match {
  case date(year, _*) => s"$year was a good year for PLs."
}
val embeddedDate = date.unanchored
"Date: 2005-11-20 17:25:18 GMT (10 years, 28 weeks, 5 days, 17 hours and 51 minutes ago)" match {
  case embeddedDate(year, month, day) => s"$year A Scala is born."
}

val dates = "Important dates in history: 2004-01-20, 1958-09-05, 2010-10-06, 2011-07-15"
val firstDate = date.findFirstIn(dates)
val firstyear = for(m<- date.findAllMatchIn(dates)) yield m.group(1)
firstyear.toArray

val mi = date.findAllIn(dates)
mi.toArray

val num ="""(\d+)""".r
val aal= num.findAllIn("1 2 2 3").toList

///***
val p1="""(?<=[a-z])(?=[A-Z])""".r
val cc = p1.findFirstIn("aK").toList

val Process = """([a-cA-C])([^\s]+)""".r // define first, rest is non-space
for (p <- Process findAllIn "aha bah Cah dah") {
  println("p => " +p)
  p match {
  case Process("b", _) => println("first: 'b', some rest")
  case Process(_, rest) => println("some first, rest: " + rest)
  // etc.
}}
println("enter the input")
val inp3= readLine()
val  p32 = """\b.*[a-zA-Z].*\b""".r
val p3 = """\b[a-z\sA-Z0-9,'_.-]{0,}\b""".r
val x =p32.findFirstIn(inp3)
if(x != null) {
  inp3 match {
    case p3(_*) => "Ok"
    case _ => "not ok"
  }
}else println("Empty! Invalid!")




