package pl.coderslab.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    @Autowired
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/book")
    public String validateBook(Model model){
        Book book = new Book();
        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        List<FieldError> fieldErrors = new ArrayList<>();
        if(!errors.isEmpty()){
            for (ConstraintViolation<Book> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                FieldError fieldError = new FieldError(path, message);
                fieldErrors.add(fieldError);
//                System.out.println("Path: " + path + ", message: " + message);
                System.out.println(fieldErrors);
                System.out.println();
             }
        }
        model.addAttribute("errors", fieldErrors);
        return "errors";
    }

    @GetMapping("/author")
    public String validateAuthor(Model model){
        Author author = new Author();
        author.setPesel("123");
        Set<ConstraintViolation<Author>> errors = validator.validate(author);
        List<FieldError> fieldErrors = new ArrayList<>();
        if(!errors.isEmpty()){
            for (ConstraintViolation<Author> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                FieldError fieldError = new FieldError(path, message);
                fieldErrors.add(fieldError);
            }
        }
        model.addAttribute("errors", fieldErrors);
        return "errors";
    }

}
