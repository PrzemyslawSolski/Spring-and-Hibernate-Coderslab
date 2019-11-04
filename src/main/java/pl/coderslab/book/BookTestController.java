package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookTestController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookTestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping("/{title}")
    @ResponseBody
    public String getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.getBooksByTitle(title);
        return books.toString();
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public String getBooksByCategory(@PathVariable Long id) {
        List<Book> books = bookService.getBooksCategoryId(id);
        return books.toString();
    }

    @GetMapping("/author/{id}")
    @ResponseBody
    public String getBooksByAuthors(@PathVariable Long id) {
        List<Book> books = bookService.getBooksByAuthorsId(id);
        return books.toString();
    }

    @GetMapping("/categoryfirst/{id}")
    @ResponseBody
    public String getFirstBookByCategorySortedByTitle(@PathVariable Long id) {
        Book book = bookService.getFirstBookByCategoryIdOrderByTitle(id);
        return book.toString();
    }

    @GetMapping("rating/{min}/{max}")
    @ResponseBody
    public String getBooksByRatingBetweenQuery(@PathVariable int min, @PathVariable int max) {
        List<Book> books = bookService.getBooksByRatingBetweenQuery( min, max);
        return books.toString();
    }

    @GetMapping("/publisher/{id}")
    @ResponseBody
    public String getBooksByPublisherQuery(@PathVariable Long id) {
        List<Book> books = bookService.getBooksByPublisherQuery(id);
        return books.toString();
    }

    @GetMapping("/categoryfirstq/{id}")
    @ResponseBody
    public String getFirstBookByCategorySortedByTitleQuery(@PathVariable Long id) {
        Book book = bookService.getFirstBookByCategoryByTitle(id);
        return book.toString();
    }

    @GetMapping("/authorp/{begin}")
    @ResponseBody
    public String getAuthorByPeselStartsWith(@PathVariable String begin) {
        List<Author> authors = authorService.getAuthorsByPeselStartsWith(begin);
        return authors.toString();
    }

    @GetMapping("/authore/{begin}")
    @ResponseBody
    public String getAuthorByEmailStartsWith(@PathVariable String begin) {
        List<Author> authors = authorService.getAuthorsByEmailStartsWith(begin);
        return authors.toString();
    }
}
