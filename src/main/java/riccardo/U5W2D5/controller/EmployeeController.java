package riccardo.U5W2D5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import riccardo.U5W2D5.entities.Employee;
import riccardo.U5W2D5.exceptions.BadRequestException;
import riccardo.U5W2D5.payloads.EmployeeDTO;
import riccardo.U5W2D5.services.EmployeeService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    private Page<Employee> getAllEmployee (@RequestParam (defaultValue = "0") int page, @RequestParam (defaultValue = "30") int size, @RequestParam (defaultValue = "username") String sortBy){
        return this.employeeService.getAllEmployee(page, size, sortBy);
    }

    @GetMapping ("/{employeeId}")
    private Employee getEmployeeById (@PathVariable UUID employeeId){
        return this.employeeService.findEmployeeById(employeeId);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    private Employee saveEmployee (@RequestBody @Validated EmployeeDTO body, BindingResult validation){
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }
        return this.employeeService.saveEmployee(body);
    }

    @PutMapping ("/{employeeId}")
    private Employee findEmployeeAndUpdate (@PathVariable UUID employeeId, @RequestBody EmployeeDTO body){
        return this.employeeService.findEmployeeByIdAndUpdate(employeeId, body);
    }

    @DeleteMapping ("/{employeeId}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    private void deleteEmployee (@PathVariable UUID employeeId){
        this.employeeService.deleteEmployee(employeeId);
    }

}
