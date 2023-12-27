package ifrn.pi.reservas.reservas.Models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    public static String encoder(String senha){
        BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
        return encoderSenha.encode(senha);
    }
    
}
