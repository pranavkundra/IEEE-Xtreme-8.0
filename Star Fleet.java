/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtremej;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 *
 * @author pranavkundra
 */

class Travel
{
    int start_port;
    int end_port;
    int startDate;
    int endDate;
    int start_time;
    int end_time;

    public Travel() {
    }

    public Travel(int strat_port, int end_port, int startDate, int endDate, int start_time, int end_time) {
        this.start_port = strat_port;
        this.end_port = end_port;
        this.startDate = startDate;
        this.endDate = endDate;
        this.start_time = start_time;
        this.end_time = end_time;
    }
    
    @Override
    public String toString()
    {
        return start_port + " " + startDate + " " + start_time + " " + end_port + " " + endDate + " " + end_time;
    }
}

/**
 *
 * @author pranavkundra
 */
public class StarFleet 
{
    static int min_arrival=Integer.MAX_VALUE;
    
    static void f(Travel []plans, int start_port, int end_port, int prev_end_time, int starttime)
    {
        for(int i=0;i<plans.length;i++)
        {
//            if(plans[i].start_port==start_port && plans[i].end_port==end_port && ((plans[i].startDate*1440 + plans[i].start_time)>starttime))  //base case
            if(((plans[i].start_port==start_port) && (plans[i].end_port==end_port)) && ((plans[i].startDate*1440 + plans[i].start_time)>starttime))
            {
//                if(min_arrival==-1)
//                    min_arrival=plans[i].endDate*1440 + plans[i].end_time;
                
                if(min_arrival>(plans[i].endDate*1440 + plans[i].end_time))
                    min_arrival=plans[i].endDate*1440 + plans[i].end_time;
            }
            
            //recursive case
//            else if((plans[i].start_port==end_port) && ((plans[i].endDate*1440 + plans[i].end_time)>prev_end_time) && ((plans[i].startDate*1440 + plans[i].start_time)>starttime))
            else if(((plans[i].startDate*1440 + plans[i].start_time)>prev_end_time) && (plans[i].startDate!=((int)(prev_end_time)/1440)) && ((plans[i].startDate*1440 + plans[i].start_time)>starttime))
            {
                f(plans, plans[i].start_port, end_port, plans[i].endDate*1440 + plans[i].end_time, starttime/*(plans[i].startDate*1440 + plans[i].start_time)*/);
            }
        }
    }
    
    public static int find(String []names, String value)
    {
        int val=-1;
        
        for(int i=0;i<names.length;i++)
            if(names[i].equalsIgnoreCase(value))
                val=i;
        
        return val;
    }
    
    public static void main(String []args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        input=in.readLine();
        
        String splitted[] = input.split(" ");
        int no_of_ports=Integer.valueOf(splitted[0]);
        int flight_plans = Integer.valueOf(splitted[1]);
        int query = Integer.valueOf(splitted[2]);
        
        String names[] = new String[no_of_ports];
//        int adjacency [][] = new int[no_of_ports][no_of_ports];
        Travel[] plans= new Travel[flight_plans];
        
        for(int i=0;i<no_of_ports;i++)
            names[i]=in.readLine().trim();
        
//        System.out.println(Arrays.toString(names));
        
        for(int i=0;i<flight_plans;i++)
        {
            input=in.readLine();
            splitted=input.split(" ");
            
            int ss1,ss2,ss4,ss5;
            ss1=Integer.valueOf(splitted[1]);
            ss2=Integer.valueOf(splitted[2]);
            ss4=Integer.valueOf(splitted[4]);
            ss5=Integer.valueOf(splitted[5]);
            
//            System.out.println(names[0].equals(splitted[0]));
//            System.out.println(names[0] + " " + splitted[0]);
            
            plans[i]=new Travel(find(names,splitted[0]), find(names,splitted[3]), ss1, ss4, ss2, ss5);
        }
        
        for(int i=0;i<query;i++)
        {
            input=in.readLine();
            splitted = input.split(" ");
            
            int startport=find(names,splitted[0].trim());
            int endport=find(names,splitted[3].trim());
            
            int startdate=Integer.valueOf(splitted[1]);
            int starttime = Integer.valueOf(splitted[2]);
            
            int arrivaldate,arrivaltime;
            min_arrival=Integer.MAX_VALUE;
            
            f(plans, startport, endport, 0, (startdate*1440 + starttime));
            arrivaltime=min_arrival;
            
            arrivaldate=arrivaltime/1440;
            arrivaltime-=(arrivaldate*1440);
            
            if(min_arrival==Integer.MAX_VALUE)
                System.out.println("No trip on XSL");
            
           
            
            else
                System.out.println(arrivaldate + " " + arrivaltime);
            
            min_arrival=Integer.MAX_VALUE;
            
        }
        
//        System.out.println(Arrays.toString(plans));
    }
}
