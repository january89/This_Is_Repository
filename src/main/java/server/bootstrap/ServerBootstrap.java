package server.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.concurrent.EventExecutorGroup;

//public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap,ServerChannel>{
//    private ChannelHandler childHandler;
//
//    public ServerBootstrap group(EventLoopGroup group){
//        return group(group,group);
//    }
//
//    public ServerBootstrap group(EventLoopGroup parentGroup,EventLoopGroup childGroup){
//        super.group(parentGroup);
//        if(childGroup == null){
//            throw new NullPointerException("childGroup");
//        }
//        if(this.childGroup != null){
//            throw new IllegalStateException("childGroup set already");
//        }
//        this.childGroup = childGroup;
//        return this;
//    }
//    public ServerBootstrap childHandler(ChannelHandler childHandler){
//        if(childHandler == null){
//            throw new NullPointerException("childHandler");
//        }
//        this.childHandler = childHandler;
//        return this;
//    }
//
//}
