package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepoCustom {
    List<Book> findByPropositionTrue();
    List<Book> findByPropositionFalse();
    List<Book> findByProposition(boolean proposition);
    List<Book> findByRating(int rating);

    List<Book> findByTitle(String title);

    @Query("select b from Book b where b.title = ?1")
    List<Book> findByTitleQuery(String title);


    List<Book> findByCategoryId(Long id);

    @Query("select b from Book b where b.category.id = :categoryId")
    List<Book> findByCategoryIdQuery(@Param("categoryId") Long categoryId);


    List<Book> findByAuthorsId(Long id);
    List<Book> findByPublisherId (Long id);
    Book findFirstByCategoryIdOrderByTitle(Long id);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findBooksByRatingBetweenQuery(int min, int max);

    @Query("select b from Book b where b.publisher.id =?1")
    List<Book> findBooksByPublisherQuery(long id);

    @Query(value="select * from books where category_id=?1 order by title limit 1", nativeQuery = true)
    Book findFirstBookByCategoryByTitle(long id);

    @Modifying
    @Query("update Book b set b.rating = ?1")
    void resetRatingQuery(int rating);

}