package com.inno72.sessionshare.utils;

import com.inno72.sessionshare.session.ShareHttpSession;
import com.inno72.sessionshare.support.context.SessionContextInitializer;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;

public class SessionUtils {

    /**
     * 获取session
     * @param sessionId
     * @param create
     * 当为false时，有则返回具体session，没有则返回null，不创建。
     * 当为true时，有则返回具体session，没有则创建一个新的并返回
     * @return
     */
    public static HttpSession getSession(String sessionId, boolean create) {
        if (StringUtils.isBlank(sessionId)&&!create) return null;
        ShareHttpSession httpSession = SessionContextInitializer.getSessionManager().findSession(sessionId);
        if (httpSession == null) {
            httpSession = SessionContextInitializer.getSessionManager().findRemoteSession(sessionId);
        }
        if(httpSession == null && create){
            httpSession = SessionContextInitializer.getSessionManager().createSession(sessionId);
        }
        return httpSession;
    }

    /**
     * 获取指定namespace下的session（有则返回具体session，没有则返回null，不创建）
     * @param sessionId
     * @param namespace 不传则获取当前系统的
     * @return
     */
    public static HttpSession getSession(String sessionId, String namespace){
        if (StringUtils.isBlank(sessionId)) return null;
        if(StringUtils.isBlank(namespace)){
            return getSession(sessionId,false);
        }
        return SessionContextInitializer.getSessionManager().findRemoteSession(namespace,sessionId);
    }

	public static void removeSession(String sessionId){
		if (StringUtils.isBlank(sessionId)) return ;
		ShareHttpSession session = (ShareHttpSession)getSession(sessionId,false);
		if(session != null){
			SessionContextInitializer.getSessionManager().removeSession(session);
		}
	}

}
