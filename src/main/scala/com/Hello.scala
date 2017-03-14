package com

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by knoldus on 14/3/17.
  */
object Hello {
  def main(args: Array[String]): Unit = {
    //Await.result(EmployeeRepo.create,Duration.Inf)
    //val result=EmployeeRepo.insert(Employee(1,"ncd"))
    //ProjectRepo.create
    //EmployeeRepo.insert(Employee(2,"Abhay"))
    //EmployeeRepo.update(Employee(2,"Sumit"))
    //val result=Await.result(EmployeeRepo.getAllEmployees,Duration.Inf)
    //println(result)
    Thread.sleep(3000)
  }
}
