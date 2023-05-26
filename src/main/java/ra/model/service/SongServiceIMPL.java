package ra.model.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ra.model.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SongServiceIMPL implements ISongService{
    private static SessionFactory sessionFactory;
    protected static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> findAll() {
        String querystr= "select s from Song as s";
        TypedQuery<Song> query =entityManager.createQuery(querystr,Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void save(Song song) {

    }
}
