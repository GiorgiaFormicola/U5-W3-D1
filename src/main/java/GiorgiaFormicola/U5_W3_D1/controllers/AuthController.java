package GiorgiaFormicola.U5_W3_D1.controllers;

import GiorgiaFormicola.U5_W3_D1.payloads.LoginDTO;
import GiorgiaFormicola.U5_W3_D1.payloads.LoginResponseDTO;
import GiorgiaFormicola.U5_W3_D1.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginDTO body) {
        return this.authService.checkCredentialsAndGenerateToken(body);
    }
}
