package com.connection

import slick.jdbc.JdbcProfile

/**
  * Created by knoldus on 14/3/17.
  */
trait DBconnection {
val driver:JdbcProfile
  import driver.api._
  val db:Database
}
