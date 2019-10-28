package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/add")
    @ResponseBody
    public String add() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        bookService.create(book);
        return "Book added, id=" + book.getId();

    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Book book = bookService.findOne(id);
        book.setTitle("Thinking in Javvvaaa!!!!");
        bookService.update(book);
        return "Book updated, id= " + book.getId();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "Book deleted id = " + id;
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Book book = bookService.findOne(id);
        if (book != null) {
            return book.toString();
        }
        return "Book not found";
    }
}
