package riccardo.U5W2D5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record DeviceDTO(
                        @NotEmpty(message = "Il tipo è obbligatorio")
                        @Size (min = 1 , max = 20, message = "Il tipo deve avere la lunghezza dei caratteri compresa tra 1 e 20")
                        String type,
                        @NotEmpty (message = "Lo stato è obbligatorio")
                        @Size (min = 1 , max = 30, message = "lo stato deve avere la lunghezza dei caratteri compresa tra 1 e 30")
                        String status,
                        @NotNull (message = "L'id del dipendente è obbligatorio")
                        UUID employeeId) {
}
