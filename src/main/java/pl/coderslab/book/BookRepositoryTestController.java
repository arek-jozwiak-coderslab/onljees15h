package pl.coderslab.book;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookRepositoryTestController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookRepositoryTestController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/test-repo")
    @ResponseBody
    public String hello() {
        Category one = categoryRepository.getOne(1l);
        System.out.println("------- title----------");
        bookRepository.findAllByTitle("test").
                stream().map(b -> b.getTitle())
                .forEach(System.out::println);
        System.out.println("--------category---------");
        bookRepository.findAllByCategory(one).
                stream().map(b -> b.getTitle())
                .forEach(System.out::println);
        System.out.println("--------category id---------");
        bookRepository.findAllByCategoryId(1l).
                stream().map(b -> b.getTitle())
                .forEach(System.out::println);

        return "Hello World";
    }

}
