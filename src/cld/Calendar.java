package cld;

import java.util.Scanner;

public class Calendar 
{
	public static void main(String[] argv) 
	{

		int firstSpace = 1;//1るフぱ计ボ1る1ら琍戳
		int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12るぱ计
		int year;
		int month;

		Scanner in = new Scanner(System.in);

		System.out.print("Please input year:");
		year = in.nextInt();
		System.out.print("Please input month(1-12):");
		month = in.nextInt();

		if(0<month && month<13) //耞琌Α岿粇
		{
			//耞赣2るぱ计
			if(isLeapYear(year)) monthDay[1] = 29;

			//т赣1るフぱ计﹁じ1900膀非
			for(int tempYear=1900;tempYear<year;tempYear++)
			{
				//(フぱ计+赣ぱ计)%7=フぱ计
				if(isLeapYear(tempYear))
					firstSpace = (firstSpace+366)%7;
				else
					firstSpace = (firstSpace+365)%7;
			}

			int spaceDay[] = {firstSpace,0,0,0,0,0,0,0,0,0,0,0};//1-12るフぱ计

			//璸衡赣–るフぱ计–るフぱ计单(玡るフぱ计+赣るぱ计)%7緇计
			for(int i=0;i<month-1;i++)
			{
				spaceDay[i+1] = (spaceDay[i]+monthDay[i])%7;
			}
			show(year,month,spaceDay[month-1],monthDay[month-1]);
		}
		else 	
		{
			System.out.println("Format error!");
		}
	}


	//耞赣琌秥
	public static boolean isLeapYear(int year)
	{
		return ((year%400==0)||((year%4==0) && (year%100!=0)));
	}

	//ら句
	public static void show(int year,int month,int spaceDay,int monthDay)
	{
		System.out.println("-----------"+year+"/"+ month+"-----------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

		//赣るフぱ计
		for(int i=0;i<spaceDay;i++) 
		{
			System.out.printf("%4s"," ");
		}
		//赣るぱ计
		for(int day=1;day<=monthDay;day++) 
		{
			System.out.printf("%4d",day);
			//赣ら%7緇计穦单材搂传︽ら(=7-フぱ计)
			if(day%7 == (7-spaceDay)%7)
				System.out.println();
		}

	}


}