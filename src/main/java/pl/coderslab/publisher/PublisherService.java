package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherService {

    private final PublisherDao publisherDao;
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherDao publisherDao, PublisherRepository publisherRepository) {
        this.publisherDao = publisherDao;
        this.publisherRepository = publisherRepository;
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

    public List<Publisher> findAll(){
        return publisherDao.findAll();
    }

    public Publisher getPublisherByNip(String nip){
        return publisherRepository.findByNip(nip);
    }

    public Publisher getByRegon(String regon){
        return publisherRepository.findByRegon(regon);

    }
}
