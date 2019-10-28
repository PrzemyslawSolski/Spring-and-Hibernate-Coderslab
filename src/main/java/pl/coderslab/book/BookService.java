package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return bookDao.findOne(id);
    }

    public void delete(Long id){
        bookDao.delete(id);
    }
}
