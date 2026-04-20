package GiorgiaFormicola.U5_W3_D1.services;

import GiorgiaFormicola.U5_W3_D1.entities.Employee;
import GiorgiaFormicola.U5_W3_D1.exceptions.NotFoundException;
import GiorgiaFormicola.U5_W3_D1.exceptions.UnauthorizedException;
import GiorgiaFormicola.U5_W3_D1.payloads.LoginDTO;
import GiorgiaFormicola.U5_W3_D1.payloads.LoginResponseDTO;
import GiorgiaFormicola.U5_W3_D1.security.TokenTools;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private EmployeesService employeesService;
    private TokenTools tokenTools;

    public LoginResponseDTO checkCredentialsAndGenerateToken(LoginDTO body) {
        try {
            Employee found = this.employeesService.findByEmail(body.email());
            if (!found.getPassword().equals(body.password()))
                throw new UnauthorizedException("Wrong credentials supplied");
            String accessToken = this.tokenTools.generateToken(found);
            return new LoginResponseDTO(accessToken);
        } catch (NotFoundException ex) {
            throw new UnauthorizedException("Wrong credentials supplied");
        }
    }
}
