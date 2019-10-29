package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/add")
//    @ResponseBody
    public String add(Model model) {
//        Author author = new Author();
//        author.setFirstName("Jan");
//        author.setLastName("Kowalski");
//        authorService.create(author);
//        return "Author added id= " + author.getId();
        model.addAttribute("author", new Author());
        return "author";
    }

    @PostMapping("/add")
//    @ResponseBody
    public String add(Model model, @ModelAttribute Author author) {
        authorService.create(author);
        return "redirect:list";
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

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorService.findOne(id));
        return "author";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, @ModelAttribute Author author) {
        authorService.update(author);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
//    @ResponseBody
    public String delete(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/list")
//    @ResponseBody
    public String list(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

}
