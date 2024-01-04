package mx.edu.utez.diagnostico.service;

import mx.edu.utez.diagnostico.model.dto.PersonDto;
import mx.edu.utez.diagnostico.model.entity.PersonBean;

import java.util.List;

public interface IPerson {
    PersonBean save(PersonDto personDto);
    PersonBean findById(Integer id);
    List<PersonBean> findAll();
    void delete (PersonBean personBean);

}
