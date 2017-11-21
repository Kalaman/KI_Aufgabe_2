import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static javax.script.ScriptEngine.FILENAME;

/**
 * Created by Kalaman on 21.11.17.
 */
public class AppMain {

    private static String FILENAME = "P2A1Samples.txt";
    private static ArrayList<Node> nodeList;

    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fr = null;

        nodeList = new ArrayList<Node>();

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            sCurrentLine = br.readLine();

            String [] splitedNodes = sCurrentLine.split(",");

            for (String currentNodeStr : splitedNodes)
                nodeList.add(new Node(currentNodeStr.trim()));

            while ((sCurrentLine = br.readLine()) != null) {
                String [] splitedLine = sCurrentLine.split(",");

                for (int i=0;i< nodeList.size();++i)
                {
                    try {
                        nodeList.get(i).addValue(Integer.parseInt(splitedLine[i].trim()));
                    }catch (Exception e){}
                }
            }


            for (Node node: nodeList)
                System.out.println(node);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }
}
