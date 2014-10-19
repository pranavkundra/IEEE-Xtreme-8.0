import java.util.*;
class Solution
{
	static long mincost=Long.MAX_VALUE;
	static int N;
	static long a[][];
	public static void main(String ar[])
	{
		Scanner s=new Scanner(System.in);
		N=s.nextInt();
		a=new long[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				a[i][j]=s.nextLong();
		for(int i=0;i<N;i++)
		{
			long t=pipe(i,0,0,-2);
			if(t<mincost)
				mincost=t;
		}
		System.out.println(mincost);
	}
	static long pipe(int row,int col,long cost,int prev)
	{
		if(col==N)
		{
			return cost;
		}
		long c=cost+sum(row,col,row);
		if(c<mincost)
		{
			long tc=pipe(row,col+1,c,-2);
			if(tc<mincost)
				mincost=tc;
		}
		for(int diff=1;diff<N;diff++)
		{
			boolean flag=false;
			if((prev!=1)&&(row-diff>0))
			{
				flag=true;
				long addcost=cost+sum(row,col,row-diff);
				if(addcost>mincost)
					continue;
				long tc=pipe(row-diff,col+1,addcost,-1);
				if(tc<mincost)
					mincost=tc;
			}
			if((prev!=-1)&&(row+diff<N))
			{
				flag=true;
				long addcost=cost+sum(row,col,row+diff);
				if(addcost>mincost)
					continue;
				long tc=pipe(row+diff,col+1,addcost,1);
				if(tc<mincost)
					mincost=tc;
			}
			if(!flag)
				break;
		}
		return mincost;
	}
	static long sum(int row,int col,int d)
	{
		int start=Math.min(row,d);
		long sum=0;
		for(int i=start;i<=Math.max(row,d);i++)
		{
			sum+=a[i][col];
		}
		return sum;
	}
}