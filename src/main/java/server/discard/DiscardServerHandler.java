package server.discard;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Park Tae Hwan on 2016-04-29.
 */
public class DiscardServerHandler extends SimpleChannelInboundHandler<Object>{

    @Override
    public void messageReceived(ChannelHandlerContext ctx,Object msg) throws  Exception{}

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
