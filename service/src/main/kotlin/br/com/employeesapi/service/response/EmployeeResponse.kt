package br.com.employeesapi.service.response

import br.com.employeesapi.entities.enums.LevelEnum

data class EmployeeResponse(
    val id: Long,
    val name: String,
    val age: Short,
    val level : LevelEnum
)
