package com.example.server.network.coders;

import com.example.server.data.UserData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RequestDecoder extends ReplayingDecoder<UserData> {

    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf,
                          List<Object> list){
        UserData data = new UserData();
        int nameLength = byteBuf.readInt();
        data.setName(byteBuf
                .readCharSequence(nameLength, charset).toString());
        int surnameLength = byteBuf.readInt();
        data.setSurname(byteBuf
                .readCharSequence(surnameLength, charset).toString());
        data.setAge(byteBuf.readInt());
        list.add(data);
    }
}
