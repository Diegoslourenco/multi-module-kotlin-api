package br.com.employeesapi.web.controller

import br.com.employeesapi.service.request.EmployeeRequestBody
import br.com.employeesapi.service.response.EmployeeResponse
import br.com.employeesapi.service.EmployeeService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
@Api
class EmployeeController(
    private val employeeService: EmployeeService
) {

    @GetMapping
    @ApiOperation(value="Return a list of employees")
    fun get(): ResponseEntity<MutableList<EmployeeResponse>> {
        return ResponseEntity<MutableList<EmployeeResponse>>(employeeService.get(), HttpStatus.OK)
    }

    @PostMapping
    @ApiOperation(value="Create an employee")
    fun post(@RequestBody employeeRequest: EmployeeRequestBody): ResponseEntity<EmployeeResponse> {
        return ResponseEntity<EmployeeResponse>(employeeService.save(employeeRequest), HttpStatus.OK)
    }
}