import java.io.*;
import java.util.Scanner;

public class PowerShellRunner {
            public static void main(String[] args) throws IOException {

                //String command = "powershell.exe  your command";

                //called the PowerShell from java code
                String command = "powershell.exe   Get-WinEvent -Path C:\\windows\\System32\\winevt\\Logs\\System.evtx | Export-Csv system.csv";
                String command2 = "powershell.exe   Get-WinEvent -Path C:\\windows\\System32\\winevt\\Logs\\Security.evtx | Export-Csv security.csv";


                //delete older file
                File setUp = new File("security.csv");
                File seys = new File("system.csv");
                setUp.delete();
                seys.delete();

                // Executing the command
                Process powerShellProcess = Runtime.getRuntime().exec(command);
                Process powerShellProcess2 = Runtime.getRuntime().exec(command2);

                // Getting the results
                powerShellProcess.getOutputStream().close();
                powerShellProcess2.getOutputStream().close();

//              File sc = new File("/system.csv");
                int i = 1;
                BufferedReader objReader = null;
//                PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
                String strCurrentLine="";

                try{
                    objReader = new BufferedReader(new FileReader("/system.csv"));

                    while ((strCurrentLine = objReader.readLine())!=null){
                        String[] row = strCurrentLine.split(",");

                        for (String index : row){
                            System.out.printf("%-10s",index);
//                           writer.write(index);
//                           writer.close();
                        }
                        System.out.println();
                        i++;
                    }
                }catch (Exception e){
                        e.printStackTrace();
                }
                finally {
                    objReader.close();
                }

            }
        }
