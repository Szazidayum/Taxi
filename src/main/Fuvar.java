
package main;


class Fuvar {
    private String fizMod, tip, rsz;
    private int perc, osszeg;
    
    public Fuvar(String sor){
        String[] s = sor.split(";");
        this.fizMod = s[0];
        this.tip = s[1];
        this.perc = Integer.parseInt(s[2]);
        this.osszeg = Integer.parseInt(s[3]);
        this.rsz = s[4];
    }
    
    public String milyenFizetes(){return fizMod;}
    public String milyenTipus(){return tip;}
    public String milyenRsz(){return rsz;}
    public int hanyPerc(){ return perc; }
    public int mekkoraOsszeg(){ return osszeg; }
}
