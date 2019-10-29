package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

   private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@ModelAttribute Person person){
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);

        personService.create(person);

        return "Person addded id=" + person.getId();
    }

}
