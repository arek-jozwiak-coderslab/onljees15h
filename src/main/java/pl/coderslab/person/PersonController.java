package pl.coderslab.person;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "person/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("countries",
                Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark"));
        model.addAttribute("isAdult", false);
        return "person/add";
    }

    @PostMapping("/add")
    public String save(Person person) {
        personService.save(person);
        return "redirect:/person/list";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        int a = 1;
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("isAdult")
    public boolean isAdult(){
        return false;
    }
}
