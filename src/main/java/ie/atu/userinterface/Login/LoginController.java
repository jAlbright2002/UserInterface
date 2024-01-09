package ie.atu.userinterface.Login;

import feign.FeignException;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/loginPage")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession httpSession, Model model) {
        System.out.println("/loginPager method ran");
        try {
            User user = new User(username, password);

            if (loginService.authenticate(user).equals("Admin authenticated successfully")) {
                System.out.println("Inside loginService.authenticate");
                httpSession.setAttribute("loggedIn", true);
                return "redirect:/admin";
            } else {
                System.out.println("Inside else after loginService.authenticate");
                model.addAttribute("error", "Invalid credentials");
                return "redirect:/loginPage";
            }
        } catch (FeignException.Unauthorized e) {
            System.out.println("Unauthorized running");
            model.addAttribute("error", "Unauthorized: Invalid username or password");
            return "redirect:/loginPage";
        } catch (Exception e) {
            System.out.println("General exception running");
            System.out.println(e);
            model.addAttribute("error", "An error occurred. Please try again.");
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }
}
