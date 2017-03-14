package com

import com.connection.PostgresConnection

/**
  * Created by knoldus on 14/3/17.
  */
case class Employee(id: Int, name: String)

trait EmployeeTable {
  this: PostgresConnection =>

  import driver.api._

  class EmployeeTable(tag: Tag) extends Table[Employee](tag, "employee") {
    val id = column[Int]("id", O.PrimaryKey)
    val name = column[String]("name")

    def * = (id, name) <> (Employee.tupled, Employee.unapply)
  }

  val employeeQuery = TableQuery[EmployeeTable]
}

trait EmployeeRepo extends EmployeeTable {
  this: PostgresConnection =>

  import driver.api._

  def create = db.run(employeeQuery.schema.create)

  def insert(emp: Employee) = db.run {
    employeeQuery += emp
  }

  def update(employee: Employee) = {
    db.run {
      employeeQuery.filter(_.id === employee.id).update(employee)
    }
  }

  def delete(id: Int) = {
    db.run {
      employeeQuery.filter(_.id === id).delete
    }
  }
  def getAllEmployees={
    db.run{
      employeeQuery.to[List].result
    }
  }

}

object EmployeeRepo extends EmployeeRepo with PostgresConnection

