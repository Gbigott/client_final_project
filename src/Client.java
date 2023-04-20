//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.net.ServerSocket;
import java.util.Scanner;
import java.net.Socket;
import java.io.*;
import java.util.*;
public class Client {
    public static void main(String[] args) throws Exception {

        String command ;
        String modifiedCommand;
        String intro;
        String title;
        String options;
        boolean finish = true;
        Scanner input = new Scanner(System.in);
        try {
        Socket socket = new Socket("localhost",5616);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream toServer =  new DataOutputStream(socket.getOutputStream());
        BufferedReader inputFromS = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        intro = inputFromS.readLine();
        title = inputFromS.readLine();
        options = inputFromS.readLine();
        System.out.println(intro);
        System.out.println(title);
        System.out.println(options);

       String enter;
       String num1;
       String num2;
           //enter = "Hello!";
            // toServer.writeBytes(enter+"\n");


            while (!socket.isClosed()) {

                command =  input.nextLine();
                num1 = input.nextLine();
                num2 = input.nextLine();

                toServer.writeBytes(command+'\n');
                toServer.writeBytes(num1+'\n');
                toServer.writeBytes(num2+'\n');
                System.out.println(inputFromS.readLine());



                  //toServer.writeBytes(num1+'\n');
//                toServer.writeBytes(convertNum2+'\n');


                //toServer.flush();

            }


        }
        catch (Exception e)
        {
            System.out.println("Disconnect from server");
        }











    }




}
