package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String save(Book book) {
        bookDao.save(book);
        return "redirect:/book-form/list";
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.list());
        return "book/list";
    }
}
