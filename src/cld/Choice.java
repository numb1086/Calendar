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
			case 1: //�P�_�O�_���|�~
				System.out.print("�п�J�~: ");
				year = in.nextInt();
				if(year==0) { //�P�_�O�_�榡���~
					System.out.println("��J�榡���~");
					break;
				}
				if(myCal.isLeapYear(year))
					System.out.println(year + "�~�O�|�~");
				else 
					System.out.println(year + "�~���O�|�~");
				break;
			case 2: //��J�~��Ǧ^���X��
				System.out.print("�п�J�~: ");
				year = in.nextInt();
				System.out.print("�п�J��: ");
				month = in.nextInt();
				if(year==0 || 0==month || month>12) { //�P�_�O�_�榡���~
					System.out.println("��J�榡���~");
					break;
				}
				System.out.print(year+" �~ "+month+" ��");
				System.out.println(" �@�� "+myCal.countDays(year,month)+" ��");
				break;
			case 3: //��J�~���Ǧ^�P���X
				int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12�몺�Ѽ�
				String[] week = {"��","�@","�G","�T","�|","��","��"};
				System.out.print("�п�J�~: ");
				year = in.nextInt();
				if(myCal.isLeapYear(year)) monthDay[1] = 29;
				System.out.print("�п�J��: ");
				month = in.nextInt();
				System.out.print("�п�J��: ");
				day = in.nextInt();
				if(year==0 || 0==month || month>12 || day>monthDay[month-1]) { //�P�_�O�_�榡���~
					System.out.println("��J�榡���~");
					break;
				}
				System.out.print(year+"�~"+month+"��" + day+"��");
				System.out.println("�O�P��"+ week[myCal.countWeekDay(year,month,day)]);
				break;
			case 4: //��J�~��Ǧ^���
				System.out.print("�п�J�~: ");
				year = in.nextInt();
				System.out.print("�п�J��: ");
				month = in.nextInt();
				if(year==0 || 0==month || month>12) { //�P�_�O�_�榡���~
					System.out.println("��J�榡���~");
					break;
				}
				myCal.showCalendar(year, month);
				break;
			case 5: //��J�~�Ǧ^���X�Ӥ���
				System.out.print("�п�J�~: ");
				year = in.nextInt();
				if(year==0) { //�P�_�O�_�榡���~
					System.out.println("��J�榡���~");
					break;
				}
				myCal.showWeekend(year);
				break;
			default:
				System.out.println("�Э��s���!");
		}
				
	}
}
