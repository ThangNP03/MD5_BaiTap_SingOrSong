package ra.model.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ra.model.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
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
        String queryStr = "SELECT s FROM Song AS s WHERE s.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void save(Song song) throws SystemException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = (Transaction) session.beginTransaction();
            if (findById(song.getId()) == null) {
                Song song1 = findById(song.getId());
                song1.setSongName(song.getSongName());
                song1.setArtistName(song.getArtistName());
                song1.setKindOfMusic(song.getKindOfMusic());
                song1.setUrlSong(song.getUrlSong());
            }
            session.saveOrUpdate(song);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session !=null){
                session.close();
            }
        }
    }

}
