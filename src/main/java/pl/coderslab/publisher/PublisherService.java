package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookDao;

@Service
@Transactional
public class PublisherService {

    private final PublisherDao publisherDao;

    @Autowired
    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public void create(Publisher publisher){
        publisherDao.create(publisher);
    }

    public void update(Publisher publisher){
        publisherDao.update(publisher);
    }

    public Publisher findOne(Long id){
        return publisherDao.findOne(id);
    }

    public void delete(Long id){
        publisherDao.delete(id);
    }
}
