package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void create(Book book){
        bookDao.create(book);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public Book findOne(Long id){
        Book book = bookDao.findOne(id);
//        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public Book findBookWithAuthors(Long id){
        Book book = bookDao.findOne(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void delete(Long id){
        bookDao.delete(id);
    }

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public List<Book> getRatingList(int rating){
        return bookDao.getRatingList(rating);
    }
}
