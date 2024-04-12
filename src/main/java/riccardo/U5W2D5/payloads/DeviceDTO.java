package riccardo.U5W2D5.payloads;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record DeviceDTO(
                        @NotEmpty(message = "Il tipo è obbligatorio")
                        @Pattern (regexp = "Smartphone|Tablet|Laptop|smartphone|tablet|laptop", message = "Inserisci un tipo valido tra Smartphone, Tablet, Laptop")
                        @Size (min = 1 , max = 20, message = "Il tipo deve avere la lunghezza dei caratteri compresa tra 1 e 20")
                        String type) {
}
