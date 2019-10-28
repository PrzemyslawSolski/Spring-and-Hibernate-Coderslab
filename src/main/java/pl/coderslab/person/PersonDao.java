package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Person person){
        entityManager.persist(person);
    }

    public void update(Person person){
        entityManager.merge(person);
    }

    public Person findOne(Long id){
        return entityManager.find(Person.class, id);
    }

    public void delete(Long id){
        Person person = findOne(id);
        if (person != null){
            entityManager.remove(person);
        }
    }
}
