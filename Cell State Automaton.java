/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtremej;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author pranavkundra
 */
public class Automaton 
{
    public static long rules(long a, long b, long c, long rule)
    {
        long output=0;
        
        if(a==1 && b==1 && c==1)        output=((rule & 0x80))==0?0:1;
        else if(a==1 && b==1 && c==0)   output=((rule & 0x40))==0?0:1;
        else if(a==1 && b==0 && c==1)   output=((rule & 0x20))==0?0:1;
        else if(a==1 && b==0 && c==0)   output=((rule & 0x10))==0?0:1;
        else if(a==0 && b==1 && c==1)   output=((rule & 0x08))==0?0:1;
        else if(a==0 && b==1 && c==0)   output=((rule & 0x04))==0?0:1;
        else if(a==0 && b==0 && c==1)   output=((rule & 0x02))==0?0:1;
        else if(a==0 && b==0 && c==0)   output=((rule & 0x01))==0?0:1;
        
        return output;
    }
    
    public static void main(String []args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        input=in.readLine();
        
//        int space[] = new int [3];
        
        
        String splitted[] = input.split(" ");
        
        int rule,iterations,no_of_cells;
        long initial_cell_state=16;
        rule=Integer.valueOf(splitted[0]);
        iterations=Integer.valueOf(splitted[1].trim());
        no_of_cells=Integer.valueOf(splitted[2].trim());
        long temp=Long.valueOf(splitted[3].trim());
        String ses=Long.toBinaryString(temp);
        
        try{
            initial_cell_state=Long.valueOf(ses.trim());
        }catch(NumberFormatException e)  // to accomodate a test case 
        {
            int space=input.lastIndexOf(" ");
            String x=input.substring(space);
            x=x.trim();
            initial_cell_state=Long.valueOf(Long.toBinaryString(Long.parseLong(x)));
        }
        
        long []old_state,new_state;
        old_state = new long[no_of_cells+2];
        new_state = new long[no_of_cells+2];
        
        for(int i=no_of_cells;i>=1;i--)
        {
            old_state[i]=initial_cell_state%10;
            initial_cell_state/=10;
            new_state[i]=old_state[i];
        }
        new_state[0]=old_state[0]=0;
        new_state[no_of_cells+1]=old_state[no_of_cells+1]=0;
        
//        System.out.println(Arrays.toString(old_state));
        
        for(int x=1;x<=iterations;x++)
        {  
            
            String spaces=(x>99)?" ":(x>9)?"  ":"   ";
            System.out.print(x+spaces);
            
            System.out.print("-");
            for(int i=1;i<=no_of_cells;i++)
            {
                if(new_state[i]==1)
                    System.out.print("*");
                else if(new_state[i]==0)
                    System.out.print(" ");
            }
            System.out.println("-");
            
            //iterate
            for(int i=1;i<=no_of_cells;i++)
            {
                new_state[i]=rules(old_state[i-1], old_state[i], old_state[i+1], rule);
            }
            
//            System.out.println("New state" + Arrays.toString(new_state));
            
            boolean stopping_condition=true;
            //check if states have not changed after iteration
            for(int idash=0;idash<no_of_cells+2;idash++)
            {
                if(old_state[idash]!=new_state[idash])
                {
                    stopping_condition=false;
                    break;
                }
            }
            if(stopping_condition)
            {
                spaces=(x>99)?" ":(x>9)?"  ":"   ";
                System.out.print(x+spaces);

                System.out.print("-");
                for(int i=1;i<=no_of_cells;i++)
                {
                    if(new_state[i]==1)
                        System.out.print("*");
                    else if(new_state[i]==0)
                        System.out.print(" ");
                }
                System.out.println("-");
                break;
            }
            
            for(int i=1;i<=no_of_cells;i++)
            {
                old_state[i]=new_state[i];
            }
        }
    }
}
