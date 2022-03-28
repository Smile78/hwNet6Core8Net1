package netology.Client;

import java.io.*;
import java.net.Socket;

public class JrClient {

    public static void main(String[] args) throws IOException {

        try (
                Socket clientSocket = new Socket("netology.homework", 80);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Наберите connection или любой текст )");

            while (true) {
                String mssg = reader.readLine();
                out.write(mssg + "\n");
                out.flush();

                if (mssg.equals(("EXIT").toLowerCase())) break;
                String serverWord = in.readLine();
                System.out.println(serverWord);
            }
        } catch (IOException ex) {
            System.out.println("sout " + ex);
        }

    }
}