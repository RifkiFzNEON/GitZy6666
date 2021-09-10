/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.nn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KNN {
    
    public static ArrayList<String> bacateks(String bacateks) throws FileNotFoundException, IOException{
        File bacafile = new File(bacateks);
        FileReader inputData = new FileReader(bacafile);
        BufferedReader bufferBaca = new BufferedReader(inputData);
        StringBuffer konten = new StringBuffer();
        String barisData;
        ArrayList<String> data = new ArrayList<String>();
        while ((barisData = bufferBaca.readLine()) != null) {
            konten.append(barisData);
            konten.append(System.getProperty("line.separator"));
            data.add(barisData);
        }
        return data;
    }
 
    public static ArrayList<String> tiket(String kalimat) throws FileNotFoundException, IOException {
        ArrayList<String> listData = new ArrayList<String>();
        StringTokenizer tiket = new StringTokenizer(kalimat, ",");
        while (tiket.hasMoreTokens()) {
            listData.add(tiket.nextToken());
        }
        return listData;
    }
 
    public static String[][] simpanArray(ArrayList<String> input) throws FileNotFoundException, IOException{
        String[][] data=new String[input.size()][10];
        for (int i = 0; i < input.size(); i++) {
             ArrayList<String> item=tiket(input.get(i));
             for (int j = 0; j < item.size(); j++) {
                data[i][j]=item.get(j);
            }
        }
        return data;
    }
    
    public static void main(String[] args)throws FileNotFoundException, IOException {
        ArrayList<String> DataTest=bacateks("data/DataTest_Tugas3_AI.csv");
        ArrayList<String> DataTrain=bacateks("data/DataTrain_Tugas3_AI.csv");
        FileWriter writer = new FileWriter("hasil_eksekusi/TebakanTugas3.csv");
        String[][] array=simpanArray(DataTest);
        String[][] array1=simpanArray(DataTrain);
        double[][] array2= new double[201][201];
        String[][] array3 = new String[201][201];
        ArrayList<Double> arraylist = new ArrayList<Double>();
        
        for (int j = 1; j <=200; j++) {
            double Testx1 = Double.parseDouble(array[j][1]);
            double Testx2 = Double.parseDouble(array[j][2]);
            double Testx3 = Double.parseDouble(array[j][3]);
            double Testx4 = Double.parseDouble(array[j][4]);
            double Testx5 = Double.parseDouble(array[j][5]);
            
            int mk = 0;
            int k = 0;
            int q1=0,q2=0,q3=0,q4=0;
            
            for (int i = 1; i <=800; i++) {
                double p1,p2,p3,p4,p5 = 0;
                double Trainx1 = Double.parseDouble(array1[i][1]);
                double Trainx2 = Double.parseDouble(array1[i][2]);
                double Trainx3 = Double.parseDouble(array1[i][3]);
                double Trainx4 = Double.parseDouble(array1[i][4]);
                double Trainx5 = Double.parseDouble(array1[i][5]);
                double TrainY =  Double.parseDouble(array1[i][6]);
            
                p1 = Math.pow(((Testx1)-(Trainx1)),2);
                p2 = Math.pow(((Testx2)-(Trainx2)),2);
                p3 = Math.pow(((Testx3)-(Trainx3)),2);
                p4 = Math.pow(((Testx4)-(Trainx4)),2);
                p5 = Math.pow(((Testx5)-(Trainx5)),2);
                
                double hasil = (p1+p2+p3+p4+p5);
                array2[j][0] = hasil;
                array2[j][1] = TrainY;                    
            }
            
            for (k=0; k<=7; k++){
                if (array2[k][1] == 0){
                    q1 = q1 + 1;
                }
                else if (array2[k][1] == 1){
                    q2 = q2 + 1;
                }
                else if (array2[k][1] == 2){
                    q3 = q3 + 1;
                }
                else if (array2[k][1] == 3){
                    q4 = q4 + 1;
                }      
            }
                    
            int a,b,c;
            a = Math.max(q1,q2);
            b = Math.max(q3,q4);
            c = Math.max(a,b);
                                 
            if (c==q1){
                mk=0;
            }
            else if (c==q2){
                mk=1;
            }
            else if (c==q3){
                mk=2;
            }
            else if (c==q4) {
                    mk=3;
            }

            if (mk==0) {
                array3[j][1] = "0";
            }
            else if (mk==1) {
                array3[j][1] = "1";
            }
            else if (mk==2) {
                array3[j][1] = "2";
            }
            else if (mk==3) {
                    array3[j][1] = "3";
            }
            
            System.out.println("--Data Tebakan--");
            System.out.println("Data Y -> "+array3[j][1]);
            writer.append(array3[j][1]);
            writer.append('\n');
            
        }
writer.flush();
writer.close();
    }
}    
                
                