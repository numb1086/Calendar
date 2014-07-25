package cld;


public class MyCalendar 
{
	private int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12るぱ计
	
	//耞赣琌秥
	public boolean isLeapYear(int year)
	{
		return ((year%400==0)||((year%4==0) && (year%100!=0)));
	}
	
	//耞赣赣るフぱ计
	public int firstSpace(int year,int month)
	{
		int firstSpace = 1; //﹁じ11るフぱ计ボ1る1ら琍戳	
		//耞赣2るぱ计
		if(isLeapYear(year)) monthDay[1] = 29;
		//т赣1るフぱ计﹁じ1膀非
		for(int tempYear=1;tempYear<year;tempYear++)
		{
			//(フぱ计+赣ぱ计)%7 = 1るフぱ计
			if(isLeapYear(tempYear))
				firstSpace = (firstSpace+366)%7;
			else
				firstSpace = (firstSpace+365)%7;
		}
		
		//赣1-12るフぱ计
		int spaceDay[] = {firstSpace,0,0,0,0,0,0,0,0,0,0,0};
		//璸衡赣るフぱ计–るフぱ计单(玡るフぱ计+玡るぱ计)7緇计
		for(int i=0;i<month-1;i++)
			spaceDay[i+1] = (spaceDay[i]+monthDay[i])%7;
		
		return spaceDay[month-1];
	}
	
	public int countDays(int year,int month)
	{
		//耞赣2るぱ计
		if(isLeapYear(year)) monthDay[1] = 29;
		
		return monthDay[month-1];
	}
	
	public int countWeekDay(int year,int month,int day)
	{
		int weekDay;
		//琍戳碭 = (赣るフぱ计+赣腹籔1腹畉禯)7緇计
		weekDay = (firstSpace(year,month)+ day-1)%7;
		return weekDay;
	}
	
	//ら句
	public void showCalendar(int year,int month)
	{
		int spaceDay = firstSpace(year,month);
		
		System.out.println("\n----------"+year+""+ month+"る"+"-----------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		//赣るフぱ计
		for(int i=0;i<spaceDay;i++) 
			System.out.printf("%4s"," ");
		
		//赣るぱ计
		for(int day=1;day<=monthDay[month-1];day++) 
		{
			System.out.printf("%4d",day);
			//赣ら%7緇计穦单材搂传︽ら(=7-フぱ计)
			if(day%7 == (7-spaceDay)%7) //spaceDay单0┮璶%7
				System.out.println();
		}
	}
	
	public void showWeekend(int year)
	{
		int countSat = 0;
		int countSun = 0;
		//耞赣2るぱ计
		if(isLeapYear(year)) monthDay[1] = 29;
		//璸衡Τ碭せら
		for(int month=1;month<=12;month++)
		{
			for(int day=1;day<=monthDay[month-1];day++)
			{
				if(countWeekDay(year,month,day)==6) countSat++;
				if(countWeekDay(year,month,day)==0) countSun++;
			}
		}	
		System.out.println(year +"Τ"+countSat+"琍戳せ" + countSun+"琍戳ら");
	}
}
