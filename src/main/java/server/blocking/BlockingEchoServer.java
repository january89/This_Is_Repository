package server.blocking;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.sctp.oio.OioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import server.echo.EchoServerHandler;

public class BlockingEchoServer{

    public static void main(String[] args) throws Exception{

        EventLoopGroup bossGroup = new OioEventLoopGroup(1);
        EventLoopGroup workerGroup = new OioEventLoopGroup();

        try{

            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(OioSctpServerChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        public void initChannel(SocketChannel ch){
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new EchoServerHandler());
                        }
                    });

        }

        finally {

            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();

        }

    }

}
