package cld;

import java.util.Scanner;

public class Choice 
{
	private int mode;
	
	public Choice(int mode)
	{
		this.mode = mode;
	}
	
	public void choice()
	{
		Scanner in = new Scanner(System.in);
		MyCalendar myCal = new MyCalendar();
		int year,month,day;
		
		switch(mode)
		{
			case 1: //判斷是否為閏年
				System.out.print("請輸入年: ");
				year = in.nextInt();
				if(year==0) { //判斷是否格式錯誤
					System.out.println("輸入格式錯誤");
					break;
				}
				if(myCal.isLeapYear(year))
					System.out.println(year + "年是閏年");
				else 
					System.out.println(year + "年不是閏年");
				break;
			case 2: //輸入年月傳回有幾天
				System.out.print("請輸入年: ");
				year = in.nextInt();
				System.out.print("請輸入月: ");
				month = in.nextInt();
				if(year==0 || 0==month || month>12) { //判斷是否格式錯誤
					System.out.println("輸入格式錯誤");
					break;
				}
				System.out.print(year+" 年 "+month+" 月");
				System.out.println(" 共有 "+myCal.countDays(year,month)+" 天");
				break;
			case 3: //輸入年月日傳回星期幾
				int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12月的天數
				String[] week = {"日","一","二","三","四","五","六"};
				System.out.print("請輸入年: ");
				year = in.nextInt();
				if(myCal.isLeapYear(year)) monthDay[1] = 29;
				System.out.print("請輸入月: ");
				month = in.nextInt();
				System.out.print("請輸入日: ");
				day = in.nextInt();
				if(year==0 || 0==month || month>12 || day>monthDay[month-1]) { //判斷是否格式錯誤
					System.out.println("輸入格式錯誤");
					break;
				}
				System.out.print(year+"年"+month+"月" + day+"日");
				System.out.println("是星期"+ week[myCal.countWeekDay(year,month,day)]);
				break;
			case 4: //輸入年月傳回整月
				System.out.print("請輸入年: ");
				year = in.nextInt();
				System.out.print("請輸入月: ");
				month = in.nextInt();
				if(year==0 || 0==month || month>12) { //判斷是否格式錯誤
					System.out.println("輸入格式錯誤");
					break;
				}
				myCal.showCalendar(year, month);
				break;
			case 5: //輸入年傳回有幾個六日
				System.out.print("請輸入年: ");
				year = in.nextInt();
				if(year==0) { //判斷是否格式錯誤
					System.out.println("輸入格式錯誤");
					break;
				}
				myCal.showWeekend(year);
				break;
			default:
				System.out.println("請重新選擇!");
		}
				
	}
}
