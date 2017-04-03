package com.example.android.order;

/**
 * Created by sibby on 4/1/2017.
 */
public class Globals{
    private static Globals instance;

    // Global variable
    private int data;
    private int count;
    private static int[] value = new int[100];
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

    public void incValue(int pos){
        value[pos]++;
    }
    public void decValue(int pos){
        if(value[pos]>0)
        value[pos]--;
    }

    public int getValue(int pos){
        return value[pos];
    }


    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
            for(int i=0;i<100;i++){
                value[i] = 0;
            }
        }
        return instance;
    }
}
