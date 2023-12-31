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
        try {
            User user = new User(username, password);

            if (loginService.authenticate(user).equals("Admin authenticated successfully")) {
                httpSession.setAttribute("loggedIn", true);
                return "redirect:/admin";
            } else {
                model.addAttribute("error", "Invalid credentials");
                return "redirect:/loginPage";
            }
        } catch (FeignException.Unauthorized e) {
            model.addAttribute("error", "Unauthorized: Invalid username or password");
            return "redirect:/loginPage";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred. Please try again.");
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }
}
