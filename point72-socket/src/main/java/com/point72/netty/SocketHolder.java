package com.point72.netty;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class SocketHolder {

	private static Logger logger = LoggerFactory.getLogger(SocketHolder.class);

	public static int count() {
		return map.size();
	}

	/**
	 * 关闭连接
	 * 
	 * @param key
	 * @author Houkm 2017年9月1日
	 */
	public static void close(String key) {
		logger.info("主动关闭连接 --> {}", key);
		NioSocketChannel channel = get(key);
		if (channel != null) {
			channel.close();
		}
		remove(key);
	}

	static void bind(String key, NioSocketChannel channel) {
		set(key, channel);
	}

	/**
	 * 发送data给key
	 * 
	 * @param key
	 * @param data
	 * @author Houkm 2017年9月1日
	 */
	public static void send(String key, String data) {
		logger.info("发送数据: {} --> {}", key, data);
		send(get(key), data);
	}

	static void send(Channel channel, String data) {
		channel.writeAndFlush(channel.alloc().directBuffer(data.length() * 4).writeBytes(data.getBytes()));
	}

	private static ConcurrentMap<String, NioSocketChannel> map = new ConcurrentHashMap<>();

	public static boolean exist(String key) {
		return map.containsKey(key);
	}

	static NioSocketChannel get(String key) {
		return map.get(key);
	}

	static void set(String key, NioSocketChannel channel) {
		map.put(key, channel);
	}

	static void remove(String key) {
		if (exist(key)) {
			map.remove(key);
		}
	}

}
