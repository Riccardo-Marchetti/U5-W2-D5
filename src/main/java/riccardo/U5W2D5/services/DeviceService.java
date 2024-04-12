package riccardo.U5W2D5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import riccardo.U5W2D5.entities.Device;
import riccardo.U5W2D5.exceptions.NotFoundException;
import riccardo.U5W2D5.payloads.DeviceDTO;
import riccardo.U5W2D5.repositories.DeviceDAO;

import java.util.UUID;


@Service
public class DeviceService {
    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private EmployeeService employeeService;

    public Page<Device> getAllDevice (int page, int size, String sortBy){
        if (size > 30) size = 30;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.deviceDAO.findAll(pageable);
    }

    public Device getDeviceById (UUID id){
        return this.deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Device saveDevice (DeviceDTO body){
        Device device = new Device(body.type(), body.status(), employeeService.findEmployeeById(body.employeeId()));
        return this.deviceDAO.save(device);
    }

    public Device findDeviceByIdAndUpdate (UUID id, DeviceDTO body){
        Device device = this.deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        device.setType(body.type());
        device.setStatus(body.status());
        device.setEmployee(this.employeeService.findEmployeeById(body.employeeId()));
        return this.deviceDAO.save(device);
    }

    public void deleteDevice (UUID id){
        Device device = this.deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        this.deviceDAO.delete(device);
    }
}
