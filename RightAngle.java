import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++)
        {
            double a=s.nextInt();
            double b=s.nextInt();
            double x1,y1,x2,y2;
		boolean flag=false;
		for(double angle=0;angle<=180;angle+=0.005)
		{
			x1=b*Math.cos(angle);
			y1=b*Math.sin(angle);
			x2=a*Math.cos(90+angle);
			y2=a*Math.sin(90+angle);
			if(approx(Math.abs(x1*x1+y1*y1-b*b))!=0)
				continue;
			if(approx(Math.abs(x2*x2+y2*y2-a*a))!=0)
				continue;
			if(approx(Math.abs((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)-(a*a+b*b)))!=0)
			     continue;
            flag=true;
            break;

		}
		if(flag)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
        }
	}
	static double approx(double a)
	{
		double d=a-Math.floor(a);
		if(d<0.89)
			return 0;
		else
			return 1;
	}
}