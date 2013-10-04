package com.irs.assetmanager;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Kenneth.Maposa
 */
public class AssetManagerServiceImpl implements AssetManagerService {
    private AssetManagerDAO assetManagerDAO;
    private PlatformTransactionManager transactionManager;
    
    @Autowired
    public void setAssetManagerDAO(AssetManagerDAO assetManagerDAO) {
        this.assetManagerDAO = assetManagerDAO;
    }
    
    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public int addAssetManager(AssetManager assetManager) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException {        
        return assetManagerDAO.saveAssetManager(assetManager);
    }

    @Override
    @Transactional
    public AssetManager getAssetManager(Integer id) {
        return assetManagerDAO.getAssetManager(id);
    }

    @Override
    @Transactional
    public void editAssetManager(AssetManager assetManager) {
        assetManagerDAO.editAssetManager(assetManager);
    }

    @Override
    @Transactional
    public List<AssetManager> getAssetManagers() {
        return assetManagerDAO.getAssetManagers();
    }

    @Override
    @Transactional
    public boolean deleteAssetManager(Integer id) {
        return assetManagerDAO.deleteAssetManager(id);
    }
}
