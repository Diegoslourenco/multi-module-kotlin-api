package br.com.employeesapi.repository.domain

import br.com.employeesapi.entities.enums.LevelEnum
import javax.persistence.*

@Entity
class Employee(

    @Id
    @GeneratedValue
    var id: Long = 0,

    val name: String,

    val age: Short,

    @Enumerated(EnumType.STRING)
    val level: LevelEnum
)
