package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book-form")
public class BookFormController {

    private final PublisherDao publisherDao;

    private final BookRepository bookRepository;

    public BookFormController( PublisherDao publisherDao, BookRepository bookRepository) {

        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherDao.findAll());
        return "book/add";

    }

    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherDao.findAll());
            return "book/add";
        }
        bookRepository.save(book);
        return "redirect:/book-form/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> thibnkingInJava = bookRepository.findAllByTitle("Thibnking in java");
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }
}
