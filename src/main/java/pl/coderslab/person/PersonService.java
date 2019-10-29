package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }


    public void create(Person person){
        personDao.create(person);
    }

    public void update(Person person){
        personDao.update(person);
    }

    public Person findOne(Long id){
        return personDao.findOne(id);
    }

    public void delete(Long id){

            personDao.delete(id);

    }
}
