package com.inno72.sessionshare.persist;

import com.inno72.sessionshare.session.ShareHttpSession;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

public interface NotifiableSessionDao {

    void setAttributeListener(List<HttpSessionAttributeListener> listener);

    void setListener(List<HttpSessionListener> listener);
    
    void notifySessionCreate(ShareHttpSession session);
    
    void notifySessionDestroy(ShareHttpSession session);
    
    void notifyAttributeAdded(ShareHttpSession session, String name, Object value);

    void notifyAttributeRemoved(ShareHttpSession session, String name, Object value);

    void notifyAttributeReplaced(ShareHttpSession session, String name, Object value);
    
}
