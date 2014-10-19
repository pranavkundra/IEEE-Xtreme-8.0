import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	Scanner sc=new Scanner(System.in);
	String input=sc.nextLine();
	
	int index=input.indexOf(' ');
	int pizzacount=Integer.parseInt(input.substring(0,index));
	String rem=input.substring(index+1);
String space[]=rem.split(" ");	
	int cal=0;
	for(int i=0;i<space.length;i++)
	{
		int k=Integer.parseInt(space[i]);
		i++;
		String a[]=space[i].split(",");
		int test=0;
		for(int p=0;p<a.length;p++){
			test+=check(a[p]);	
		}
		cal+=(test+270)*k;
    }

System.out.println("The total calorie intake is "+cal);

	}
	static int check(String x){
	if(x.equals("Anchovies"))return 50;
	else if(x.equals("Artichoke"))return 60;
	else if(x.equals("Bacon"))return 92;
	else if(x.equals("Broccoli"))return 24;
	else if(x.equals("Cheese"))return 80;
	else if(x.equals("Chicken"))return 30;
	else if(x.equals("Feta"))return 99;
	else if(x.equals("Garlic"))return 8;
	else if(x.equals("Ham"))return 46;
	else if(x.equals("Jalapeno"))return 5;
	else if(x.equals("Meatballs"))return 120;
	else if(x.equals("Mushrooms"))return 11;
	else if(x.equals("Olives"))return 25;
	else if(x.equals("Onions"))return 11;
	else if(x.equals("Pepperoni"))return 80;
	else if(x.equals("Peppers"))return 6;
	else if(x.equals("Pineapple"))return 21;
	else if(x.equals("Ricotta"))return 108;
	else if(x.equals("Sausage"))return 115;
	else if(x.equals("Spinach"))return 18;
	else if(x.equals("Tomatoes"))return 14;
else return 0;
}
}
