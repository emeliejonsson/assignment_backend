import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class Queries {
    public static void runQueries(EntityManager em) {

        //1. Get all books written by a specific author
        List<Object[]> authorAndBooks = em.createQuery("select a, book from Author as a join a.listOfBooks as book where a.name = 'Haruki Murakami'").getResultList();
        System.out.println("1. Get all books written by a specific author:");
        int authorCount = 0;
        for (Object[] obj : authorAndBooks) {
            authorCount++;
            if (authorCount == 1) {
                System.out.println("Author: " + obj[0]);
                System.out.println("Title: " + obj[1]);
            } else {
                System.out.println("Title: " + obj[1]);
            }
        }
        System.out.println("\n");

        //2. Get all readers who have read a specific book
        Book specificBook = em.find(Book.class, 1);
        Query getAllReaders = em.createQuery("from Reader as r where :book member of r.books");
        getAllReaders.setParameter("book", specificBook);
        List<Reader> listOfReaders = getAllReaders.getResultList();

        System.out.println("2. Get all readers who have read a specific book: ");
        System.out.println("Book: " + specificBook.getTitle());
        for (Reader reader : listOfReaders) {
            System.out.println("Reader: " + reader.getName());
        }
        System.out.println("\n");

        //3. Get authors with books read by one or more readers
        List<Author> authorsWithReaders = em.createQuery("from Author as a join a.listOfBooks as authorsBook join authorsBook.readers", Author.class).getResultList();
        System.out.println("3. Get authors with books read by one or more readers:");
        for (Author author : authorsWithReaders) {
            System.out.println("Author: " + author);
        }
        System.out.println("\n");

        //4. Count number of books by each writer
        List<Object[]> booksByAuthor = em.createQuery("select a.name, count(bookList) from Author as a left join a.listOfBooks as bookList group by a.name", Object[].class).getResultList();
        System.out.println("4. Count number of books by each writer:");
        for (Object[] obj : booksByAuthor) {
            System.out.println("Author: " + obj[0] + ". Number of books: " + obj[1]);
        }
        System.out.println("\n");

        //5. Fetch books sorted by genre
        List<Book> booksByGenre = em.createNamedQuery("searchByName", Book.class).setParameter("genre", "Political satire").getResultList();
        System.out.println("5. Named query, fetch books sorted by genre:");
        int genreCount = 0;
        for (Book book : booksByGenre) {
            genreCount++;
            if (genreCount == 1) {
                System.out.println("Genre: " + book.getGenre() + "\n" + "Title: " + book);
            } else {
                System.out.println("Title: " + book);
            }

        }
    }
}
