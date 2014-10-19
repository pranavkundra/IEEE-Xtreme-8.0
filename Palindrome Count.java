/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtremej;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author pranavkundra
 */
public class Palindrome 
{
    public static void main(String [] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        input=in.readLine();
        input=input.trim();
        
        StringBuffer sb = new StringBuffer(input);
        String reverse=sb.reverse().toString();
        
//        System.out.println(input + " " + reverse);
        
        char x=' ',y=' ';
        
        int [][]c=new int[input.length()+1][reverse.length()+1];
        
        for(int i=0;i<input.length();i++)
        {
            c[i][0]=0;
            c[0][i]=0;
        }
        
        for(int i=1;i<c.length;i++)
        {
            for(int j=1;j<c[i].length;j++)
            {
                x=input.charAt(i-1);
                y=reverse.charAt(j-1);
                
                if(x==y)
                    c[i][j]=c[i-1][j-1]+1;
                
                else
                    c[i][j]=Math.max(c[i-1][j], c[i][j-1]);
            }
        }
        
        System.out.println(c[input.length()][reverse.length()]);
    }
}
