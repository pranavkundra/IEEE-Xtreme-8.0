import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
class Solution
{
	public static void main(String ar[])
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		s.nextLine();
		Hero a[]=new Hero[n];
		for(int i=0;i<n;i++)
		{
			a[i]=new Hero();
			String vals[]=s.nextLine().split(",");
			String wl[]=vals[vals.length-1].split(":");
			int w=Integer.parseInt(wl[0]);
			int l=Integer.parseInt(wl[1]);
			a[i].name=vals[0];
			a[i].fi=(int)Math.floor((double)w*100/(double)(w+l));
			a[i].qi=((double)a[i].fi)*(i+1);
			a[i].type=getType(vals[1]);
		}
		int max=0;
		int icount=0,scount=0,acount=0;
		for(int i=0;i<m;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[j].qi>a[max].qi)
					max=j;
			}
			Hero t=a[i];
			a[i]=a[max];
			a[max]=t;
			System.out.println(a[i].name);
			if(a[i].type==1)
				scount++;
			else if(a[i].type==2)
				icount++;
			else
				acount++;
		}
		System.out.println();
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		System.out.println("This set of heroes:");
		String is=df.format((double)icount*100/m);
		String ss=df.format((double)scount*100/m);
		String as=df.format((double)acount*100/m);

		System.out.println("Contains "+String.format("%.2f",Double.parseDouble(is))+" percentage of Intelligence");
		System.out.println("Contains "+String.format("%.2f",Double.parseDouble(ss))+" percentage of Strength");
		System.out.println("Contains "+String.format("%.2f",Double.parseDouble(as))+" percentage of Agility");

	}
	static int getType(String s)
	{
		if(s.equals("Strength"))
			return 1;
		else if(s.equals("Intelligence"))
			return 2;
		else
			return 3;
	}
}
class Hero
{
	String name;
	int fi;
	double qi;
	int type;
}