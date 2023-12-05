package pl.coderslab.person;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons", personDao.findAll());
        return "person/list";
    }

    @GetMapping("/add")
    public String add() {
        return "person/add";
    }

    @PostMapping("/add")
    public String save(Person person) {
        personDao.save(person);
        return "redirect:/person/list";
    }
}
