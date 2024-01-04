package mx.edu.utez.diagnostico.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.diagnostico.model.dto.PersonDto;
import mx.edu.utez.diagnostico.model.entity.PersonBean;
import mx.edu.utez.diagnostico.service.IPerson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/diagnostico")
public class PersonController {
    private final IPerson personService;

    @PostMapping("/")
    public PersonDto create(@RequestBody PersonDto personDto) {
        PersonBean personSave = personService.save(personDto);
        return PersonDto.builder()
                .id_person(personSave.getId_person())
                .name(personSave.getName())
                .lastname(personSave.getLastname())
                .curp(personSave.getCurp())
                .birthdate(personSave.getBirthdate())
                .build();
    }

    @PutMapping("/")
    public PersonDto update(@RequestBody PersonDto personDto) {
        PersonBean personUpdate = personService.save(personDto);
        return PersonDto.builder()
                .id_person(personUpdate.getId_person())
                .name(personUpdate.getName())
                .lastname(personUpdate.getLastname())
                .curp(personUpdate.getCurp())
                .birthdate(personUpdate.getBirthdate())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        PersonBean person = personService.findById(id);
        personService.delete(person);
    }

    @GetMapping("/")
    public List<PersonBean> persons(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonBean findById(@PathVariable Integer id){
        return personService.findById(id);
    }

}
