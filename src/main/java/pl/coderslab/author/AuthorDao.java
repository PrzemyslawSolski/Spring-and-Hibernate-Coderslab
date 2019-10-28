package pl.coderslab.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Author author){
        entityManager.persist(author);
    }

    public void update(Author author){
        entityManager.merge(author);
    }

    public Author findOne(Long id){
        return entityManager.find(Author.class, id);
    }

    public void delete(Long id){
        Author author = findOne(id);
        if (author != null){
            entityManager.remove(author);
        }
    }
}
