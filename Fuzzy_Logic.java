/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Fzz {

    public static double fungsi1 (double z, double x, double y){
        return ((y-z)/(y-x));
    }
    
    public static double fungsi2 (double z, double x, double y){
        return ((z-x)/(y-x));
    }
    
    public static double lowpL(double z, double x, double y){
        double pL;
        String ket;
        if (z <= x) {
                pL = 1;
                ket = "pL";
            } else if ((z < x) && (z > y)) {
                pL = fungsi1(z,x,y);
                ket = "pL";
            } else {
                pL = 0;
            }
        return pL;
    }
    
    public static double medpM(double z, double x1, double x2, double y1, double y2){
        double pM;
        String ket;
        if ((z <= y1) && (z >= x1)) {
                pM = 1;
                ket = "pM";
            } else if ((z < y2) && (z > x1)) {
                pM = fungsi1(z,x1,y2);
                ket = "pM";
            } else if ((z < y1) && (z > x2)) {
                pM = fungsi2(z,x2,y1);
                ket = "pM";
            } else {
                pM = 0;
            }
        return pM;
    }
    
    public static double abvpA(double z, double x1, double x2, double y1, double y2){
        double pA;
        String ket;
        if ((z <= y1) && (z >= x1)) {
                pA = 1;
                ket = "pM";
            } else if ((z < y2) && (z > x1)) {
                pA = fungsi1(z,x1,y2);
                ket = "pM";
            } else if ((z < x2) && (z > y1)) {
                pA = fungsi2(z,x2,y1);
                ket = "pM";
            } else {
                pA = 0;
            }
        return pA;
    }
    
    public static double highpH(double z, double x, double y){
        double pH;
        String ket;
        if (z >= x) {
                pH = 1;
                ket = "pH";
            } else if ((z < y) && (z > x)) {
                pH = fungsi2(z,x,y);
                ket = "pH";
            } else {
                pH = 0;
            }
        return pH;
    }
    
    public static double lowhL(double z, double x, double y){
        double hL;
        String ket;
        if (z <= y) {
                hL = 1;
                ket = "pL";
            } else if ((z < y) && (z > x)) {
                hL = fungsi1(z,x,y);
                ket = "pL";
            } else {
                hL = 0;
            }
        return hL;
    }
    
    public static double medhM(double z, double x1, double x2, double y1, double y2){
        double hM;
        String ket;
        if ((z <= y1) && (z >= x1)) {
                hM = 1;
                ket = "pM";
            } else if ((z < y2) && (z > x1)) {
                hM = fungsi1(z,x1,y2);
                ket = "pM";
            } else if ((z < y1) && (z > x2)) {
                hM = fungsi2(z,x2,y1);
                ket = "pM";
            } else {
                hM = 0;
            }
        return hM;
    }
    
    public static double abvhA(double z, double x1, double x2, double y1, double y2){
        double hA;
        String ket;
        if ((z <= y1) && (z >= x1)) {
                hA = 1;
                ket = "pM";
            } else if ((z < y2) && (z > x1)) {
                hA = fungsi1(z,x1,y2);
                ket = "pM";
            } else if ((z < y1) && (z > x2)) {
                hA = fungsi2(z,x2,y1);
                ket = "pM";
            } else {
                hA = 0;
            }
        return hA;
    }
    
    public static double highhH(double z, double x, double y){
        double hH;
        String ket;
        if (z >= x) {
                hH = 1;
                ket = "pH";
            } else if ((z < y) && (z > x)) {
                hH = fungsi2(z,x,y);
                ket = "pH";
            } else {
                hH = 0;
            }
        return hH;
    }
    
    public static double Sugeno (double x, double y){
        return ((x*10)+(y*9))/(x+y);
    }
    
    public static String Penentuan (double x){
        String hasil;
        if (x <= 9) {
                hasil = "Tidak Diterima";
            } else {
                hasil = "Diterima";
            }
        return hasil;
    }
    
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
        String[][] data=new String[input.size()][4];
        for (int i = 0; i < input.size(); i++) {
             ArrayList<String> item=tiket(input.get(i));
             for (int j = 0; j < item.size(); j++) {
                data[i][j]=item.get(j);
            }
        }
        return data;
    }
    public static void main(String[] args)throws FileNotFoundException, IOException {
        ArrayList<String> listData=bacateks("data/DataTugas2.csv");
        FileWriter writer = new FileWriter("hasil_eksekusi/data_penerima_blt.csv");
        String[][] array=simpanArray(listData);
        double pL, pM, pH, pVH, hL, hM, hH, hVH = 0;
        String ket;
        for (int i = 1; i <= 100; i++) {
            double peng = Double.parseDouble(array[i][1]);
            double hutt = Double.parseDouble(array[i][2]);
            
            lowpL(peng,0.182,0.67);
            medpM(peng,0.67,1.128,0.112,1.281);
            abvpA(peng,1.281,1.318,1.218,1.458);
            highpH(peng,1.458,1.684);
            lowhL(hutt,0,30.456);
            medhM(hutt,30.456,46.253,45.467,64.534);
            abvhA(hutt,64.534,66.756,65.718,72.554);
            highhH(hutt,72.554,74.576);
                        
            double tk1,tk2,tk3,tk4,tk5,tk6,tk7,tk8,tk9,tk10,tk11, tm1,tm2,tm3,tm4,tm5 = 0;
            tk1 = Math.min(lowpL(peng,0.182,0.67), lowhL(hutt,0,30.456));
            tm1 = Math.min(lowpL(peng,0.182,0.67), medhM(hutt,30.456,46.253,45.467,64.534));
            tm2 = Math.min(lowpL(peng,0.182,0.67), highhH(hutt,72.554,74.576));
            tm3 = Math.min(lowpL(peng,0.182,0.67), abvhA(hutt,46.254,62.756,68.718,72.554));
            tk2 = Math.min(medpM(peng,0.67,1.128,0.112,1.281), lowhL(hutt,0,30.456));
            tk3 = Math.min(medpM(peng,0.67,1.128,0.112,1.281), medhM(hutt,30.456,46.253,45.467,64.534));
            tm4 = Math.min(medpM(peng,0.67,1.128,0.112,1.281), highhH(hutt,72.554,74.576));
            tm5 = Math.min(medpM(peng,0.67,1.128,0.112,1.281), abvhA(hutt,46.254,62.756,68.718,72.554));
            tk4 = Math.min(highpH(peng,1.458,1.684), lowhL(hutt,0,30.456));
            tk5 = Math.min(highpH(peng,1.458,1.684), medhM(hutt,30.456,46.253,45.467,64.534));
            tk6 = Math.min(highpH(peng,1.458,1.684), highhH(hutt,72.554,74.576));
            tk7 = Math.min(highpH(peng,1.458,1.684), abvhA(hutt,46.254,62.756,68.718,72.534));
            tk8 = Math.min(abvpA(peng,1.281,1.318,1.218,1.458), lowhL(hutt,0,30.456));
            tk9 = Math.min(abvpA(peng,1.281,1.318,1.218,1.458), medhM(hutt,30.456,46.253,45.467,64.534));
            tk10 = Math.min(abvpA(peng,1.281,1.318,1.218,1.458), highhH(hutt,72.554,74.576));
            tk11 = Math.min(abvpA(peng,1.281,1.318,1.218,1.458), abvhA(hutt,46.254,62.756,68.718,72.554));
                   
            double[] penentuan = {tk1,tk2,tk3,tk4,tk5,tk6,tk7,tk8,tk9,tk10,tk11,tm1,tm2,tm3,tm4,tm5};
            double Tlkmax = 0, Trmmax  = 0;
            for (int n = 0; n <= 15; n++) {
                if (penentuan[n] >= Tlkmax ) {
                    Tlkmax = penentuan[n];
                }
                else if (penentuan[n] >= Trmmax) {
                    Trmmax = penentuan[n];
               }
            }
            String hasil;
            double p;
            Sugeno(Trmmax,Tlkmax);
            p = Sugeno(Trmmax,Tlkmax);
            Penentuan(p);
            hasil = Penentuan(p);
            int j = i + 1;
            if (hasil == "Diterima") { 
                System.out.println("--Data Keluarga Penerima BLT--");
                System.out.println("Keluarga ke "+array[i][0]+".  "+peng+"  "+hutt+" "+hasil);
                writer.append(array[i][0]);
                writer.append('\n');
            }
        }
writer.flush();
writer.close();
    }
}
