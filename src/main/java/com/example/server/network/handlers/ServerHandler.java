package com.example.server.network.handlers;

import com.example.server.data.ResponseData;
import com.example.server.data.UserData;
import com.example.utils.Constants;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        UserData userData = (UserData) msg;
        ResponseData responseData = new ResponseData();

        responseData.setMessage(handleUserData(userData));
        ChannelFuture future = ctx.writeAndFlush(responseData);
        future.addListener(ChannelFutureListener.CLOSE);
        System.out.println(userData);
    }

    private String handleUserData(UserData userData) {
        if (userData == null){
            return Constants.USERDATA_EQUALS_NULL_MSG;
        }
        StringBuilder builder = new StringBuilder();

        if (userData.getName() == null || userData.getName().isEmpty()){
            builder.append(Constants.USER_NAME_IS_EMPTY_MSG).append("\n");
        }

        if (userData.getSurname() == null || userData.getSurname().isEmpty()){
            builder.append(Constants.USER_SURNAME_IS_EMPTY_MSG).append("\n");
        }

        if (userData.getAge() <= 0){
            builder.append(Constants.USER_INVALID_AGE_MSG).append("\n");
        }

        return builder.isEmpty() ? String.format("Hello, %s %s. Your age is %d years old.",
                userData.getSurname(), userData.getName(), userData.getAge()) : builder
                .toString();
    }
}
