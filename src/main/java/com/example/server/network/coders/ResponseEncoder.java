package com.example.server.network.coders;

import com.example.server.data.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ResponseEncoder extends MessageToByteEncoder<ResponseData> {

    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          ResponseData responseData, ByteBuf byteBuf) {
        byteBuf.writeInt(responseData.getMessage().length());
        byteBuf.writeCharSequence(responseData.getMessage(), charset);
    }
}
