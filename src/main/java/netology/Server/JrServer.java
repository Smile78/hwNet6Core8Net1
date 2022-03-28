package netology.Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JrServer {
    public static void main(String[] args) {

        try (ServerSocket server2 = new ServerSocket(80);
             Socket clientSocket2 = server2.accept();
             BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
             BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(clientSocket2.getOutputStream()));
        ) {

            int start = 0;
            String srvrMssg = "";
            String name = "";
            System.out.println("Сервер запущен2!");

            while (true) {
                String clientMssg = in2.readLine();
                if (clientMssg.equals(("EXIT").toLowerCase())) break;

                if (start == 0) {
                    srvrMssg = "thanks for connection. Please Write your name";
                    start++;
                } else if (start == 1) {
                    name = clientMssg;
                    srvrMssg = name + ", Are you child? (yes/no)";
                    start++;
                } else if (start == 2) {
                    if (clientMssg.contains("yes"))
                        srvrMssg = "Welcome to the kids area, " + name + "! Let's play! ...you may type sms...";
                    else if (clientMssg.contains("no"))
                        srvrMssg = "Welcome to the adult zone, " + name + "! Have a good rest, or a good working day! ...you may type sms...";
                    else srvrMssg = "Are U God?";

                    start++;
                } else if (start == 3) {
                    srvrMssg = " неповерите... это mIRC2 .fremode . channel1.  вы в сети ! можете чатится!... ";
                } else {
                    srvrMssg = "это Сервер!  вы можете опять прислать текст";
                }

                out2.write(srvrMssg + "\n");
                out2.flush();
            }
        } catch (IOException ex) {
            System.out.println("sout " + ex);
        }
    }
}