package GiorgiaFormicola.U5_W3_D1.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LoginDTO(
        @NotNull(message = "Email is mandatory")
        @Email(message = "Email must follow a valid email format")
        String email,
        @NotNull(message = "Password is mandatory")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Password must follow a valid password format")
        String password
) {
}
