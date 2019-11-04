package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorDao authorDao, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
    }

    public void create(Author author){
        authorRepository.save(author);
    }

    public void update(Author author){
        authorRepository.save(author);
    }

    public Author findOne(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public void delete(Long id){
        authorDao.deleteAuthorRelations(id);
        authorDao.delete(id);
    }

    public Author getAuthorByEmail(String email){
        return authorRepository.findByEmail(email);
    }

    public Author getAuthorByPesel(String pesel){
        return authorRepository.findByPesel(pesel);
    }

    public List<Author> getAuthorsByLastName (String lastName){
        return authorRepository.findByLastName(lastName);
    }

    public List<Author> getAuthorsByEmailStartsWith(String emailPrefix){
        return authorRepository.findByEmailStartsWith(emailPrefix);
    }

    public List<Author> getAuthorsByPeselStartsWith(String peselPrefix){
        return authorRepository.findByPeselStartsWith(peselPrefix);
    }

}
