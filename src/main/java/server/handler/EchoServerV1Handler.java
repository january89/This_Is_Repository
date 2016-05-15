package server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.nio.charset.Charset;

public class EchoServerV1Handler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        ByteBuf readMessage = (ByteBuf) msg;
        System.out.println("channelRead : " + readMessage.toString(Charset.defaultCharset()));
        ctx.writeAndFlush(msg);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
