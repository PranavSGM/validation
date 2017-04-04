import scala.io
println("***** File Schema *****\nFirstName\nLastName" +
  "\nUserID\nSalary\nDesignation\nEmailID\nTimeStamp")
val input = io.Source.fromFile("C:/IntelliJ_IDEA_Projects/src/com/sapient/scala/project_validation/data1.csv")

println(input.getClass.getName)
for (line <- input.getLines) {

  println("Line=" +line.getClass)
  val cols = line.split(",").map(_.trim)
  println("cols="+cols.getClass.getName)


  val Array(fn, ln, uid, sal, des, email, time) = line.split(",").map(_.trim)
  println(s"\n***** File Entry ***** \n$fn\n$ln" +
    s"\n$uid\n$sal\n$des\n$email\n$time")
}


val s="     eggs,   milk,butter,CocoPuffs    "
val items = s.split(",").map(_.trim)

val x = List(1,2,32,11).mkString(",")

val l = List(1,3,5,6,21)

var dm  = List[String]()
var dk = List[Map[String,AnyRef]]()

dm = "text" :: dm

var lx = List(1,2,3)
lx = List(1,7)
//lx= List("say")

var x2 = 's'
x2 = 'd'
//x2 = "say"







