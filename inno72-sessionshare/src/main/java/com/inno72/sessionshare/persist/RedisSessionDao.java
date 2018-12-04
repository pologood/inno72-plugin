package com.inno72.sessionshare.persist;

import com.alibaba.fastjson.JSON;
import com.inno72.redis.IRedisUtil;
import com.inno72.sessionshare.session.ShareHttpSession;
import com.inno72.sessionshare.support.context.SessionContextInitializer;
import com.inno72.sessionshare.utils.SerializeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.*;

public class RedisSessionDao extends AbstractSessionDao{

    private static final Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);

	@Resource
	private IRedisUtil redisUtil;

    public int add(ShareHttpSession session) {
        try {
            String id ;
            if (session == null || (id = session.getId()) == null) {
                return 0;
            }
            String sessionKeyPrefix = String.format(SESSION_KEY_PREFIX, SessionContextInitializer.namespace);
			redisUtil.set(sessionKeyPrefix + id, JSON.toJSONString(session));
            String sessionGroupKey = String.format(SESSION_GROUP_KEY, SessionContextInitializer.namespace);
			redisUtil.zadd(sessionGroupKey, session.getLastAccessedTime(), id);
            notifySessionCreate(session);
            return 1;
        } catch (Exception e) {
            logger.error("add redis session", e);
            return 0;
        }
    }

    public ShareHttpSession get(String sessionId) {
        try {
            if (StringUtils.isBlank(sessionId)) {
                return null;
            }
            String key = String.format(SESSION_KEY_PREFIX, SessionContextInitializer.namespace);
            String string = redisUtil.get(key + sessionId);
            if (!StringUtils.isBlank(string)) {
                return JSON.parseObject(string, ShareHttpSession.class);
            }
        } catch (Exception e) {
            logger.error("get redis session", e);
        }
        return null;
    }

    public int update(ShareHttpSession session) {
        try {
            String id ;
            if (session == null || (id = session.getId()) == null) {
                return 0;
            }
            String systemSource = session.getNamespace();
            if(StringUtils.isBlank(systemSource)){
                systemSource = SessionContextInitializer.namespace;
            }
            String sessionKeyPrefix = String.format(SESSION_KEY_PREFIX,systemSource);
            redisUtil.set(sessionKeyPrefix + id, JSON.toJSONString(session));
            String sessionGroupKey = String.format(SESSION_GROUP_KEY, systemSource);
            redisUtil.zadd(sessionGroupKey, session.getLastAccessedTime(), id);
            return 1;
        } catch (Exception e) {
            logger.error("update redis session", e);
        }
        return 0;
    }

    public int delete(ShareHttpSession session) {
        try {
            String id ;
            if (session == null || (id = session.getId()) == null) {
                return 0;
            }
            String systemSource = session.getNamespace();
            if(StringUtils.isBlank(systemSource)){
                systemSource = SessionContextInitializer.namespace;
            }
            /*boolean ask = AskTodoInCluster.ask(HttpSessionDo.HTTP_SESSION_DESTROY, id);
            if (!ask) {
                logger.info("["+systemSource+"]session 销毁失败 ，ask return ：false.");
                return 0;
            }*/
            String attrKeyPrefix = String.format(ATTR_KEY_PREFIX, systemSource);
            String attrKey = attrKeyPrefix + id;
            redisUtil.del(attrKey);
            String sessionKeyPrefix = String.format(SESSION_KEY_PREFIX, systemSource);

            redisUtil.del(sessionKeyPrefix + id);
            String sessionGroupKey = String.format(SESSION_GROUP_KEY,systemSource);
            redisUtil.zrem(sessionGroupKey, id);
            notifySessionDestroy(session);
            logger.info("["+systemSource+"]session["+id+"] delete ok.");
            return 1;
        } catch (Exception e) {
            logger.error("delete redis session", e);
            return 0;
        }
    }

    public Object getAttribute(ShareHttpSession session, String name, String systemSource) {
        try {
            if (StringUtils.isBlank(name)) {
                return null;
            }
            String sessionId = session.getId();
            if(StringUtils.isBlank(systemSource)){
                systemSource = SessionContextInitializer.namespace;
            }
            String attrKeyPreFix = String.format(ATTR_KEY_PREFIX, systemSource);
            // 注意：处理时需要判断是不是String类型，如果是，需要反序列化再处理，不能强转
            String value ;
            if(!session.isValid(true)){
                // value = redisUtil.hgetByRename(attrKeyPreFix + sessionId, attrKeyPreFix + EXPIRE_KEY_PREFIX + sessionId, name);
                value = null;
            }else{
                value = (String)redisUtil.hget(attrKeyPreFix + sessionId, name);
            }
            return SerializeUtils.deserialize(value != null ? value.getBytes() : null);
        } catch (Exception e) {
            logger.error("get redis session Attribute 【" + name + "】", e);
            return null;
        }
    }

    public Enumeration<String> getAttributeNames(ShareHttpSession session, String systemSource) {
        try {
            String sessionId = session.getId();
            if(StringUtils.isBlank(systemSource)){
                systemSource = SessionContextInitializer.namespace;
            }
            String attrKeyPrefix = String.format(ATTR_KEY_PREFIX,systemSource);
            Set<String> hashKeys ;
            if(!session.isValid(true)){
                // hashKeys = redisUtil.hkeysByRename(attrKeyPrefix + sessionId, attrKeyPrefix + EXPIRE_KEY_PREFIX + sessionId);
                hashKeys = null;
            }else{
                hashKeys = redisUtil.hkeys(attrKeyPrefix + sessionId);
            }
            if(hashKeys == null){
                return null;
            }
            return Collections.enumeration(hashKeys);
        } catch (Exception e) {
            logger.error("get redis session Attribute names", e);
        }
        return null;
    }

    public void setAttribute(ShareHttpSession session, String name, Object value) {
        try {
            String id ;
            if (session == null || (id = session.getId()) == null) {
                return;
            }
            if (StringUtils.isBlank(name) || value == null) {
                return;
            }
            String systemSource = session.getNamespace();
            if(StringUtils.isBlank(systemSource)){
                systemSource = SessionContextInitializer.namespace;
            }
            String attrKeyPrefix = String.format(ATTR_KEY_PREFIX,systemSource);
            redisUtil.hset(attrKeyPrefix + id, name, new String(SerializeUtils.serialize(value)));
            notifyAttributeAdded(session, name, value);
        } catch (Exception e) {
            logger.error("set redis session Attribute 【" + name + "】=" + value, e);
        }
    }

    public void removeAttribute(ShareHttpSession session, String name) {
        try {
            String id ;
            if (session == null || (id = session.getId()) == null || StringUtils.isBlank(name)) {
                return;
            }
            Object attribute = getAttribute(session, name, session.getNamespace());

            if (attribute != null) {
                String systemSource = session.getNamespace();
                if(StringUtils.isBlank(systemSource)){
                    systemSource = SessionContextInitializer.namespace;
                }
                String attrKeyPrefix = String.format(ATTR_KEY_PREFIX,systemSource);
//                if(!session.isValid(true)){
//                    // redisUtil.hdelByRename(attrKeyPrefix + id, attrKeyPrefix + EXPIRE_KEY_PREFIX + id, new String[]{name});
//                }else{
//                    // redisUtil.hdel(attrKeyPrefix + id, new String[]{name});
//                }
				redisUtil.hdel(attrKeyPrefix + id, name);
                notifyAttributeRemoved(session, name, attribute);
            }
        } catch (Exception e) {
            logger.error("remove redis session Attribute", e);
        }
    }

    public Collection<ShareHttpSession> getSessions() {
        try {
            String sessionGroupKey=String.format(SESSION_GROUP_KEY, SessionContextInitializer.namespace);
			Set<Object> keys = redisUtil.zrange(sessionGroupKey, 0, -1);
			Collection<ShareHttpSession> res = new ArrayList<>();
            if (keys != null) {
                for (Object sid : keys) {
                    res.add(get((String) sid));
                }
            }
            return res;
        } catch (Exception e) {
            logger.error("getAll redis session", e);
            return null;
        }
    }

    public Collection<ShareHttpSession> getActiveSessions(int timeout) {
        try {
            if (timeout < 0) {
                return getSessions();
            }
            long startAt = System.currentTimeMillis() - (timeout * 1000);
            String sessionGroupKey = String.format(SESSION_GROUP_KEY, SessionContextInitializer.namespace);
			Set<Object> keys = redisUtil.zrangeByScore(sessionGroupKey, startAt, startAt << 1);
			Collection<ShareHttpSession> res = null;
            if (keys != null && !keys.isEmpty()) {
                res = new ArrayList<>();
                for (Object sid : keys) {
                    ShareHttpSession session = get((String)sid);
                    if (session != null) {
                        res.add(session);
                    }
                }
            }
            return res;
        } catch (Exception e) {
            logger.error("get Active sessions", e);
            return null;
        }
    }

    public Collection<ShareHttpSession> getExpireSessions(int timeout) {
        try {
            if (timeout < 0) {
                return null;
            }
            // TODO 这个timeout是所有session的统一过期时间，如果个别session单独设置过，maxInactiveInterval 应领当别论
            long expireAt = System.currentTimeMillis() - (timeout * 1000);
            String sessionGroupKey = String.format(SESSION_GROUP_KEY, SessionContextInitializer.namespace);
			Set<Object> keys = redisUtil.zrangeByScore(sessionGroupKey, 0, expireAt);
			logger.info("[" + SessionContextInitializer.namespace + "]从redis获取 " + timeout + "s 过期session 【" + (keys == null ? 0 : keys.size()) + "】个  : " + keys);
            Collection<ShareHttpSession> res = null;
            if (keys != null && !keys.isEmpty()) {
                res = new ArrayList<>();
                for (Object sid : keys) {
                    ShareHttpSession session = get((String) sid);
                    if (session != null) {
                        res.add(session);
                    }
                }
                logger.info("[" + SessionContextInitializer.namespace + "]本次 session 过期：" + res.size() + "个");
            }
            return res;
        } catch (Exception e) {
            logger.error("[" + SessionContextInitializer.namespace + "] get expire sessions", e);
            return null;
        }
    }

    public ShareHttpSession get(String systemSource, String sessionId) {
        try {
            if (StringUtils.isBlank(sessionId)) {
                return null;
            }
            if(StringUtils.isBlank(systemSource)){
                return get(sessionId);
            }
            String sessionKeyPrefix=String.format(SESSION_KEY_PREFIX,systemSource);
            String string = redisUtil.get(sessionKeyPrefix + sessionId);
            if (!StringUtils.isBlank(string)) {
                return JSON.parseObject(string, ShareHttpSession.class);
            }
        } catch (Exception e) {
            logger.error("get redis session", e);
        }
        return null;
    }
    
    public void destroy() {
        super.destroy();
		redisUtil = null;
    }
}
