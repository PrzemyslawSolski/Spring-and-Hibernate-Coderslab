package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import javax.validation.Valid;
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

    @GetMapping("/list")
    public String show(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
//        model.addAttribute("authors", authorService.findAll());
        return "book";

    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Book book, BindingResult result) {
        if(result.hasErrors()){
            return "book";
        }
        bookService.create(book);
        return "redirect:list";
    }

     @GetMapping("/update/{id}")
//    @ResponseBody
    public String update(Model model, @PathVariable Long id) {
        Book book =  bookService.findBookWithAuthors(id);
        model.addAttribute("book",book);
        return "book";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, @Valid @ModelAttribute Book book, BindingResult result) {
        if(result.hasErrors()){
            return "book";
        }
        bookService.update(book);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        bookService.delete(id);
//        model.addAttribute("book", bookService.findOne(id));
        return "redirect:../list";
    }

//    @GetMapping("/delete/confirm/{id}")
//    public String deleteConf(@PathVariable Long id) {
//        bookService.delete(id);
//        return "redirect:../../list";
//    }

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
