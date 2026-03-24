import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String nationality;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    private List<Book> listOfBooks;

    public Author(){}

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
        this.listOfBooks = new ArrayList<Book>();
    }

    public void connectAuthorToBook(Book book) {
        this.listOfBooks.add(book);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    @Override
    public String toString() {
        return name;
    }
}
