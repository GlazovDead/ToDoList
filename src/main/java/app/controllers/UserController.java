package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getProfile( Model model,@AuthenticationPrincipal User user ){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        return "profile";
    }
    @PostMapping("/profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String username,
                                @RequestParam String password
    ){
        userService.updateProfile(user,username,password);
        return "redirect:/user/profile";
    }

}
