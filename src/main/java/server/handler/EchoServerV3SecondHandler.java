package server.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoServerV3SecondHandler extends ChannelHandlerAdapter {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        System.out.println("channelReadComplete 발생");
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
