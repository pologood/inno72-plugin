package utils;

import org.apache.commons.lang3.StringUtils;
import session.ShareHttpSession;
import support.context.SessionContextInitializer;

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

	public static void main(String[] args) {
		HttpSession session = SessionUtils.getSession("gxg123", true);
		session.setAttribute("gxg", "1");

	}
}
