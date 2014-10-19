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
public class KValueFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input="";
        
        input=in.readLine();
        
        String[] splitted = input.split(" ");
        
        int inputs;//=(int)input.charAt(0)-48;
        int sublength;// = (int)input.charAt(2)-48;
        int k;// = (int)input.charAt(4)-48;
        
        inputs=Integer.valueOf(splitted[0]);
        sublength=Integer.valueOf(splitted[1]);
        k=Integer.valueOf(splitted[2]);
        
//        int inputs=(int)input.charAt(0)-48;
//        int sublength = (int)input.charAt(2)-48;
//        int k = (int)input.charAt(4)-48;
        
        System.out.print("");
        input=in.readLine();
        splitted = input.split(" ");
        //int idash=0,kdash=0;
        //char b=' ';
        
        int input_array[] = new int[inputs];
        //System.out.print(input);
        
//        while(kdash<input.length())
//        {
//            b=input.charAt(kdash++);
//            //System.out.print(b);
//            
//            if(b==' ')
//                continue;
//            
//            input_array[idash++]=(int)b - 48;
//        }
        
        for(int z=0;z<splitted.length;z++)
            input_array[z]=Integer.valueOf(splitted[z]);
        
        
//        for(int s:input_array)
//            System.out.println(s);
        // TODO code application logic here
        
        int sub[]= new int[sublength];
        int klow[] = new int[k];
        int klowfinal=Integer.MAX_VALUE;//[] = new int[k];
        
        for(int i=0;i<klow.length;i++)
        {
            klow[i]=Integer.MAX_VALUE;
//            klowfinal[i]=Integer.MAX_VALUE;
        }
        
        for(int i=0;i<input_array.length;i++)
        {
            for(int j=0;j<sublength;j++)
            {
                int temp=(i+j)>=(input_array.length)?(i+j-input_array.length):(i+j);
                
                sub[j]=input_array[temp];
                
                //variant of insertion sort
                for(int jdash=0;jdash<k;jdash++)
                {
                    if(sub[j]<klow[jdash])
                    {
                        if(klowfinal!=Integer.MAX_VALUE && !(sub[j]<klowfinal)) break;
                        
                        if(klow[jdash]==Integer.MAX_VALUE)
                        {
                            klow[jdash]=sub[j];
                            break;
                        }
                        
                        else
                        {
                            for(int x=klow.length-1;x>jdash;x--)
                            {
                                klow[x]=klow[x-1];
                                
                            }
                            klow[jdash]=sub[j];
                            break;
                        }
                    }
                }
            }
            
            if(klowfinal>klow[klow.length-1])
                klowfinal=klow[klow.length-1];
            
            
            for(int ik=0;ik<klow.length;ik++)
                klow[ik]=Integer.MAX_VALUE;
            
//            for(int ik=0;ik<sub.length;ik++)
//                sub[ik]=Integer.MAX_VALUE;
//            System.out.println(Arrays.toString(sub));
            
        }
        
        System.out.println(klowfinal);
    }
}
