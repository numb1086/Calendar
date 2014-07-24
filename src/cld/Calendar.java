package cld;

import java.util.Scanner;

public class Calendar 
{
	public static void main(String[] argv) 
	{
		int year,month,choice;
		Scanner in = new Scanner(System.in);
		//輸入年和月
		System.out.println("1.判斷是否為閏年  2.輸入年月傳回有幾天  3.輸入年月日傳回星期幾 "
				+ "4.輸入年月傳回整月  5.輸入年 傳回有幾個六日");
		System.out.print("請選擇:");
		choice = in.nextInt();
		switch(choice)
		{
			case 1:
				System.out.print("Please input year:");
				year = in.nextInt();
				MyCalendar myLeap = new MyCalendar(year);
				if(myLeap.isLeapYear(year))
					System.out.println(year + "年是閏年");
				else 
					System.out.println(year + "年不是閏年");
		}
/*		System.out.print("Please input month(1-12):");
		month = in.nextInt();
		//建立一個myCalendar的物件
		MyCalendar myCal = new MyCalendar(year,month);
		//判斷是否是閏年
		myCal.isLeapYear(year);
		myCal.getCalendar();*/
	}
}

class MyCalendar
{	
	private int year;
	private int month;
	
	public MyCalendar(int year,int month)
	{
		this.year = year;
		this.month = month;
	}
	
	public MyCalendar(int year)
	{
		this.year = year;
	}
	public void getCalendar()
	{
		int firstSpace = 1; //1月的空白天數，表示1月1日為星期一
		int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12月的天數
		
		if(0<month && month<13) //判斷是否格式錯誤
		{
			//判斷該年2月天數
			if(isLeapYear(year)) monthDay[1] = 29;
			
			//找出該年1月的空白天數，以西元1年為基準
			for(int tempYear=1;tempYear<year;tempYear++)
			{
				//(空白天數+該年天數)%7 = 下一年1月的空白天數
				if(isLeapYear(tempYear))
					firstSpace = (firstSpace+366)%7;
				else
					firstSpace = (firstSpace+365)%7;
			}
			
			int spaceDay[] = {firstSpace,0,0,0,0,0,0,0,0,0,0,0};//1-12月的空白天數
			
			//計算至該年月份的空白天數，每個月的空白天數等於(前個月的空白天數+前個月天數)%7的餘數
			for(int i=0;i<month-1;i++)
				spaceDay[i+1] = (spaceDay[i]+monthDay[i])%7;
			
			//印出日曆
			show(spaceDay[month-1],monthDay[month-1]);
		}
		else 	
		{
			System.out.println("Format error!");
		}
	}
	
	//判斷該年是否為閏年
	public boolean isLeapYear(int year)
	{
		return ((year%400==0)||((year%4==0) && (year%100!=0)));
	}
	
	//印出日曆
	private void show(int spaceDay,int monthDay)
	{
		System.out.println("\n-----------"+year+"/"+ month+"-----------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		//先印出該月空白天數
		for(int i=0;i<spaceDay;i++) 
			System.out.printf("%4s"," ");
		
		//在印出該月天數
		for(int day=1;day<=monthDay;day++) 
		{
			System.out.printf("%4d",day);
			//該日%7的餘數會等於第一個禮拜換行的日子(=7-空白天數)
			if(day%7 == (7-spaceDay)%7) //spaceDay可能等於0所以要%7
				System.out.println();
		}
	}
}
