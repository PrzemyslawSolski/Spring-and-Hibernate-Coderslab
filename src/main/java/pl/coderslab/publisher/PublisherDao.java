package pl.coderslab.publisher;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Publisher publisher){
        entityManager.persist(publisher);
    }

    public void update(Publisher publisher){
        entityManager.merge(publisher);
    }

    public Publisher findOne(Long id){
        return entityManager.find(Publisher.class, id);
    }

    public void delete(Long id){
        Publisher publisher = findOne(id);
        if (publisher != null){
            entityManager.remove(publisher);
        }
    }
}
