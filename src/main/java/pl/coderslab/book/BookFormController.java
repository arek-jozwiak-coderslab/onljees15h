package pl.coderslab.book;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/book-form")
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherDao.findAll());
        return "book/add";

    }

    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("publishers", publisherDao.findAll());
            return "book/add";
        }
        bookDao.save(book);
        return "redirect:/book-form/list";
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.list());
        return "book/list";
    }
}
