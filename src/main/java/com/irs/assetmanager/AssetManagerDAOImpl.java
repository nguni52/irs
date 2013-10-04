package com.irs.assetmanager;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Kenneth.Maposa
 */
public class AssetManagerDAOImpl implements AssetManagerDAO {
    private SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(AssetManagerDAOImpl.class.getName());

    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public int saveAssetManager(AssetManager assetManager) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException{
        //sessionFactory.getCurrentSession().save(assetManager);
        Integer id = (Integer)sessionFactory.getCurrentSession().save(assetManager);
        return id.intValue();
    }

    @Override
    public AssetManager getAssetManager(Integer id) {
        AssetManager assetManager = (AssetManager) sessionFactory.getCurrentSession().get(AssetManager.class, id);
        return assetManager;
    }

    @Override
    public void editAssetManager(AssetManager assetManager) {
        sessionFactory.getCurrentSession().update(assetManager);
    }

    @Override
    public List<AssetManager> getAssetManagers() {
        //return sessionFactory.getCurrentSession().createQuery("from AssetManager").list();
        return sessionFactory.getCurrentSession().createCriteria(AssetManager.class).list();
    }

    @Override
    public boolean deleteAssetManager(Integer id) {
        try {
            AssetManager assetManager = (AssetManager) sessionFactory.getCurrentSession().load(AssetManager.class, id);
            try {
                sessionFactory.getCurrentSession().delete(assetManager);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } catch(NullPointerException npe) {
            log.info("delete asset manager threw exception");
            return false;
        }
    }
}
