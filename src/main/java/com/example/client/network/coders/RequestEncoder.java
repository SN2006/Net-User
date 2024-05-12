package com.example.client.network.coders;

import com.example.server.data.UserData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RequestEncoder extends MessageToByteEncoder<UserData> {

    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, UserData data,
                          ByteBuf byteBuf) {
        byteBuf.writeInt(data.getName().length());
        byteBuf.writeCharSequence(data.getName(), charset);
        byteBuf.writeInt(data.getSurname().length());
        byteBuf.writeCharSequence(data.getSurname(), charset);
        byteBuf.writeInt(data.getAge());
    }
}
