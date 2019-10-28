package pl.coderslab.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(PersonDetails personDetails){
        entityManager.persist(personDetails);
    }

    public void update(PersonDetails personDetails){
        entityManager.merge(personDetails);
    }

    public PersonDetails findOne(Long id){
        return entityManager.find(PersonDetails.class, id);
    }

    public void delete(Long id){
        PersonDetails personDetails = findOne(id);
        if (personDetails != null){
            entityManager.remove(personDetails);
        }
    }
}
