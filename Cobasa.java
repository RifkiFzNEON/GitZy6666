package cobasa;

public class Cobasa {
    public static double fungsi (double x, double y){
    
        int expakar = (int) Math.exp(Math.abs(1-Math.sqrt((Math.pow(x,2)) + (Math.pow(y,2)))/3.14));
        double hasil = (Math.sin(x) * Math.cos(y))*(expakar);
        return -(hasil);
    }
    public static void main(String[] args) {
        
       double x,y,nx,ny,Eb,En,deltaE,probE;
       double T = 5000;
       int i = 0;
       x = (double) (-10+Math.random()*10);
       y = (double) (-10+Math.random()*10);
       Eb = fungsi(x,y);
       System.out.println("x : "+ x);
       System.out.println("y : "+ y);
       System.out.println("Nilai Awal = "+ Eb);
       System.out.println("----------------------");
       System.out.println(" ");
       while (T > 0){
           i++;
           nx = (double) (-10+Math.random()*10);
           ny = (double) (-10+Math.random()*10);
           En = fungsi(nx,ny);
           Eb = fungsi(x,y);
           deltaE = En-Eb;
           probE = Math.exp(-deltaE/T);
           int j;
           j = (int) (0+Math.random()*1);
           if(En < Eb){
               x = nx;
               y = ny;
           }else if (j < probE){
                   x = nx;
                   y = ny;
           }           
           if(i == 10){ 
           T = T * (0.005);
           i = 0;
           }
           Eb = fungsi(x,y);
           System.out.println("x : "+ x);
           System.out.println("y : "+ y); 
           System.out.println("Nilai = "+ Eb);
           System.out.println(" ");
       }
       Eb = fungsi(x,y);
       System.out.println("----------------------");
       System.out.println("x : "+ x);
       System.out.println("y : "+ y); 
       System.out.println("Nilai Minimum = "+ Eb);
       System.out.println(" ");
    }
}
                        
