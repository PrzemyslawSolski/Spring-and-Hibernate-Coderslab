package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookDao) {
        this.bookRepository = bookDao;
    }

    public void create(Book book){
        bookRepository.save(book);
    }

    public void update(Book book){
        bookRepository.save(book);
    }

    public Book findOne(Long id){
        Book book = bookRepository.findById(id).orElse(null);
//        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public Book findBookWithAuthors(Long id){
        Book book = findOne(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> findAll(){
        return bookRepository.findByPropositionFalse();
    }

    public List<Book> findAllPropositions(){
        return bookRepository.findByPropositionTrue();
    }

    public List<Book> getRatingList(int rating){
        return bookRepository.findByRating(rating);
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findByTitle(title);

    }

    public List<Book> getBooksCategoryId(Long id){
        return bookRepository.findByCategoryId(id);
    }

}
