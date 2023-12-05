package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Book save(Book book) {
        entityManager.persist(book);
        return book;
    }

    public List<Book> list() {
        Query selectBFromBookB = entityManager.createQuery("select b from Book b");
        return selectBFromBookB.getResultList();
    }

    public List<Book> listByRating(int rating) {
        return  entityManager.createQuery("select b from Book b where b.rating=:rat").
                setParameter("rat", rating).
                getResultList();
    }
}
