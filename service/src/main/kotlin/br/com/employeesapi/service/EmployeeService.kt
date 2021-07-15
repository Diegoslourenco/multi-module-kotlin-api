package br.com.employeesapi.service

import br.com.employeesapi.repository.EmployeeRepository
import br.com.employeesapi.repository.domain.Employee
import br.com.employeesapi.service.request.EmployeeRequestBody
import br.com.employeesapi.service.response.EmployeeResponse
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
) {

    fun get(): MutableList<EmployeeResponse> {
        val employeeList = employeeRepository.findAll()
        var employeeResponseList = mutableListOf<EmployeeResponse>()

        for (employee in employeeList) {
            employeeResponseList.add(
                EmployeeResponse(
                    id = employee.id,
                    name = employee.name,
                    age = employee.age,
                    level = employee.level
                )
            )
        }

        return employeeResponseList
    }


    fun save(employeeRequest: EmployeeRequestBody): EmployeeResponse {

        val employee = employeeRepository.save(
            Employee(
                name = employeeRequest.name,
                age = employeeRequest.age,
                level = employeeRequest.level
            )
        )

        return EmployeeResponse(
            id = employee.id,
            name = employee.name,
            age = employee.age,
            level = employee.level
        )
    }
}