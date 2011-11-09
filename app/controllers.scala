package controllers

import play.mvc._
import views.Users._
import models.User
import java.util._
import com.mongodb.casbah.MongoConnection
import com.mongodb.casbah.commons.MongoDBObject

object Application extends Controller {


  def index = {
    views.Application.html.index("Hello You!")
  }
}

object Users extends Controller {
  val mongoConnection = MongoConnection()
  val format = new java.text.SimpleDateFormat("yyyy-MM-dd")

  def findByUsername(username: String) {
    val mongoUser = mongoConnection("scalatest")("users").findOne(MongoDBObject("username" -> username)).get
    val user = new User(mongoUser.get("username").asInstanceOf[String],
      mongoUser.get("fullName").asInstanceOf[String],
      format.parse(mongoUser.get("dateOfBirth").asInstanceOf[String]))

    html.hellouser("Hello You!", user)
  }
}