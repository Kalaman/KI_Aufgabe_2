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

            for (String currentNodeStr : splitedNodes) {
                currentNodeStr = currentNodeStr.trim();
                if (currentNodeStr.equalsIgnoreCase("g"))
                {
                    nodeList.add(new AlphabeticNode(currentNodeStr.trim()));
                }
                else
                {
                    nodeList.add(new Node(currentNodeStr.trim()));
                }
            }

            while ((sCurrentLine = br.readLine()) != null) {
                String [] splitedLine = sCurrentLine.split(",");

                for (int i=0;i< nodeList.size();++i)
                {
                    try {
                        if (nodeList.get(i) instanceof AlphabeticNode)
                        {
                            switch (splitedLine[i].trim().toUpperCase())
                            {
                                case "A":
                                    nodeList.get(i).addValue(AlphabeticNode.VALUE_A);
                                    break;
                                case "B":
                                    nodeList.get(i).addValue(AlphabeticNode.VALUE_B);
                                    break;
                                case "C":
                                    nodeList.get(i).addValue(AlphabeticNode.VALUE_C);
                                    break;
                            }
                        }
                        else
                        {
                            nodeList.get(i).addValue(Integer.parseInt(splitedLine[i].trim()));
                        }
                    }catch (Exception e){ e.printStackTrace();}
                }
            }

            int sumData = 10000;

            for (Node node: nodeList)
            {
                if (node instanceof AlphabeticNode)
                {
                    float probA = ((float)((AlphabeticNode)node).getValue(AlphabeticNode.VALUE_A) / (float)sumData) * 100;
                    float probB = ((float)((AlphabeticNode)node).getValue(AlphabeticNode.VALUE_B) / (float)sumData) * 100;
                    float probC = ((float)((AlphabeticNode)node).getValue(AlphabeticNode.VALUE_C) / (float)sumData) * 100;

                    System.out.println(node + " Prob: A=" + probA + "% B=" + probB + "% C=" + probC + "%");
                }
                else {
                    float prob = ((float)node.getValue() / (float)sumData) * 100;
                    System.out.println(node + " Prob: " + prob + " %");
                }

            }


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
