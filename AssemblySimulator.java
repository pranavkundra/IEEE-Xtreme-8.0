import java.io.*;
class Solution
{
	public static void main(String ar[])
	{
		try
		{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			int n=Integer.parseInt(br.readLine(),16);
			System.out.println(n);
			int a[]=new int[n];
			String str;
			while((str=br.readLine()).length()!=0)
			{
				String codes[]=str.split(" ");
				int index=0;
				if(codes.length==3)
					index=1;
				else
				{
					if(codes[index].equals("PRINT"))
					{
						String operands[]=codes[index+1].split(",");
						if(operands.length==1)
						{
							System.out.print(a[Integer.parseInt(codes[index+1],16)]);
							System.out.print("");
						}
						else
						{
							int low=Integer.parseInt(operands[0],16);
							int high=Integer.parseInt(operands[1],16);
							for(int i=low;i<high;i++)
								System.out.print(a[i]+" ");
							System.out.print(a[high]);
						}
					}
					else if(codes[0].equals("MOVE"))
					{

					}
				}

			}
		}catch(Exception e){}
	}
}