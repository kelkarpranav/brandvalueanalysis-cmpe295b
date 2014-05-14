package yelp;
import java.io.*;
public class YelpPython {
   
    public String pythonrun(String args) throws IOException, InterruptedException
    {
    	StringBuffer output1 = new StringBuffer();

    	Process p1 = Runtime.getRuntime().exec("python /root/workspace/bva/BVA/msp.py " + args);
    	/*String pythonScriptPath = "/BVA/msp.py";
        String[] cmd = new String[3];
        cmd[0] = "python";
        cmd[1] = pythonScriptPath;
        cmd[2] = args;
         
        // create runtime to execute external command
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(cmd);
        pr.waitFor();*/
         
        // retrieve output from python script
        BufferedReader bfr = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String line = "";
        while((line = bfr.readLine()) != null) {
        // display each output line form python script
        //System.out.println(line);
        		output1.append(line + "\n");
        	       }
		return output1.toString();
    }
   
    public static void main(String args[]) throws IOException, InterruptedException {
    // set up the command and parameter
    YelpPython demo = new YelpPython();
    demo.pythonrun("tandoori-oven-san-jose-2");
    System.out.println(demo.pythonrun("tandoori-oven-san-jose-2"));
    }
    }
