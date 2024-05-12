package com.example.client.network.handlers;

import com.example.client.view.ClientView;
import com.example.server.data.UserData;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    UserData userData;
    ChannelFuture future;

    public ClientHandler(UserData userData) {
        this.userData = userData;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        future = ctx.writeAndFlush(userData);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        new ClientView().getOutput(msg.toString());
        ctx.close();
    }
}
