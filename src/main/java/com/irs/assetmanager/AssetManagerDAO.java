package com.irs.assetmanager;

import java.util.List;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Kenneth.Maposa
 */
public interface AssetManagerDAO {
    public int saveAssetManager(AssetManager assetManager) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException;    
    public AssetManager getAssetManager(Integer i);
    public void editAssetManager(AssetManager assetManager);
    public List<AssetManager> getAssetManagers();
    public boolean deleteAssetManager(Integer id);
}
