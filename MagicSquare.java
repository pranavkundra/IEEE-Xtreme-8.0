import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MagicSquare {

    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
        int size=Integer.parseInt(sc.nextLine());
	int matrix[][]=new int[size][size];
	int sum=0;
	int cols[]=new int[size];
	int rows[]=new int[size];
	for(int i=0;i<size;i++)
	{
		int sumrow=0;
		String x[]=sc.nextLine().split(" ");
		for(int j=0;j<size;j++)
		{	
			matrix[i][j]=Integer.parseInt(x[j]);	
			sumrow+=matrix[i][j];
			if(i==j)			
				sum+=matrix[i][j];
				
		}
		rows[i]=sumrow;
	}
	int revd=0;
	for(int i=0;i<size;i++)
	{
		for(int j=0;j<size;j++)
		{
			cols[i]+=matrix[j][i];
			if(i==j)
			revd+=matrix[i][size-j-1];
		}
	}
	Vector<Integer>a=new Vector<Integer>();
	for(int i=0;i<size;i++)
	{
		if(rows[i]!=sum)
			a.add(i+1);
		if(cols[i]!=sum)
			a.add(-i-1);
	}	
	if(revd!=sum)
		a.add(0);
	if(a.size()==0)
	{
		System.out.println("0");
		return;
	}
	Collections.sort(a);
	System.out.println(a.size());
	for(int i=0;i<a.size();i++)
	System.out.println(a.get(i));
   }
}
