package models

import java.util._
import org.joda.time.{DateTime, Years, DateMidnight}

class User(val username: String, var fullName: String, var birthDate: Date) {

  def age(onDate:Date):Int = {
    val birthdate = new DateMidnight(birthDate)
    val now = new DateTime(onDate)
    val age = Years.yearsBetween(birthdate, now)
    age.getYears()
  }

  def firstName():String = {
    val firstNameR = "(^[^\\s]*).*".r
    val firstNameR(firstName) = fullName
    firstName
  }
}