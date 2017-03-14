package com.connection

import slick.jdbc.{JdbcProfile, PostgresProfile}
import slick.jdbc.PostgresProfile.api._

trait PostgresConnection extends DBconnection{
val driver:JdbcProfile=PostgresProfile
  val db:Database=Database.forConfig("myPostgresDB")
}
