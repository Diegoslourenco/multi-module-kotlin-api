package br.com.employeesapi.service

import br.com.employeesapi.repository.EmployeeRepository
import br.com.employeesapi.service.dto.EmployeeDto
import br.com.employeesapi.service.dto.toEmployee
import br.com.employeesapi.service.dto.toEmployeeDto
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
) {

    fun get(): MutableList<EmployeeDto> {
        val employeeList = employeeRepository.findAll()
        val employeeResponseList = mutableListOf<EmployeeDto>()

        for (employee in employeeList) {
            employeeResponseList.add(
                employee.toEmployeeDto()
            )
        }

        return employeeResponseList
    }


    fun save(employeeDto: EmployeeDto): EmployeeDto {

        val employee = employeeRepository.save(
            employeeDto.toEmployee()
        )

        return employee.toEmployeeDto()
    }
}
