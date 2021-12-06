package pl.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.model.Person;
import pl.service.PersonService;

@RestController
@RequestMapping("person-rest")
@AllArgsConstructor

public class PersonControler {

    private final PersonService personService;

    @GetMapping ("details")
    public Person getPerson(){
        return personService.getPerson();
    }

}
