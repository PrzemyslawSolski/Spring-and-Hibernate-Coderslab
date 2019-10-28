package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String add() {
        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Kowalski");
        authorService.create(author);
        return "Author added id= " + author.getId();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Author author = authorService.findOne(id);
        if (author != null) {
            return author.toString();
        }
        return "Author not found";
    }

    @GetMapping("/update")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Author author = authorService.findOne(id);
        author.setFirstName("nowy!!!!");
        authorService.update(author);
        return "Author updated, id= " + author.getId();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        authorService.delete(id);
        return "Author deleted id = " + id;
    }
}
