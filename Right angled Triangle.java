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
public class Triangles 
{
    public static void main(String []args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(in.readLine());
        String temp="";
        
        double a[] = new double[n];
        double b[] = new double[n];
//        int h[] = new int[n];
        
        for(int i=0;i<n;i++)
        {
            temp=in.readLine();
            int index=temp.indexOf(" ");
            
            a[i]=Integer.parseInt((temp.substring(0, index)).trim());
            b[i]=Integer.parseInt((temp.substring(index+1)).trim());
        }
        
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
        
        double theta=0;
        double x1=0,x2=0,y1=0,y2=0,h=0;
        long roundX1=0,roundY1=0,roundX2=0,roundY2=0;
        
        boolean flag=false;
        
        for(int i=0;i<n;i++)
        {
            for(theta=0;theta<=180;theta+=0.1)
            {
                x1=a[i]*Math.cos(Math.toRadians(theta));
                y1=a[i]*Math.sin(Math.toRadians(theta));

                x2=b[i]*Math.cos(Math.toRadians(90-theta));
                y2=b[i]*Math.sin(Math.toRadians(90-theta));

                roundX1=Math.round(x1);
                roundX2=-Math.round(x2);
                roundY1=Math.round(y1);
                roundY2=Math.round(y2);

                if(roundX1==0 || roundX2==0 || roundY1==0 || roundY2==0) continue;

                boolean c1=false,c2=false,c3=false;

                c1=(a[i]==Math.round(Math.sqrt(Math.pow(roundX1,2) + Math.pow(roundY1,2))));
                c2=(b[i]==Math.round(Math.sqrt(Math.pow(roundX2,2) + Math.pow(roundY2,2))));
                h=Math.sqrt(a[i]*a[i] + b[i]*b[i]);
                c3=(h==(Math.sqrt(Math.pow(roundX1-roundX2,2) + Math.pow(roundY1-roundY2,2))));

    //            System.out.println(roundX1 + " " + roundY1 + " " + roundX2 + " " + roundY2);
    //            System.out.println((Math.sqrt(Math.pow(roundX1,2) + Math.pow(roundY1,2))));
    //            System.out.println(Math.sqrt(Math.pow(roundX2,2) + Math.pow(roundY2,2)));

    //            if(c1)
    //                System.out.println("c1 true theta" + theta);
    //            if(c2)
    //                System.out.println("c2 true theta" + theta);
    //            if(c3)
    //                System.out.println("c3 true theta" + theta);
    //            
                if(c1 && c2 && c3) flag=true;
    //                System.out.println("All true theta" + theta);
            }
        
            if(flag)
                System.out.println("TRUE");
            else
                System.out.println("FALSE");
        }
    }
}
