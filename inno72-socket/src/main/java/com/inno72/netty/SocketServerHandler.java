package com.inno72.netty;

import java.util.TimerTask;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

@Sharable
public abstract class SocketServerHandler extends SimpleChannelInboundHandler<String> {

	private Logger logger = LoggerFactory.getLogger(SocketServerHandler.class);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String data) throws Exception {
		String id = ctx.channel().attr(attrKey()).get();
		logger.info("连接ID【{}】接收到【{}】发送的数据【{}】", id, ctx.channel().remoteAddress(), data);
		String result = process(data, id);
		logger.info("业务处理socket数据结果: {}", result);
		result = result == null || "".equals(result) ? "" : result;
		ByteBuf buf = ctx.alloc().directBuffer(result.length() * 2);
		buf.writeBytes(result.getBytes());
		ctx.writeAndFlush(buf);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("【{}】连接到服务器", ctx.channel().remoteAddress());
		String id = UUID.randomUUID().toString();
		ctx.channel().attr(attrKey()).set(id);
		logger.info("连接ID ：{}", id);
		NioSocketChannel channel = (NioSocketChannel) ctx.channel();
		SocketHolder.bind(id, channel);
		ctx.writeAndFlush(ctx.alloc().directBuffer().writeByte(1));
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		String key = ctx.channel().attr(attrKey()).get();
		logger.info("{}断开连接", key);
		ctx.channel().close();
		SocketHolder.remove(key);
		if (isExceptionClose(key)) {
			logger.info("{}异常断开，{}秒后重新检查", key, exceptionCloseWaitTimeSeconds());
			new java.util.Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					if (!exist(key)) {
						logger.info("{}未重新连接到服务器", key);
						closeNotify(key, true);
					}
				}
			}, exceptionCloseWaitTimeSeconds() * 1000);
		} else {
			closeNotify(key, false);
		}
		super.channelInactive(ctx);
	}

	private AttributeKey<String> attrKey() {
		return AttributeKey.valueOf("key");
	}

	/**
	 * 数据处理
	 * 
	 * @param data
	 * @return
	 * @author Houkm 2017年9月1日
	 */
	public abstract String process(String data, String key);

	/**
	 * 是否异常断开
	 * 
	 * @param key
	 * @return
	 * @author Houkm 2017年9月1日
	 */
	public abstract boolean isExceptionClose(String key);

	/**
	 * 异常断开时等待x秒后通知
	 * 
	 * @return
	 * @author Houkm 2017年9月1日
	 */
	public abstract int exceptionCloseWaitTimeSeconds();

	/**
	 * 异常断开时通知
	 * 
	 * @param key
	 * @author Houkm 2017年9月1日
	 */
	public abstract void closeNotify(String key, boolean exception);

	/**
	 * 应用中是否有此连接的绑定关系
	 * 
	 * @param key
	 * @author Houkm 2017年9月4日
	 */
	public abstract boolean exist(String key);

}
