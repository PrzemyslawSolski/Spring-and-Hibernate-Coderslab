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
        authorDao.create(author);
    }

    public void update(Author author){
        authorDao.update(author);
    }

    public Author findOne(Long id){
        return authorDao.findOne(id);
    }

    public List<Author> findAll(){
        return authorDao.findAll();
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

}
