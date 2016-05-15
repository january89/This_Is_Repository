package server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.Charset;

public class EchoServerV2Handler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        ByteBuf readMessage = (ByteBuf) msg;
        System.out.println("channelRead : " + readMessage.toString(Charset.defaultCharset()));
        ctx.write(msg);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        System.out.println("channelReadComplete 발생");
        ctx.flush();
    }
}
