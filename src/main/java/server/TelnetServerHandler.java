package server;

import io.netty.channel.*;

import java.net.InetAddress;
import java.util.Date;

import static io.netty.channel.ChannelHandler.*;

@Sharable
public class TelnetServerHandler extends SimpleChannelInboundHandler<String>{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        ctx.write("환영합니다. " + InetAddress.getLocalHost() + "에 접속하셨습니다!\r\n");
        ctx.write("현재 시간은 " + new Date() + " 입니다.\r\n");
        ctx.flush();
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, String request) throws Exception{
        String response;
        boolean close = false;

        if(request.isEmpty()){
            response = "명령을 입력해 주세요.\r\n";
        }
        else if ("bye".equals(request.toLowerCase())){
            response = "좋은 하루 되세요!\r\n";
            close = true;
        }
        else {
            response = "입력하신 명령이 '" + request + "' 입니까?\r\n";
        }
        ChannelFuture future = ctx.write(response);

        if (close){
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
