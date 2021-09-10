/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.means;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KMeans {
    
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
        ArrayList<String> DataSet=bacateks("data/Tugas 2 ML Genap 2018-2019 Dataset Tanpa Label.csv");
        FileWriter writer = new FileWriter("hasil_eksekusi/HasilTugas2ML.csv");
        String[][] array =simpanArray(DataSet);
        double[][] c1 = new double[600][600];
        double[][] c2 = new double[600][600];
        String[][] hasil = new String [600][600];
        ArrayList<Double> arraylist = new ArrayList<Double>();
        
        double x1 = Double.parseDouble(array[1][1]);
        double x2 = Double.parseDouble(array[2][1]);
        double x3 = Double.parseDouble(array[3][1]);
        double x4 = Double.parseDouble(array[4][1]);
        double x5 = Double.parseDouble(array[5][1]);
        double x6 = Double.parseDouble(array[6][1]);
        double x7 = Double.parseDouble(array[7][1]);
        double x8 = Double.parseDouble(array[8][1]);
        double x9 = Double.parseDouble(array[9][1]);
        double x10 = Double.parseDouble(array[10][1]);
            
        double y1 = Double.parseDouble(array[1][2]);
        double y2 = Double.parseDouble(array[2][2]);
        double y3 = Double.parseDouble(array[3][2]);
        double y4 = Double.parseDouble(array[4][2]);
        double y5 = Double.parseDouble(array[5][2]);
        double y6 = Double.parseDouble(array[6][2]);
        double y7 = Double.parseDouble(array[7][2]);
        double y8 = Double.parseDouble(array[8][2]);
        double y9 = Double.parseDouble(array[9][2]);
        double y10 = Double.parseDouble(array[10][2]);
        
        
            for (int i = 1; i <=8; i++) {
                for (int j = 1; j <=600; j++){

                    double R1 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x1),2)+Math.pow((Double.parseDouble(array[j][2])-y1),2));
                    double R2 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x2),2)+Math.pow((Double.parseDouble(array[j][2])-y2),2));
                    double R3 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x3),2)+Math.pow((Double.parseDouble(array[j][2])-y3),2));
                    double R4 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x4),2)+Math.pow((Double.parseDouble(array[j][2])-y4),2));
                    double R5 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x5),2)+Math.pow((Double.parseDouble(array[j][2])-y5),2));
                    double R6 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x6),2)+Math.pow((Double.parseDouble(array[j][2])-y6),2));
                    double R7 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x7),2)+Math.pow((Double.parseDouble(array[j][2])-y7),2));
                    double R8 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x8),2)+Math.pow((Double.parseDouble(array[j][2])-y8),2));
                    double R9 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x9),2)+Math.pow((Double.parseDouble(array[j][2])-y9),2));
                    double R10 = Math.sqrt(Math.pow((Double.parseDouble(array[j][1])-x10),2)+Math.pow((Double.parseDouble(array[j][2])-y10),2));
            
                    if ((R1<R2)&&(R1<R3)&&(R1<R4)&&(R1<R5)&&(R1<R6)&&(R1<R7)&&(R1<R8)&&(R1<R9)&&(R1<R10)){
                        hasil[j][1] = "1";
                    }else if ((R2<R1)&&(R2<R3)&&(R2<R4)&&(R2<R5)&&(R2<R6)&&(R2<R7)&&(R2<R8)&&(R2<R9)&&(R2<R10)){
                        hasil[j][1] = "2";
                    }else if ((R3<R1)&&(R3<R2)&&(R3<R4)&&(R3<R5)&&(R3<R6)&&(R3<R7)&&(R3<R8)&&(R3<R9)&&(R3<R10)){
                        hasil[j][1] = "3";
                    }else if ((R4<R1)&&(R4<R2)&&(R4<R3)&&(R4<R5)&&(R4<R6)&&(R4<R7)&&(R4<R8)&&(R4<R9)&&(R4<R10)){
                        hasil[j][1] = "4";
                    }else if ((R5<R1)&&(R5<R2)&&(R5<R3)&&(R5<R4)&&(R5<R6)&&(R5<R7)&&(R5<R8)&&(R5<R9)&&(R5<R10)){
                        hasil[j][1] = "5";
                    }else if ((R6<R1)&&(R6<R2)&&(R6<R3)&&(R6<R4)&&(R6<R5)&&(R6<R7)&&(R6<R8)&&(R6<R9)&&(R6<R10)){
                        hasil[j][1] = "6";   
                    }else if ((R7<R1)&&(R7<R2)&&(R7<R3)&&(R7<R4)&&(R7<R5)&&(R7<R6)&&(R7<R8)&&(R7<R9)&&(R7<R10)){
                        hasil[j][1] = "7";
                    }else if ((R8<R1)&&(R8<R2)&&(R8<R3)&&(R8<R4)&&(R8<R5)&&(R8<R6)&&(R8<R7)&&(R8<R9)&&(R4<R10)){
                        hasil[j][1] = "8";
                    }else if ((R9<R1)&&(R9<R2)&&(R9<R3)&&(R9<R4)&&(R9<R5)&&(R9<R6)&&(R9<R7)&&(R9<R8)&&(R9<R10)){
                        hasil[j][1] = "9";
                    }else if ((R10<R1)&&(R10<R2)&&(R10<R3)&&(R10<R4)&&(R10<R5)&&(R10<R6)&&(R10<R7)&&(R10<R8)&&(R10<R9)){
                        hasil[j][1] = "10";    
                    }    
                        
                    System.out.println("--Kelompok Clustering--");
                    System.out.println("Kelompok -> "+hasil[j][1]);
                    writer.append(hasil[j][1]);
                    writer.append('\n');
                }
            }
writer.flush();
writer.close();
    }
}    
                
                