package pl.coderslab.person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }
    public List<Person> findAll(){
        return personDao.findAll();
    }

    public void save(Person person) {
        personDao.save(person);
    }
}
