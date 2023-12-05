package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);

    }

    public List<Person> findAll() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }
}
