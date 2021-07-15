package br.com.employeesapi.service.dto

import br.com.employeesapi.entities.enums.LevelEnum
import br.com.employeesapi.repository.domain.Employee

data class EmployeeDto(
    val id: Long = 0,
    val name: String,
    val age: Short,
    val level: LevelEnum
)

fun Employee.toEmployeeDto() =
    EmployeeDto(
        id = this.id,
        name = this.name,
        age = this.age,
        level = this.level
    )

fun EmployeeDto.toEmployee() =
    Employee(
        id = this.id,
        name = this.name,
        age = this.age,
        level = this.level
    )
