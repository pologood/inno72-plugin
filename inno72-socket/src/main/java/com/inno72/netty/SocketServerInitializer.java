package com.inno72.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class SocketServerInitializer extends ChannelInitializer<SocketChannel> {

	public SocketServerInitializer(SocketServerHandler handler) {
		this.handler = handler;
	}

	private SocketServerHandler handler;

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		ChannelPipeline pipeline = channel.pipeline();
		// pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192,
		// Delimiters.lineDelimiter()));
		pipeline.addLast("decoder", new StringDecoder());
		pipeline.addLast("encoder", new StringEncoder());
		pipeline.addLast(handler);
	}

	String handlerClassName() {
		return handler.getClass().getName();
	}

}
