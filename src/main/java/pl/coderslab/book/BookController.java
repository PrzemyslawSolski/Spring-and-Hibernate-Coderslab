package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }


    @GetMapping("/addold")
    @ResponseBody
    public String add() {
        Book book = new Book();
        book.setTitle("Thinking in Java");

        Publisher publisher = new Publisher();
        publisher.setName("Publisher one");
        publisherService.create(publisher);
        book.setPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Kowalski");
        authorService.create(author);
        List<Author> authors = new ArrayList<>();
        authors.add(author);

        book.setAuthors(authors);
        bookService.create(book);
        return "Book added, id=" + book.getId();

    }

    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "book";

    }

    @PostMapping("/add")
//    @ResponseBody
    public String add(Model model, @ModelAttribute Book book) {
        bookService.create(book);
//        return "Book added, id=" + book.getId();
        return show(model);
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

    @ModelAttribute("publishers")
    public List<Publisher> getPublisher() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthor() {
        return authorService.findAll();
    }
}
