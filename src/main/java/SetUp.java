import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SetUp {
    public static void setUpData(EntityManager em) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Author author1 = new Author("Astrid Lindgren", "Sweden");
        Author author2 = new Author("Haruki Murakami", "Japan");
        Author author3 = new Author("Chinua Achebe", "Nigeria");
        Author author4 = new Author("George Orwell", "England");
        Author author5 = new Author("Karl Ove Knausgård", "Norway");
            em.persist(author1);
            em.persist(author2);
            em.persist(author3);
            em.persist(author4);
            em.persist(author5);

        Book book1 = new Book("Mio, My Son", "Fantasy/Children's literature", "1954");
        Book book2 = new Book("Norwegian Wood", "Magical Realism", "1987");
        Book book3 = new Book("1Q84", "Magical Realism", "2009");
        Book book4 = new Book("Things Fall Apart", "Historical novel", "1958");
        Book book5 = new Book("A Man of the People", "Political satire", "1966");
        Book book6 = new Book("Animal Farm", "Political satire", "1945");
            em.persist(book1);
            em.persist(book2);
            em.persist(book3);
            em.persist(book4);
            em.persist(book5);
            em.persist(book6);

        author1.connectAuthorToBook(book1);
        author2.connectAuthorToBook(book2);
        author2.connectAuthorToBook(book3);
        author3.connectAuthorToBook(book4);
        author3.connectAuthorToBook(book5);
        author4.connectAuthorToBook(book6);

        Reader reader1 = new Reader("Simone Miro", "simone@email.com");
        Reader reader2 = new Reader("Lucie Wettre", "lucky@email.com");
        Reader reader3 = new Reader("Ernestine Bertrand", "ernie@email.com");
            em.persist(reader1);
            em.persist(reader2);
            em.persist(reader3);

        reader1.addBookToReader(book1);
        reader2.addBookToReader(book2);
        reader3.addBookToReader(book3);
        reader3.addBookToReader(book1);

        tx.commit();
    }

}
