package riccardo.U5W2D5.payloads;

import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime dateMessage) {
}
