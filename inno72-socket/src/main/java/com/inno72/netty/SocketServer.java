package com.inno72.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class SocketServer {

	private Logger logger = LoggerFactory.getLogger(SocketServer.class);

	private int port = 9901;

	private SocketServerInitializer socketServerInitializer;

	public SocketServer(int port, SocketServerInitializer socketServerInitializer) {
		this.port = port;
		this.socketServerInitializer = socketServerInitializer;
		this.start();
	}

	public void start() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				EventLoopGroup bossGroup = new NioEventLoopGroup();
				EventLoopGroup workerGroup = new NioEventLoopGroup();
				ServerBootstrap serverBootstrap = new ServerBootstrap();
				logger.info("准备启动Netty服务，端口{},业务实现Class{}", port, socketServerInitializer.handlerClassName());
				try {
					//@formatter:off
					serverBootstrap.group(bossGroup, workerGroup)
						.channel(NioServerSocketChannel.class)
						.option(ChannelOption.SO_BACKLOG, 1024)
						.childHandler(socketServerInitializer)
						.bind(port)
						.sync()
						.channel()
						.closeFuture()
						.sync();
					//@formatter:on
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					bossGroup.shutdownGracefully();
					workerGroup.shutdownGracefully();
				}
			}
		}).start();
	}
}
