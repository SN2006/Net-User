package com.example.client.network;

import com.example.client.network.coders.RequestEncoder;
import com.example.client.network.coders.ResponseDecoder;
import com.example.client.network.handlers.ClientHandler;
import com.example.server.data.UserData;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NetClient {

    private final String host;
    private final int port;

    public NetClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect(UserData data) throws Exception{
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);

            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);

            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel){
                    channel.pipeline().addLast(
                            new RequestEncoder(),
                            new ResponseDecoder(),
                            new ClientHandler(data)
                    );
                }
            });

            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
        }
    }
}
