package ie.atu.userinterface.Web;

import org.springframework.stereotype.Service;

@Service
public class WebService {
    private final LoginClient loginClient;

    public WebService(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    public String sendMock(Admin admin) {
        return loginClient.login(admin).getBody();
    }
}
