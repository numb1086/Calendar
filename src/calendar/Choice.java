/**************************************************************************
 * FileName			[ Choice.java ]
 * PackageName			[ calendar ]
 * JavaProjectName		[ Calendar ]
 * Synopsis			[ This file is used to select MyCalendar methods ]
 * Author			[ Yong-Ting (Tony) Wu ]
 * Copyright			[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
***************************************************************************/

package calendar;

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
			case 1: //�P�_�O�_���|�~
				System.out.print("�п��J�~(>0): ");
				year = in.nextInt();
				myCal.showLeapYear(year);
				break;
			case 2: //���J�~���Ǧ^���X��
				System.out.print("�п��J�~(>0): ");
				year = in.nextInt();
				System.out.print("�п��J��(1-12): ");
				month = in.nextInt();
				myCal.showDays(year,month);
				break;
			case 3: //���J�~�����Ǧ^�P���X
				System.out.print("�п��J�~(>0): ");
				year = in.nextInt();
				System.out.print("�п��J��(1-12): ");
				month = in.nextInt();
				System.out.print("�п��J��: ");
				day = in.nextInt();
				myCal.showWeekDay(year,month,day);
				break;
			case 4: //���J�~���Ǧ^����
				System.out.print("�п��J�~(>0): ");
				year = in.nextInt();
				System.out.print("�п��J��(1-12): ");
				month = in.nextInt();
				myCal.showCalendar(year, month);
				break;
			case 5: //���J�~�Ǧ^���X�Ӥ���
				System.out.print("�п��J�~(>0): ");
				year = in.nextInt();
				myCal.showWeekend(year);
				break;
			default:
				System.out.println("�Э��s����!");
		}
				
	}
}
