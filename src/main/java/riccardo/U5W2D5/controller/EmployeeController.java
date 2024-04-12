package riccardo.U5W2D5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardo.U5W2D5.entities.Employee;
import riccardo.U5W2D5.payloads.EmployeeDTO;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping ("/employee")
public class EmployeeController {

//    @GetMapping
//    private List<Employee> getAllEmployee (){
//
//    }
//
//    @GetMapping ("/employeeId")
//    private Employee getEmployeeById (@PathVariable UUID employeeId){
//
//    }
//
//    @PostMapping
//    @ResponseStatus (HttpStatus.CREATED)
//    private Employee saveEmployee (@RequestBody EmployeeDTO body){
//
//    }
//
//    @PutMapping ("/employeeId")
//    private Employee findEmployeeAndUpdate (@PathVariable UUID employeeId, @RequestBody EmployeeDTO body){
//
//    }
//
//    @DeleteMapping ("/employeeId")
//    @ResponseStatus (HttpStatus.NO_CONTENT)
//    private void deleteEmployee (@PathVariable UUID employeeId){
//
//    }

}
