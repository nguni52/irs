package com.irs.assetmanager;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Kenneth.Maposa
 */
public interface AssetManagerService {
    public int addAssetManager(AssetManager assetManager) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException;    
    public AssetManager getAssetManager(Integer id);
    public void editAssetManager(AssetManager assetManager);
    public List<AssetManager> getAssetManagers();
    public boolean deleteAssetManager(Integer id);
}
