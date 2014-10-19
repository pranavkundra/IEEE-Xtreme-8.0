import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int subjects=sc.nextInt();
		int rules=sc.nextInt();
  		sc.nextLine();
		boolean rulebox[][]=new boolean[subjects][subjects];
		for(int i=0;i<rules;i++){
			String p=sc.nextLine();
			String q[]=p.split(" ");
				int k=Integer.parseInt(q[0]);
				int l=Integer.parseInt(q[1]);
				rulebox[k-1][l-1]=true;
			
		}
		for(int i=0;i<rulebox.length;i++)
		{
			//System.out.println(Arrays.toString(rulebox[i]));
		}
	
		Vector<Integer> subjectsdone = new Vector<Integer>();
      
        
        	
		String p=sc.nextLine();
		String q[]=p.split(" ");
		int subjectorder[]=new int[p.size];
		for(int i=0;i<q.length;i++)
		{  			
			subjectorder[i]=Integer.parseInt(q[i])-1;
		}
		boolean flag=true;
over:		for(int i=0;i<subjectorder.length;i++)
		{
			//System.out.println(Arrays.toString(subjectorder));
			int x=subjectorder[i];
			if(i==0)
			{
				int j=0;
				for(j=0;j<subjects;j++)
				{	if(x==j)continue;
					if(rulebox[j][x]==true)
					{	flag=false;
						break over;
					}
					
				}
					
			}
			else
			{
				for(int j=0;j<subjects;j++)
				{	
					
					if(j==x)continue;
					if(rulebox[j][x]==true&&!subjectsdone.contains(j))
					{
						flag=false;
						break over;
					}
				
				}
			}
			subjectsdone.add(x);
			//System.out.println(subjectsdone);
		}
		if(flag)
		System.out.println("YES");
		else
		System.out.println("NO");

	}
}
