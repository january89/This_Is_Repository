package server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){

        String readMessage = ((ByteBuf)msg).toString(Charset.defaultCharset());
        System.out.println("수신한문자열 [ " + readMessage + ']');
        ctx.write(msg);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){ ctx.flush(); }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){ cause.printStackTrace(); ctx.close(); }

}
