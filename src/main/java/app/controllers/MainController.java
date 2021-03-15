package app.controllers;

import app.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private TaskRepo taskRepo;


    @GetMapping("/")
    public String mainPageOrSingUp(Model model){
        model.addAttribute("tasks",taskRepo.findAll());
        return "main";
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }


}
