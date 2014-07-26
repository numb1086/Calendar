package cld;

import java.util.Scanner;

public class Choice 
{
	private int mode;
	
	public Choice(int mode)
	{
		this.mode = mode;
	}
	
	public void choice(Scanner in)
	{
		MyCalendar myCal = new MyCalendar();
		int year,month,day;
		
		switch(mode)
		{
			case 1: //判斷是否為閏年
				System.out.print("請輸入年(>0): ");
				year = in.nextInt();
				myCal.showLeapYear(year);
				break;
			case 2: //輸入年月傳回有幾天
				System.out.print("請輸入年(>0): ");
				year = in.nextInt();
				System.out.print("請輸入月(1-12): ");
				month = in.nextInt();
				myCal.showDays(year,month);
				break;
			case 3: //輸入年月日傳回星期幾
				System.out.print("請輸入年(>0): ");
				year = in.nextInt();
				System.out.print("請輸入月(1-12): ");
				month = in.nextInt();
				System.out.print("請輸入日: ");
				day = in.nextInt();
				myCal.showWeekDay(year,month,day);
				break;
			case 4: //輸入年月傳回整月
				System.out.print("請輸入年(>0): ");
				year = in.nextInt();
				System.out.print("請輸入月(1-12): ");
				month = in.nextInt();
				myCal.showCalendar(year, month);
				break;
			case 5: //輸入年傳回有幾個六日
				System.out.print("請輸入年(>0): ");
				year = in.nextInt();
				myCal.showWeekend(year);
				break;
			default:
				System.out.println("請重新選擇!");
		}
				
	}
}
