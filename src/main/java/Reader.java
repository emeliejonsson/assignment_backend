import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(name = "reader_book")
    private Set<Book> books = new HashSet<>();

    public Reader() {}

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
        this.books = new HashSet<Book>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addBookToReader(Book book) {
        this.books.add(book);
        book.getReaders().add(this);
    }
}
