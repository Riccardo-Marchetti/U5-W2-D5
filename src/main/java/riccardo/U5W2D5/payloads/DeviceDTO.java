package riccardo.U5W2D5.payloads;

import java.util.UUID;

public record DeviceDTO(String type, String status, UUID employeeId) {
}
