package riccardo.U5W2D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue
    @Setter (AccessLevel.NONE)
    private UUID id;

    private String type;

    private String status;

    @ManyToOne
    @JoinColumn (name = "employee_id")
    private Employee employee;

    public Device(String type) {
        this.type = type;
        this.status = "Available";
        this.employee = null;
    }
}
