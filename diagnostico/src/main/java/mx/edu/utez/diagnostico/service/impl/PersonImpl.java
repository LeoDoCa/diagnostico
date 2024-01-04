package mx.edu.utez.diagnostico.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.diagnostico.model.dao.PersonDao;
import mx.edu.utez.diagnostico.model.dto.PersonDto;
import mx.edu.utez.diagnostico.model.entity.PersonBean;
import mx.edu.utez.diagnostico.service.IPerson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonImpl implements IPerson {
    private final PersonDao personDao;

    @Override
    @Transactional
    public PersonBean save(PersonDto personDto) {
        PersonBean personBean = PersonBean.builder()
                .id_person(personDto.getId_person())
                .name(personDto.getName())
                .lastname(personDto.getLastname())
                .curp(personDto.getCurp())
                .birthdate(personDto.getBirthdate())
                .build();
        return personDao.save(personBean);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonBean findById(Integer id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonBean> findAll() {
        return (List<PersonBean>) personDao.findAll();
    }

    @Override
    @Transactional
    public void delete(PersonBean personBean) {
        personDao.delete(personBean);
    }
}
