package main;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by emakarov on 28.01.2016.
 */



public class Main {
    public static void main(String[] args) {
        // put your code here
        //try {
        String temp;

        //FileReader fr = new FileReader("./test1.txt");
        //FileWriter wr = new FileWriter("./test2.txt");

        //BufferedWriter  bw = new BufferedWriter(wr);

        //BufferedReader br = new BufferedReader(fr);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Map<String, Integer> store = new HashMap<String, Integer>();
        //Map<Integer,String> keys = new HashMap<Integer,String>();
        ArrayList<String> myArrayList = new ArrayList<String>();
        //ArrayList<String> myArrayList_correlations = new ArrayList<String>();

        // Map<String, Integer> count = new HashMap<String, Integer>();
        //int key = 0;
            int array_i=0;
        try {
            while ((temp = br.readLine()) != null) {
                while (!temp.isEmpty()) {

                    int pos1 = temp.indexOf("\t");

                    if (pos1 > 0) {
                        temp = temp.substring(0,pos1);

                    }
                    if (myArrayList.isEmpty() || !myArrayList.contains(temp)){
                        myArrayList.add(temp);
                        myArrayList.add("1");
                        array_i = array_i+2;
                    } else {
                        if (myArrayList.contains(temp)) {
                            Integer count = Integer.parseInt(myArrayList.get(myArrayList.indexOf(temp) + 1));
                            count = count + 1;
                            myArrayList.set(myArrayList.indexOf(temp) + 1, count.toString());

                        }
                    }
                    temp="";
                }
            }
                for (int i =0;i<myArrayList.size();i=i+2){
                            int pos_name = myArrayList.get(i).indexOf("#");
                            String final_string = myArrayList.get(i).substring(0,pos_name) + "\t" +
                                    myArrayList.get(i).substring(pos_name+1,myArrayList.get(i).length())+ "\t" + myArrayList.get(i+1);
                            System.out.println(final_string);
                            bw.write(final_string);
                            bw.flush();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

    } /*catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
}

