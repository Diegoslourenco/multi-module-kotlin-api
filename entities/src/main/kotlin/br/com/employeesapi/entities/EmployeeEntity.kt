package br.com.employeesapi.entities

import br.com.employeesapi.entities.enums.LevelEnum

data class EmployeeEntity (
    val id: Long = 0,
    val name: String,
    val age: Short,
    val level: LevelEnum
)
