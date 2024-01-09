package ie.atu.userinterface.Login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginAuthClient loginAuthClient;

    public LoginService(LoginAuthClient loginAuthClient) {
        this.loginAuthClient = loginAuthClient;
    }

    public String authenticate(User user) {
        String abc = loginAuthClient.authenticate(user).getBody();
        System.out.println("Inside authenticate method");
        System.out.println(abc);
        System.out.println(user);
        return abc;
    }
}
