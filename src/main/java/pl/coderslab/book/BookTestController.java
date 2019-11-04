package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookTestController {

    private final BookService bookService;

    @Autowired
    public BookTestController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("/{title}")
    @ResponseBody
    public String getBooksByTitle(@PathVariable String title){
        List<Book> books = bookService.getBooksByTitle(title);
        return books.toString();
     }

    @GetMapping("/category/{id}")
    @ResponseBody
    public String getBooksByTitle(@PathVariable Long id){
        List<Book> books = bookService.getBooksCategoryId(id);
        return books.toString();
    }

}
