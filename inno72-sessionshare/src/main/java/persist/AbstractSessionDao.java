package persist;

import session.ShareHttpSession;

import javax.servlet.http.*;
import java.util.List;

public abstract class AbstractSessionDao implements SessionDao {
	
	List<HttpSessionAttributeListener> attributeListener;

    List<HttpSessionListener> listener;

	@Override
	public void setAttributeListener(List<HttpSessionAttributeListener> listener) {
		this.attributeListener = listener;
	}

	@Override
	public void setListener(List<HttpSessionListener> listener) {
		this.listener = listener;
	}

	@Override
	public void notifySessionCreate(ShareHttpSession session) {
		if (listener != null) {
            for (HttpSessionListener httpSessionListener : listener) {
                httpSessionListener.sessionCreated(new HttpSessionEvent(session));
            }
        }
	}

	@Override
	public void notifySessionDestroy(ShareHttpSession session) {
		if (listener != null) {
            for (HttpSessionListener httpSessionListener : listener) {
                httpSessionListener.sessionDestroyed(new HttpSessionEvent(session));
            }
        }
	}

	@Override
	public void notifyAttributeAdded(ShareHttpSession session, String name, Object value) {
		if (attributeListener != null) {
            for (HttpSessionAttributeListener attrListener : attributeListener) {
                attrListener.attributeAdded(new HttpSessionBindingEvent(session, name, value));
            }
        }
        if (value instanceof HttpSessionBindingListener) {
            ((HttpSessionBindingListener) value).valueBound(new HttpSessionBindingEvent(session, name, value));
        }
	}

	@Override
	public void notifyAttributeRemoved(ShareHttpSession session, String name, Object value) {
		if (attributeListener != null) {
            for (HttpSessionAttributeListener attrListener : attributeListener) {
                attrListener.attributeRemoved(new HttpSessionBindingEvent(session, name, value));
            }
        }
        if (value instanceof HttpSessionBindingListener) {
            ((HttpSessionBindingListener) value).valueUnbound(new HttpSessionBindingEvent(session, name, value));
        }
	}

	@Override
	public void notifyAttributeReplaced(ShareHttpSession session, String name, Object value) {
		if (attributeListener != null) {
            for (HttpSessionAttributeListener attrListener : attributeListener) {
                attrListener.attributeReplaced(new HttpSessionBindingEvent(session, name, value));
            }
        }
	}

	@Override
	public void destroy() {
		attributeListener = null;
        listener = null;
	}

}
