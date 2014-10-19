import java.io.*;
import java.util.ArrayList;
class Solution
{
	public static void main(String ar[])	{
		try{

		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int k=Integer.parseInt(((char)br.read())+"");
		br.read();
		ArrayList<String> sol=new ArrayList<String>();
		String s1=br.readLine();
		sol.add(s1);
		String vals[]=s1.split(" ");
		long maxlen=s1.length();
		int last=0;
		for(int j=0;j<k;j++)
		{
			int curr=Integer.parseInt(vals[0]),count=1;
			StringBuffer sb=new StringBuffer();
			for(int i=1;i<vals.length;i++)
			{
				int t=Integer.parseInt(vals[i]);
				if(curr==t)
					count++;
				else
				{
					sb.append(count+" "+curr+" ");
					curr=t;
					count=1;
				}
			}
			sb.append(count+" "+curr);
			String str=sb.toString();
			vals=str.split(" ");
			//System.out.println(str);
			sol.add(str);
			if(str.length()>maxlen)
				maxlen=str.length();
			if(j==k-1)
				last=vals.length;
		}
		for(int i=0;i<sol.size();i++)
		{
			String t=sol.get(i);
			int l=t.length();
			int pad=(int)(maxlen-l)/2;
			for(int j=0;j<pad;j++)
			{
				t="."+t+".";
			}
			if(2*pad+l!=maxlen)
			{
				t="."+t;
			}
			System.out.println(t);

		}
		System.out.println(last);
		}catch(Exception e){}
	}
}