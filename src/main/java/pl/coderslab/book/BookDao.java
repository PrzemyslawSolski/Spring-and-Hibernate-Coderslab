package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Book book){
        entityManager.persist(book);
    }

    public void update(Book book){
        entityManager.merge(book);
    }

    public Book findOne(Long id){
        return entityManager.find(Book.class, id);
    }

    public void delete(Long id){
        Book book = findOne(id);
        if (book != null){
            entityManager.remove(book);
        }
    }
}
