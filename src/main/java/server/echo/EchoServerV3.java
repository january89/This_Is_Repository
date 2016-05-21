package server.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import server.handler.EchoServerHandler;
import server.handler.EchoServerV3FistHandler;
import server.handler.EchoServerV3SecondHandler;

/**
 * Created by Park Tae Hwan on 2016-05-11.
 */
public class EchoServerV3{
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup worketGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,worketGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch){
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new EchoServerV3FistHandler());
                            p.addLast(new EchoServerV3SecondHandler());
                        }
                    });
        }
        finally {
            worketGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
