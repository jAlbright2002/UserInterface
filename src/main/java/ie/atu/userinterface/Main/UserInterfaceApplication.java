package ie.atu.userinterface.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserInterfaceApplication.class, args);
    }

}