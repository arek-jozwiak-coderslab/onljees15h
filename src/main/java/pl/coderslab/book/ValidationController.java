package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String hello() {

        Book book = new Book();
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        for (ConstraintViolation<Book> bookConstraintViolation : validate) {
            System.out.println(bookConstraintViolation.getPropertyPath());
            System.out.println(bookConstraintViolation.getMessage());
        }
        validate.forEach(cv ->
                System.out.println(String.join(" ",
                        cv.getPropertyPath().toString(), cv.getMessage())));
        return "Hello World";
    }
}
