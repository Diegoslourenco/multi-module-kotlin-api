package br.com.employeesapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmployeesApiApplication

fun main(args: Array<String>) {
    runApplication<EmployeesApiApplication>(*args)
}