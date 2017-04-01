package com.example.android.order;

/**
 * Created by sibby on 4/1/2017.
 */
public class Globals{
    private static Globals instance;

    // Global variable
    private int data;
    private int count;
    private String[] stck;
    private String[] prc;
    private int[] confdata = new int[50];
    private int confcount;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setCount(){
        this.count = 0;
    }
    public int getCount(){
        return count;
    }
    public void setConfcount(){
        this.confcount = 0;
    }
    public int getConfcount(){
        return this.confcount;
    }
    public void setData(int d){
        this.data=d;
        this.count++;
    }
    public void setConfData(int d,int i){
        this.confdata[i] = d;
        this.confcount++;
    }
    public int getData(){
        return this.data;
    }
    public int getConfdata(int i){ return this.confdata[i]; }
    public void setStrings(String s, String p){
        this.stck[count-1] = s;
        this.prc[count-1] = p;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}
