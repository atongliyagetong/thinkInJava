package chapter18_JavaIO.chapter18_9_ProcessController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 18.9 进程控制
 * 有问题
 */
public class OSExecute {
    public static void command(String command) {
        boolean error = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.out.println(s);
                error = true;
            }
        } catch (IOException e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C" + command);
            }else{
                throw new RuntimeException(e);
            }
        }
        if (error) {
            throw new OSExecuteException("Error Executing " + command);
        }
    }

}
