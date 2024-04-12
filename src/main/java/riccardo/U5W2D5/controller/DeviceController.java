package riccardo.U5W2D5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardo.U5W2D5.entities.Device;
import riccardo.U5W2D5.payloads.DeviceDTO;
import riccardo.U5W2D5.services.DeviceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    private List<Device> getAllDevice (){
        return this.deviceService.getAllDevice();
    }

    @GetMapping ("/{deviceId}")
    private Device getDeviceById (@PathVariable UUID deviceId){
        return this.deviceService.getDeviceById(deviceId);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    private Device saveDevice(@RequestBody DeviceDTO body){
        return this.deviceService.saveDevice(body);
    }

    @PutMapping ("/{deviceId}")
    private Device findDeviceAndUpdate (@PathVariable UUID deviceId, @RequestBody DeviceDTO body){
        return this.deviceService.findDeviceByIdAndUpdate(deviceId, body);
    }

    @DeleteMapping ("/{deviceId}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    private void deleteDevice (@PathVariable UUID deviceId){
        this.deviceService.deleteDevice(deviceId);
    }


}
