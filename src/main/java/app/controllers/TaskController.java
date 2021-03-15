package app.controllers;

import app.models.Task;
import app.models.User;
import app.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/userTasks")
public class TaskController {
    @Autowired
    private TaskRepo taskRepo;


    @GetMapping("/{user}")
    public String getTasks(
                           @PathVariable User user,
                           Model model,
                           @RequestParam(required = false) Task task) {
        List<Task> tasks = taskRepo.findByAuthor(user);
        model.addAttribute("task", task);
        model.addAttribute("tasks", tasks);
        return "userTasks";
    }

    @PostMapping("/{user}")
    public String createTask(
            @Valid Task task,
            BindingResult bindingResult,
            @PathVariable User user,
            Model model
    ) {
        task.setAuthor(user);
        if (bindingResult.hasErrors()) {
            model.addAttribute("task", task);
        } else {
            model.addAttribute("task", null);
            taskRepo.save(task);
        }
        Iterable<Task> tasks = taskRepo.findAll();
        model.addAttribute("tasks", tasks);
        return "redirect:/userTasks/" + user.getId();
    }

    @GetMapping("/{user}/{task}")
    public String getChangeForm(@PathVariable User user,
                                @PathVariable Task task,
                                Model model) {
        model.addAttribute("task", task);
        return "taskChange";
    }

    @PostMapping("/{user}/{task}")
    public String changeTask(
                             @PathVariable Long user,
                             @PathVariable Task task,
                             @RequestParam("text") String text,
                             @RequestParam("timer") Integer timer) {
        task.setText(text);
        task.setTimer(timer);

        taskRepo.save(task);
        return "redirect:/userTasks/" + user;
    }

    @PostMapping("/{user}/delete/{task}")
    public String completeTask(
            @PathVariable Long user,
            @PathVariable Task task) {
        taskRepo.deleteById(task.getId());
        return "redirect:/userTasks/" + user;
    }
}
