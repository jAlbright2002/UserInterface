package ie.atu.userinterface.Login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginAuthClient loginAuthClient;

    public LoginService(LoginAuthClient loginAuthClient) {
        this.loginAuthClient = loginAuthClient;
    }

    public String authenticate(User user) {
        return loginAuthClient.authenticate(user).getBody();
    }


}
