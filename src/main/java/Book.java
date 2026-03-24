import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String genre;
    private String publicationYear;

    @ManyToMany(mappedBy = "books")
    private Set<Reader> readers = new HashSet<>();

    public Book() {
    }

    public Book(String title, String genre, String publicationYear) {
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String toString() {
        return title;
    }

    ;

}
