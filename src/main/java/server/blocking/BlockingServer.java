package server.blocking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

/**
 * Created by sdth on 2016-04-29.
 */
public class BlockingServer{
    public static void main(String[] args) throws IOException {

        BlockingServer server = new BlockingServer();
        server.run();

    }

    private void run() throws IOException{

        ServerSocket server = new ServerSocket(8888);
        out.println("접속 대기중");

        while (true){

            Socket sock = server.accept();
            out.println("클라이언트 연결됨");

            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

            while (true){

                try {

                    int request = in.read();
                    out.write(request);

                }
                catch (IOException e){

                    break;

                }
            }
        }
    }
}
