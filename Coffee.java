import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
		int w=s.nextInt();
		int h=s.nextInt();
		Corner a[][]=new Corner[h][w];
		s.nextLine();
		for(int i=0;i<h;i++)
		{
			String line=s.nextLine();
			String vals[]=line.split("\\*");
			for(int j=0;j<w;j++)
			{
				a[i][j]=new Corner(vals[j]);
			}
		}
		for(int i=0;i<7;i++)
		{
			s.nextLine();
			for(int j=0;j<h;j++)
			{
				String line=s.nextLine();
				String vals[]=line.split("\\*");
				for(int k=0;k<w;k++)
				{
					a[j][k].nsold[i]=Integer.parseInt(vals[k]);
					if(a[j][k].nshops==0)
						a[j][k].dailyinc[i]=a[j][k].nsold[i];
					else if(a[j][k].nshops==3)
						a[j][k].dailyinc[i]=0;
					else
						a[j][k].dailyinc[i]=((double)a[j][k].nsold[i])/((double)a[j][k].nshops);
				}
			}
		}
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<h;j++)
			{
				for(int k=0;k<w;k++)
				{
					if(a[j][k].nshops==3&&a[j][k].nsold[i]>=5)
					{
						if(j-1>=0)
						{
							if(k-1>=0)
							{
								if(a[j-1][k-1].nshops!=3)
									a[j-1][k-1].dailyinc[i]++;
							}
							if(k+1<w)
							{
								if(a[j-1][k+1].nshops!=3)
									a[j-1][k+1].dailyinc[i]++;
							}
						}
						if(j+1<h)
						{
							if(k-1>=0)
							{
								if(a[j+1][k-1].nshops!=3)
								a[j+1][k-1].dailyinc[i]++;
							}
							if(k+1<w)
							{
								if(a[j+1][k+1].nshops!=3)
								a[j+1][k+1].dailyinc[i]++;
							}
						}
					}
				}
			}
		}
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<h;j++)
			{
				for(int k=0;k<w;k++)
				{
					if(a[j][k].dailyinc[i]<20)
						a[j][k].dailyinc[i]=0;
				}
			}
		}
		int tx=0,ty=0,max=-1;
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				int sum=0;
				for(int k=0;k<7;k++)
				{
					sum+=a[i][j].dailyinc[k];
				}
             	if(sum>max)
				{
					max=sum;
					tx=i;
					ty=j;
				}
			}
		}
		System.out.println((tx+1)+" "+(ty+1));
    }
}
class Corner
{
	int nshops;
	int nsold[]=new int[7];
	double dailyinc[]=new double[7];
	Corner(String t)
	{
		if(t.equals("-"))
			nshops=0;
		else if(t.equals("L"))
			nshops=1;
		else if(t.equals("M"))
			nshops=2;
		else
			nshops=3;

	}
}