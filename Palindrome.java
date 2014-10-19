import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	char a[]=s.toCharArray();
	Vector<Integer> f=new Vector<Integer>();
	Vector<Character> c=new Vector<Character>();
	c.add(a[0]);
	f.add(1);
	for(int i=1;i<a.length;i++)
	{
		System.out.println(i);
		int temp=c.indexOf(a[i]);
		System.out.println("Temp:"+temp);
		if(temp!=-1)
		{
			f.set(temp,f.get(temp)+1);
		}
		else
		{
			c.add(a[i]);
			f.add(1);		
		}
		System.out.println(c);
		System.out.println(f);
	}
	int size=0;
	int flag=0;
	for(int i=0;i<f.size();i++)
	{
		if(f.get(i)%2==0)
		size+=f.get(i);
		else if(f.get(i)>2) size=size+f.get(i)-1;
		else flag=1;
	}
	if(flag==1) size+=1;
	System.out.println(a.length);
	System.out.println("Size is "+size);
    }
}
