package riccardo.U5W2D5.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardo.U5W2D5.entities.Device;
import riccardo.U5W2D5.payloads.DeviceDTO;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/device")
public class DeviceController {

//    @GetMapping
//    private List<Device> getAllDevice (){
//
//    }
//
//    @GetMapping ("/{deviceId}")
//    private Device getDeviceById (@PathVariable UUID deviceId){
//
//    }
//
//    @PostMapping
//    @ResponseStatus (HttpStatus.CREATED)
//    private Device saveDevice(@RequestBody DeviceDTO body){
//
//    }
//
//    @PutMapping ("/{deviceId}")
//    private Device findDeviceAndUpdate (@PathVariable UUID deviceId, @RequestBody DeviceDTO body){
//
//    }
//
//    @DeleteMapping ("/{deviceId}")
//    @ResponseStatus (HttpStatus.NO_CONTENT)
//    private void deleteDevice (@PathVariable UUID deviceId){
//
//    }


}
