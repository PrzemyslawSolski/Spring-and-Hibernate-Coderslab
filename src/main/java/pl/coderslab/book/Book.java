package pl.coderslab.book;

import org.hibernate.validator.constraints.Range;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.validate.BookValidationGroup;
import pl.coderslab.validate.PropositionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups={BookValidationGroup.class, PropositionValidationGroup.class})
    @Size(min=5, groups={BookValidationGroup.class})
    private String title;

    @Range(min = 1, max = 10, groups={BookValidationGroup.class})
    private int rating;

    @Min(value = 2, groups={BookValidationGroup.class})
    private int pages;

    private boolean proposition;

    @NotBlank(groups={PropositionValidationGroup.class})
    @Size(max = 600, groups={BookValidationGroup.class, PropositionValidationGroup.class})
    private String description;

    @NotNull(groups={BookValidationGroup.class})
    @ManyToOne
    private Publisher publisher;

    @NotEmpty(groups={BookValidationGroup.class})
    @ManyToMany
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
