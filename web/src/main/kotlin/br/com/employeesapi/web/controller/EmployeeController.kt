package br.com.employeesapi.web.controller

import br.com.employeesapi.service.dto.EmployeeDto
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
    @ApiOperation
    fun get(): ResponseEntity<MutableList<EmployeeDto>> {
        return ResponseEntity<MutableList<EmployeeDto>>(employeeService.get(), HttpStatus.OK)
    }

    @PostMapping
    @ApiOperation(value="Create an employee")
    fun post(@RequestBody employeeDto: EmployeeDto): ResponseEntity<EmployeeDto> {
        return ResponseEntity<EmployeeDto>(employeeService.save(employeeDto), HttpStatus.OK)
    }
}
