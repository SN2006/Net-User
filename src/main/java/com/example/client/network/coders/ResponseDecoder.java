package com.example.client.network.coders;

import com.example.server.data.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ResponseDecoder extends ReplayingDecoder<ResponseData> {

    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list){
        ResponseData data = new ResponseData();
        int msgLength = byteBuf.readInt();
        data.setMessage(byteBuf.readCharSequence(msgLength, charset).toString());
        list.add(data);
    }
}
