package riccardo.U5W2D5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record EmployeeDTO(
                          @NotEmpty(message = "L' username è obbligatorio")
                          @Size(min = 1 , max = 20, message = "L' username deve avere la lunghezza dei caratteri compresa tra 1 e 20")
                          String username,
                          @NotEmpty(message = "Il nome è obbligatorio")
                          @Size (min = 1 , max = 20, message = "Il nome deve avere la lunghezza dei caratteri compresa tra 1 e 20")
                          String name,
                          @NotEmpty(message = "Il cognome è obbligatorio")
                          @Size (min = 1 , max = 20, message = "Il cognome deve avere la lunghezza dei caratteri compresa tra 1 e 20")
                          String surname,
                          @NotEmpty(message = "L'email è obbligatoria")
                          @Email (message = "Email non valida")
                          String email ) {
}
