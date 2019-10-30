package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;
import pl.coderslab.validate.BookValidationGroup;
import pl.coderslab.validate.PropositionValidationGroup;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/propositions")
public class PropositionController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public PropositionController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }


    @GetMapping("/list")
    public String show(Model model) {
        model.addAttribute("books", bookService.findAllPropositions());
        return "books";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
//        model.addAttribute("authors", authorService.findAll());
        return "book";

    }

    @PostMapping("/add")
    public String add(@Validated({PropositionValidationGroup.class}) @ModelAttribute Book book, BindingResult result) {
        if(result.hasErrors()){
            return "book";
        }
        book.setProposition(true);
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
    public String update(Model model, @Validated({PropositionValidationGroup.class}) @ModelAttribute Book book, BindingResult result) {
        if(result.hasErrors()){
            return "book";
        }
        book.setProposition(true);
        bookService.update(book);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        bookService.delete(id);
//        model.addAttribute("book", bookService.findOne(id));
        return "redirect:../../propositions/list";
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
