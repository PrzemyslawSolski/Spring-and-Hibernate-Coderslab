package pl.coderslab.book;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class BookRepoCustomImpl implements BookRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating (int rating){
        Query query = entityManager.createQuery("update Book b set b.rating = :rating");
        query.setParameter("rating", rating);
        query.executeUpdate();
    }
}
