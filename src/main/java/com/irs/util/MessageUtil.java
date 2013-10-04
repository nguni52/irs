package com.irs.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;

/**
 *
 * @author nguni52
 */
public class MessageUtil {

    private static final Log log = LogFactory.getLog(MessageUtil.class.getName());
    
    public ModelMap checkMessage(String message, ModelMap model) {
        try {
            if (Constants.INVESTOR_ADDED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****investor added successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }
            else if (Constants.INVESTOR_EDITED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****investor edited successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }
            else if (Constants.INVESTOR_DELETED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****investor deleted successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }else if (Constants.USER_ADDED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****user added successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }  else if (Constants.USER_EDITED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****user edited successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            } else if (Constants.USER_DELETED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****user deleted successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            } else if (Constants.ASSETMANAGER_DELETED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****asset manager deleted successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            } else if (Constants.ASSETMANAGER_ADDED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****asset manager addded successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            } else if (Constants.ASSETMANAGER_EDITED.equalsIgnoreCase(message)) {
                log.info("\n\n\n****asset manager edited successfully\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }
            else if (Constants.ASSETMANAGER_DELETE_FAIL.equalsIgnoreCase(message)) {
                log.info("\n\n\n****asset manager could NOT be deleted\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }
            else if (Constants.INVESTOR_DELETE_FAIL.equalsIgnoreCase(message)) {
                log.info("\n\n\n****investor could NOT be deleted\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }
            else if (Constants.USER_DELETE_FAIL.equalsIgnoreCase(message)) {
                log.info("\n\n\n****user could not be deleted\n\n\n" + message + "\n\n\n*****\n\n\n");
                model.put("message", message);
            }
        } catch (NullPointerException npe) {
            log.debug("NPE in messageUtil", npe);
        }
        
        return model;
    }

    public ModelMap getFailedUserAdd(ModelMap model) {
        model.put("message", Constants.USER_CREATION_FAIL);
        return model;
    }
}