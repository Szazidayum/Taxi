package main;

import java.util.Locale;

public class TaxiProgram {
    public static void main(String[] args) {
        String[] sorok = new String[5];
		//	   fizMod;tipus;perc;osszeg;rendszam
        sorok[0] = "kp;VW;120;27500;ABC-123"; 
        sorok[1] = "kp;BMW;12;1350;QWE-123"; 
        sorok[2] = "kp;VW;43;8750;ABC-123"; 
        sorok[3] = "kártya;VW;53;9520;ABC-123"; 
        sorok[4] = "utalás;Opel;23;5200;ASD-123"; 
        
		// minden sorból készíts egy Fuvar típust, azokat rakd  be egy Fuvar[] szerkezetbe

        Fuvar[] fuvarok = new Fuvar[sorok.length];
        for (int i = 0; i < sorok.length; i++) {
            fuvarok[i] = new Fuvar(sorok[i]);
        }  

        /* INNEN a feladat, minden VÁLASZ a fuvarok tömbben van! */

        System.out.print("1. feladat: átlag bevétel: ");
        int ossz = 0;
        for (Fuvar fuvar : fuvarok) {
            ossz += fuvar.mekkoraOsszeg();
        }
        System.out.println("\n\tAz átlag bevétel: "+(double)ossz / fuvarok.length+" Ft.");
        
        System.out.print("2. feladat: ABC-123 rsz átlag bevétele: \n\t");
	ossz = 0;
        int db = 0;
        for (Fuvar fuvar : fuvarok) {
            if (fuvar.milyenRsz().equals("ABC-123")) {
                ossz += fuvar.mekkoraOsszeg();
                db++;
            }
        }
        System.out.printf(Locale.ENGLISH, "%.2f Ft az ABC-123 rsz átlag bevétele.\n", (double)ossz / db);
        
        System.out.println("3. feladat: kinél volt a leghosszabb fuvar?");
        int max =0;
        for (Fuvar fuvar : fuvarok) {
            if(fuvar.hanyPerc()>max){
                max=fuvar.hanyPerc();
            }
        }
        System.out.printf("\tA leghosszabb fuvar: %d",max);
		
        System.out.println("\n4. feladat: hogyan fizették a legdrágább utat?");
        int legnagyobb =0;
        String rendszam = "";
        for (Fuvar fuvar : fuvarok) {
            if(fuvar.mekkoraOsszeg()>legnagyobb){
                legnagyobb=fuvar.mekkoraOsszeg();
                rendszam = fuvar.milyenRsz();
            }
            
        }
        
//        System.out.printf("\tA legdrágább fuvar: %d",legnagyobb);
        System.out.printf("\tA legdrágább fuvar: %s",rendszam);
		
	System.out.println("\n5. feladat: minden fizetés kp-s volt?");
        int mindKp=0;
        for (Fuvar fuvar : fuvarok) {
            if(fuvar.milyenFizetes().equals("kp")){
                mindKp++;
            }
        }
        if(mindKp==fuvarok.length){
            System.out.println("\tMinden fizetés kp-s volt.");
        }else{
            System.out.println("\tNem volt minden fizetés kp-s.");
        }
		
	System.out.println("6. feladat: volt kártyás fizetés?");
	boolean kartyasF=false;
        for (Fuvar fuvar : fuvarok) {
            if(fuvar.milyenFizetes().equals("kártya")){
                kartyasF=true;
//                System.out.println("Volt kártyás fizetés.");
            }
        }
         System.out.println("\tVolt-e kártyás fizetés: "+kartyasF);
    }
    
}
