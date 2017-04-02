

import java.text.SimpleDateFormat
import java.util.Date

import scala.util.Try

val date1 = "2022-10-15 10:55:01.000000"
val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS")

val test = Try[Date](formatter.parse(date1)).toString


test matches "Success.*" match {
  case true =>  "valid !"
  case false => "Invalid !"
}