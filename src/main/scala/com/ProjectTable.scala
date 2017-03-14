package com

import com.connection.PostgresConnection

/**
  * Created by knoldus on 14/3/17.
  */
case class Project(name:String,empId:Int)
trait ProjectTable extends EmployeeTable{

  this: PostgresConnection =>

  import driver.api._

  class ProjectTable(tag: Tag) extends Table[Project](tag, "project") {
    val empId = column[Int]("empId")
    val name = column[String]("name")


    def * = (name,empId) <> (Project.tupled,Project.unapply)
    def project=  foreignKey("empid_fk",empId,employeeQuery)(_.id,onUpdate=ForeignKeyAction.Restrict)
  }

  val projectQuery = TableQuery[ProjectTable]
}

trait ProjectRepo extends ProjectTable {
  this: PostgresConnection =>

  import driver.api._

  def create = db.run(projectQuery.schema.create)

  def insert(project: Project) = db.run{
    projectQuery += project
  }

  def update(project:Project) = db.run{
   projectQuery.filter(_.empId===project.empId).update(project)
  }

  def delete(id: Int) = db.run {
    projectQuery.filter(_.empId === id).delete
  }
    def getAllProjects= db.run{
        projectQuery.to[List].result
      }

  }

object ProjectRepo extends ProjectRepo with PostgresConnection
