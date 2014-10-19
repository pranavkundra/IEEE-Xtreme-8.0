import java.util.Scanner;
import java.util.Arrays;
class Solution
{
	public static void main(String ar[])
	{
		Scanner s=new Scanner(System.in);
		while(true)
		{
		int n=Integer.parseInt(s.nextLine());
		if(n==0)
			break;
		String s1[]=s.nextLine().split(" ");
		String s2[]=s.nextLine().split(" ");
		int M[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1[i-1].equals(s2[j-1]))
				{
					M[i][j]=M[i-1][j-1]+2*getVal(s1[i-1]);
					int ti=i-1;
					int max=0;
					for(int tj=0;tj<j;tj++)
					{
						if(M[ti][tj]>max)
							max=M[ti][tj];
					}
					M[i][j]=max+2*getVal(s1[i-1]);
				}
				else if(s1[i-1].equals("R"))
				{
					int ti=i-1;
					int max=0;
					for(int tj=0;tj<j;tj++)
					{
						if(M[ti][tj]>max)
							max=M[ti][tj];
					}
					M[i][j]=max+2*getVal(s2[j-1]);
				}
				else if(s2[j-1].equals("R"))
				{
					int tj=j-1;
					int max=0;
					for(int ti=0;ti<i;ti++)
					{
						if(M[ti][tj]>max)
							max=M[ti][tj];
					}
					M[i][j]=max+2*getVal(s1[i-1]);
				}
				else
					M[i][j]=Math.max(M[i-1][j],M[i][j-1]);
			}
		}
	//	for(int i=0;i<=n;i++)
	//		System.out.println(Arrays.toString(M[i]));
		System.out.println(M[n][n]);
		}
	}
	static int getVal(String s)
	{
		if(s.equals("R"))
			return 50;
		else if(s.equals("A"))
			return 20;
		else if(s.equals("J")||s.equals("Q")||s.equals("K"))
			return 15;
		else if(s.equals("T"))
			return 10;
		else
			return Integer.parseInt(s);
	}
}