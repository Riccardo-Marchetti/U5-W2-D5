package riccardo.U5W2D5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardo.U5W2D5.entities.Employee;
import riccardo.U5W2D5.exceptions.BadRequestException;
import riccardo.U5W2D5.exceptions.NotFoundException;
import riccardo.U5W2D5.payloads.EmployeeDTO;
import riccardo.U5W2D5.repositories.EmployeeDAO;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployee (){
        return this.employeeDAO.findAll();
    }

    public Employee getEmployeeById (UUID id){
        return  this.employeeDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Employee saveEmployee (EmployeeDTO body){
        this.employeeDAO.findByEmail(body.email()).ifPresent(
                employee -> {
                    throw new BadRequestException("l'email: " + body.email() + " è già in uso");
                }
        );
        Employee employee = new Employee(body.username(), body.name(), body.surname(), body.email());
        employee.setAvatar("https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());
        return this.employeeDAO.save(employee);
    }

    public Employee findEmployeeByIdAndUpdate (UUID id, EmployeeDTO body){
        Employee employee = this.employeeDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        employee.setUsername(body.username());
        employee.setName(body.name());
        employee.setSurname(body.surname());
        employee.setEmail(body.email());
        employee.setAvatar("https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());
        return this.employeeDAO.save(employee);
    }

    public void deleteEmployee (UUID id){
        Employee employee = this.employeeDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        this.employeeDAO.delete(employee);
    }
}
