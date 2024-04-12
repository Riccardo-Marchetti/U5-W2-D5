package riccardo.U5W2D5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardo.U5W2D5.entities.Device;
import riccardo.U5W2D5.entities.Employee;
import riccardo.U5W2D5.exceptions.NotFoundException;
import riccardo.U5W2D5.payloads.DeviceDTO;
import riccardo.U5W2D5.payloads.EmployeeDTO;
import riccardo.U5W2D5.repositories.DeviceDAO;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {
    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private EmployeeService employeeService;

    public List<Device> getAllDevice (){
        return this.deviceDAO.findAll();
    }

    public Device getDeviceById (UUID id){
        return this.deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Device saveDevice (DeviceDTO body){
        Device device = new Device(body.type(), body.status(), this.employeeService.getEmployeeById(body.employeeId()));
        return this.deviceDAO.save(device);
    }

    public Device findDeviceByIdAndUpdate (UUID id, DeviceDTO body){
        Device device = this.deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        device.setType(body.type());
        device.setStatus(body.status());
        device.setEmployee(this.employeeService.getEmployeeById(body.employeeId()));
        return this.deviceDAO.save(device);
    }

    public void deleteDevice (UUID id){
        Device device = this.deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        this.deviceDAO.delete(device);
    }
}
