package br.com.employeesapi.service.request

import br.com.employeesapi.entities.enums.LevelEnum

data class EmployeeRequestBody(
    val name: String,
    val age: Short,
    val level: LevelEnum
)