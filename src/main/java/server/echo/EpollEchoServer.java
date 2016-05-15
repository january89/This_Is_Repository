package server.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import server.handler.EchoServerHandler;

/**
 * Created by Park Tae Hwan on 2016-05-09.
 * Epoll은 리눅스에서만 작동!
 */
public class EpollEchoServer{
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new EpollEventLoopGroup(1);
        EventLoopGroup workerGroup = new EpollEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(EpollServerSocketChannel.class)
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