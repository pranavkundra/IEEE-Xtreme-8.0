import java.util.Scanner;
class Solution
{
	public static void main(String ar[])
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int a[][]=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				a[i][j]=s.nextInt();
		boolean bigflag=true;
		String s1="";
		int count=0;
		for(int i=0;i<n-1;i++)
		{
			boolean flag=false;
			for(int j=0;j<m;j++)
			{
				if(a[i][j]!=a[i+1][j]&&a[i+1][j]==a[n-1][j])
				{
					flag=true;
					break;
				}
			}
			if(!flag)
			{
				bigflag=false;
				s1+="i1="+(i+1)+"\n";
				count++;
			}
		}
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n-1;j++)
			{
				boolean flag=false;
				for(int k=0;k<m;k++)
				{
					if((a[i][k]!=a[i+1][k])&&(a[i+1][k]==a[j][k])&&(a[j][k]==a[j+1][k]))
					{
						flag=true;
						break;
					}
				}
				if(!flag)
				{
					bigflag=false;
					s1+="i1="+(i+1)+" "+"i2="+(j+1)+"\n";
					count++;
				}
			}
		}
		if(bigflag)
			System.out.println(0);
		else
		{
			System.out.println(count);
			System.out.print(s1);
		}

	}
}