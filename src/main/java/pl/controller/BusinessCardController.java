package pl.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.service.PersonService;


@Controller
@RequestMapping("person")
@AllArgsConstructor


public class BusinessCardController {

    private final PersonService personService;

    @GetMapping("/list")
    public String getPersons (Model model) {
        model.addAttribute("person", personService.getPersons());
        return "list";

    }



    @GetMapping("details/{personUUID"})
    public String getPerson(@PathVariable UUID personUUID, Model model) {
        model.addAttribute("person", personService.getPerson(personUUID));


        return "details";
    }

    @GetMapping("/add")
    public String addPerson (Model model) {
        final Person person = Person.builder().address(Address.builder().build()).build();
        model.addAtribbute("person", person);
        model.addAtribbute("action", "/person/edit");
        return "edit";




    @PostMapping ("/add")
    public String addPerson(Person person){
        personService.save(person);
        return "redirect:/person/list";

    }

    //*  tworze metody do edycji klienta //

    @GetMapping tMapping ("/edit/{personUUID}")
    public String editPerson(@PathVariable UUID personUUID, Modl model) {
        final Person person = personService.getPerson(personUUID);
        model.addAttribute( person", person);
        model.addAtribbute("action", "/person/edit" + personUUID);
        return "edit";
    }

    @PostMapping("/edit/{personUUID}")
    public String editPerson(@PathVariable UUID personUUID,Person person){
        personService.editPerson(personUUID, person);
        return "redirect:/person/list";
        }


    @PostMapping("/delete/{personUuid"})
    public String deletePerson (@PathVariable UUID personUUID){
    personService.delete(personUUID);
        return "redirect:/person/list"
}