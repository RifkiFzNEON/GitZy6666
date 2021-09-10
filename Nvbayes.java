/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nvbayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Nvbayes {
    
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
        ArrayList<String> DataTest=bacateks("data/TestsetTugas1ML.csv");
        ArrayList<String> DataTrain=bacateks("data/TrainsetTugas1ML.csv");
        FileWriter writer = new FileWriter("hasil_eksekusi/TebakanTugas1ML.csv");
        String[][] array=simpanArray(DataTest);
        String[][] array1=simpanArray(DataTrain);
        String[][] hasilincome = new String[50][50];
        ArrayList<Double> arraylist = new ArrayList<Double>();
        
        double youngY=0, adultY=0, oldY=0, privateY=0, localgovY=0, selfempY=0, hsgradY=0, bachelorsY=0, 
                smcollegeY=0, nvmarriedY=0, divorcedY=0, marriedcivY=0, profY=0, craftY=0, execY=0, husbandY=0,
                familyY=0, childY=0, manyY=0, normalY=0, lowY=0, incomeY=0;

        double youngN=0, adultN=0, oldN=0, privateN=0, localgovN=0, selfempN=0, hsgradN=0, bachelorsN=0, 
                smcollegeN=0, nvmarriedN=0, divorcedN=0, marriedcivN=0, profN=0, craftN=0, execN=0, husbandN=0,
                familyN=0, childN=0, manyN=0, normalN=0, lowN=0, incomeN=0;

        for (int i = 1; i <= 160; i++) {
                String train1 = array1[i][1];
                String train2 = array1[i][2];
                String train3 = array1[i][3];
                String train4 = array1[i][4];
                String train5 = array1[i][5];
                String train6 = array1[i][6];
                String train7 = array1[i][7];
                String train8 = array1[i][8];
                
                if (train1.equalsIgnoreCase("young") && train8.equalsIgnoreCase(">50K")){
                    youngY = youngY + 1; 
                }else if (train1.equalsIgnoreCase("adult") && train8.equalsIgnoreCase(">50K")){
                    adultY = adultY + 1;
                }else if (train1.equalsIgnoreCase("old") && train8.equalsIgnoreCase(">50K")){
                    oldY = oldY + 1;
                }

                if (train2.equalsIgnoreCase("Private") && train8.equalsIgnoreCase(">50K")){
                    privateY = privateY + 1; 
                }else if (train2.equalsIgnoreCase("Self-emp-not-inc") && train8.equalsIgnoreCase(">50K")){
                    selfempY = selfempY + 1;
                }else if (train2.equalsIgnoreCase("Local-gov") && train8.equalsIgnoreCase(">50K")){
                    localgovY = localgovY + 1;
                }

                if (train3.equalsIgnoreCase("HS-grad") && train8.equalsIgnoreCase(">50K")){
                    hsgradY = hsgradY + 1; 
                }else if (train3.equalsIgnoreCase("Bachelors") && train8.equalsIgnoreCase(">50K")){
                    bachelorsY = bachelorsY + 1;
                }else if (train3.equalsIgnoreCase("Some-college") && train8.equalsIgnoreCase(">50K")){
                    smcollegeY = smcollegeY + 1;
                }

                if (train4.equalsIgnoreCase("Never-married") && train8.equalsIgnoreCase(">50K")){
                    nvmarriedY = nvmarriedY + 1; 
                }else if (train4.equalsIgnoreCase("Divorced") && train8.equalsIgnoreCase(">50K")){
                    divorcedY = divorcedY + 1;
                }else if (train4.equalsIgnoreCase("Married-civ-spouse") && train8.equalsIgnoreCase(">50K")){
                    marriedcivY = marriedcivY + 1;
                }

                if (train5.equalsIgnoreCase("Prof-specialty") && train8.equalsIgnoreCase(">50K")){
                    profY = profY + 1; 
                }else if (train5.equalsIgnoreCase("Craft-repair") && train8.equalsIgnoreCase(">50K")){
                    craftY = craftY + 1;
                }else if (train5.equalsIgnoreCase("Exec-managerial") && train8.equalsIgnoreCase(">50K")){
                    execY = execY + 1;
                }

                if (train6.equalsIgnoreCase("Not-in-family") && train8.equalsIgnoreCase(">50K")){
                    familyY = familyY + 1; 
                }else if (train6.equalsIgnoreCase("Husband") && train8.equalsIgnoreCase(">50K")){
                    husbandY = husbandY + 1;
                }else if (train6.equalsIgnoreCase("Own-child") && train8.equalsIgnoreCase(">50K")){
                    childY = childY + 1;
                }

                if (train7.equalsIgnoreCase("many") && train8.equalsIgnoreCase(">50K")){
                    manyY = manyY + 1; 
                }else if (train7.equalsIgnoreCase("normal") && train8.equalsIgnoreCase(">50K")){
                    normalY = normalY + 1;
                }else if (train7.equalsIgnoreCase("low") && train8.equalsIgnoreCase(">50K")){
                    lowY = lowY + 1;
                }

                if (train1.equalsIgnoreCase("young") && train8.equalsIgnoreCase("<=50K")){
                    youngN = youngN + 1; 
                }else if (train1.equalsIgnoreCase("adult") && train8.equalsIgnoreCase("<=50K")){
                    adultN = adultN + 1;
                }else if (train1.equalsIgnoreCase("old") && train8.equalsIgnoreCase("<=50K")){
                    oldN = oldN + 1;
                }

                if (train2.equalsIgnoreCase("Private") && train8.equalsIgnoreCase("<=50K")){
                    privateN = privateN + 1; 
                }else if (train2.equalsIgnoreCase("Self-emp-not-inc") && train8.equalsIgnoreCase("<=50K")){
                    selfempN = selfempN + 1;
                }else if (train2.equalsIgnoreCase("Local-gov") && train8.equalsIgnoreCase("<=50K")){
                    localgovN = localgovN + 1;
                }

                if (train3.equalsIgnoreCase("HS-grad") && train8.equalsIgnoreCase("<=50K")){
                    hsgradN = hsgradN + 1; 
                }else if (train3.equalsIgnoreCase("Bachelors") && train8.equalsIgnoreCase("<=50K")){
                    bachelorsN = bachelorsN + 1;
                }else if (train3.equalsIgnoreCase("Some-college") && train8.equalsIgnoreCase("<=50K")){
                    smcollegeN = smcollegeN + 1;
                }

                if (train4.equalsIgnoreCase("Never-married") && train8.equalsIgnoreCase("<=50K")){
                    nvmarriedN = nvmarriedN + 1; 
                }else if (train4.equalsIgnoreCase("Divorced") && train8.equalsIgnoreCase("<=50K")){
                    divorcedN = divorcedN + 1;
                }else if (train4.equalsIgnoreCase("Married-civ-spouse") && train8.equalsIgnoreCase("<=50K")){
                    marriedcivN = marriedcivN + 1;
                }

                if (train5.equalsIgnoreCase("Prof-specialty") && train8.equalsIgnoreCase("<=50K")){
                    profN = profN + 1; 
                }else if (train5.equalsIgnoreCase("Craft-repair") && train8.equalsIgnoreCase("<=50K")){
                    craftN = craftN + 1;
                }else if (train5.equalsIgnoreCase("Exec-managerial") && train8.equalsIgnoreCase("<=50K")){
                    execN = execN + 1;
                }

                if (train6.equalsIgnoreCase("Not-in-family") && train8.equalsIgnoreCase("<=50K")){
                    familyN = familyN + 1; 
                }else if (train6.equalsIgnoreCase("Husband") && train8.equalsIgnoreCase("<=50K")){
                    husbandN = husbandN + 1;
                }else if (train6.equalsIgnoreCase("Own-child") && train8.equalsIgnoreCase("<=50K")){
                    childN = childN + 1;
                }

                if (train7.equalsIgnoreCase("many") && train8.equalsIgnoreCase("<=50K")){
                    manyN = manyN + 1; 
                }else if (train7.equalsIgnoreCase("normal") && train8.equalsIgnoreCase("<=50K")){
                    normalN = normalN + 1;
                }else if (train7.equalsIgnoreCase("low") && train8.equalsIgnoreCase("<=50K")){
                    lowN = lowN + 1;
                }

                if (train8.equalsIgnoreCase(">50K")){
                    incomeY = incomeY + 1;
                } else {
                    incomeN = incomeN + 1;
                }
        }
        
        for (int j = 1; j <= 40; j++){ 
            String test1 = array[j][1];
            String test2 = array[j][2];
            String test3 = array[j][3];
            String test4 = array[j][4];
            String test5 = array[j][5];
            String test6 = array[j][6];
            String test7 = array[j][7];

            double ageY=0, classY=0, eduY=0, statusY=0, occupY=0, relationY=0, hoursY=0;
            double ageN=0, classN=0, eduN=0, statusN=0, occupN=0, relationN=0, hoursN=0;
            
            if (test1.equalsIgnoreCase("young")){
                ageY = youngY; 
                ageN = youngN;
            }else if (test1.equalsIgnoreCase("adult")){
                ageY = adultY;
                ageN = adultN;
            }else if (test1.equalsIgnoreCase("old")){
                ageY = oldY;
                ageN = oldN;
            }
            
            if (test2.equalsIgnoreCase("Private")){
                classY = privateY;
                classN = privateN;
            }else if (test2.equalsIgnoreCase("Self-emp-not-inc")){
                classY = selfempY;
                classN = selfempN;
            }else if (test2.equalsIgnoreCase("Local-gov")){
                classY = localgovY;
                classN = localgovN;
            }
            
            if (test3.equalsIgnoreCase("HS-grad")){
                eduY = hsgradY;
                eduN = hsgradN;
            }else if (test3.equalsIgnoreCase("Bachelors")){
                eduY = bachelorsY;
                eduN = bachelorsN;
            }else if (test3.equalsIgnoreCase("Some-college")){
                eduY = smcollegeY;
                eduN = smcollegeN;
            }

            if (test4.equalsIgnoreCase("Never-married")){
                statusY = nvmarriedY;
                statusN = nvmarriedN;
            }else if (test4.equalsIgnoreCase("Divorced")){
                statusY = divorcedY;
                statusN = divorcedN;
            }else if (test4.equalsIgnoreCase("Married-civ-spouse")){
                statusY = marriedcivY;
                statusN = marriedcivN;
            }

            if (test5.equalsIgnoreCase("Prof-specialty")){
                occupY = profY;
                occupN = profN; 
            }else if (test5.equalsIgnoreCase("Craft-repair")){
                occupY = craftY;
                occupN = craftN;
            }else if (test5.equalsIgnoreCase("Exec-managerial")){
                occupY = execY;
                occupN = execN;
            }
            
            if (test6.equalsIgnoreCase("Not-in-family")){
                relationY = familyY;
                relationN = familyN;
            }else if (test6.equalsIgnoreCase("Husband")){
                relationY = husbandY;
                relationN = husbandN;
            }else if (test6.equalsIgnoreCase("Own-child")){
                relationY = childY;
                relationN = childN;
            }
            
            if (test7.equalsIgnoreCase("many")){
                hoursY = manyY;
                hoursN = manyN;
            }else if (test7.equalsIgnoreCase("normal")){
                hoursY = normalY;
                hoursN = normalN;
            }else if (test7.equalsIgnoreCase("low")){
                hoursY = lowY;
                hoursN = lowN;
            }
            
            double PxY, PxN, PY, PN;
            
            PY = incomeY / (incomeY + incomeN);
            PN = incomeN / (incomeY + incomeN);
            
            PxY = (((ageY/incomeY)*(classY/incomeY)*(eduY/incomeY)*(statusY/incomeY)*(occupY/incomeY)*(relationY/incomeY)*(hoursY/incomeY))*PY);
            PxN = (((ageN/incomeN)*(classN/incomeN)*(eduN/incomeN)*(statusN/incomeN)*(occupN/incomeN)*(relationN/incomeN)*(hoursN/incomeN))*PN);
            
            if (PxY > PxN){
                hasilincome[j][1] = ">50K";
            }else{
                hasilincome[j][1] = "<=50K";
            }
            
            System.out.println(" ");
            System.out.println("--Income--");
            System.out.println("Id    : "+array1[j][0]);
            System.out.println("PxY   : "+PxY);
            System.out.println("PxN   : "+PxN);
            System.out.println("Income: "+hasilincome[j][1]);
            writer.append(hasilincome[j][1]);
            writer.append('\n');
        }
        
writer.flush();
writer.close();
    }
}    
                
                