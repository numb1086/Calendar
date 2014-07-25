package cld;


public class MyCalendar 
{
	private int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12月的天數
	
	//判斷該年是否為閏年
	public boolean isLeapYear(int year)
	{
		return ((year%400==0)||((year%4==0) && (year%100!=0)));
	}
	
	//判斷該年該月的空白天數
	public int firstSpace(int year,int month)
	{
		int firstSpace = 1; //西元1年1月的空白天數，表示1月1日為星期一	
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
		
		//該年1-12月的空白天數
		int spaceDay[] = {firstSpace,0,0,0,0,0,0,0,0,0,0,0};
		//計算至該年月份的空白天數，每個月的空白天數等於(前個月的空白天數+前個月天數)取7的餘數
		for(int i=0;i<month-1;i++)
			spaceDay[i+1] = (spaceDay[i]+monthDay[i])%7;
		
		return spaceDay[month-1];
	}
	
	//印出該年該月天數
	public int countDays(int year,int month)
	{
		//判斷該年2月天數
		if(isLeapYear(year)) monthDay[1] = 29;
		
		return monthDay[month-1];
	}
	
	//印出該年該月該日星期幾
	public int countWeekDay(int year,int month,int day)
	{
		int weekDay;
		//星期幾 = (該月空白天數+該號與1號的差距)取7的餘數
		weekDay = (firstSpace(year,month)+ day-1)%7;
		return weekDay;
	}
	
	//印出日曆
	public void showCalendar(int year,int month)
	{
		int spaceDay = firstSpace(year,month);
		
		System.out.println("\n----------"+year+"年"+ month+"月"+"-----------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		//先印出該月空白天數
		for(int i=0;i<spaceDay;i++) 
			System.out.printf("%4s"," ");
		
		//在印出該月天數
		for(int day=1;day<=monthDay[month-1];day++) 
		{
			System.out.printf("%4d",day);
			//該日%7的餘數會等於第一個禮拜換行的日子(=7-空白天數)
			if(day%7 == (7-spaceDay)%7) //spaceDay可能等於0所以要%7
				System.out.println();
		}
	}
	
	//印出該年有幾個六日
	public void showWeekend(int year)
	{
		int countSat = 0;
		int countSun = 0;
		//判斷該年2月天數
		if(isLeapYear(year)) monthDay[1] = 29;
		//計算有幾個六日
		for(int month=1;month<=12;month++)
		{
			for(int day=1;day<=monthDay[month-1];day++)
			{
				if(countWeekDay(year,month,day)==6) countSat++;
				if(countWeekDay(year,month,day)==0) countSun++;
			}
		}	
		System.out.println(year +"年共有"+countSat+"個星期六" + countSun+"個星期日");
	}
}
