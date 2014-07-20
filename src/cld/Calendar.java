package cld;

import java.util.Scanner;

public class Calendar 
{
	public static void main(String[] argv) 
	{
		int year,month;
		Scanner in = new Scanner(System.in);
		//��J�~�M��
		System.out.print("Please input year:");
		year = in.nextInt();
		System.out.print("Please input month(1-12):");
		month = in.nextInt();
		//�إߤ@��myCalendar������
		myCalendar mCal = new myCalendar(year,month);
		mCal.getCalendar();
	}
}

class myCalendar
{	
	private int year;
	private int month;
	
	public myCalendar(int year,int month)
	{
		this.year = year;
		this.month = month;
	}
	
	public void getCalendar()
	{
		int firstSpace = 1; //1�몺�ťդѼơA���1��1�鬰�P���@
		int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12�몺�Ѽ�
		
		if(0<month && month<13) //�P�_�O�_�榡���~
		{
			//�P�_�Ӧ~2��Ѽ�
			if(isLeapYear(year)) monthDay[1] = 29;
			
			//��X�Ӧ~1�몺�ťդѼơA�H�褸1�~�����
			for(int tempYear=1;tempYear<year;tempYear++)
			{
				//(�ťդѼ�+�Ӧ~�Ѽ�)%7 = �U�@�~1�몺�ťդѼ�
				if(isLeapYear(tempYear))
					firstSpace = (firstSpace+366)%7;
				else
					firstSpace = (firstSpace+365)%7;
			}
			
			int spaceDay[] = {firstSpace,0,0,0,0,0,0,0,0,0,0,0};//1-12�몺�ťդѼ�
			
			//�p��ܸӦ~������ťդѼơA�C�Ӥ몺�ťդѼƵ���(�e�Ӥ몺�ťդѼ�+�e�Ӥ�Ѽ�)%7���l��
			for(int i=0;i<month-1;i++)
				spaceDay[i+1] = (spaceDay[i]+monthDay[i])%7;
			
			//�L�X���
			show(spaceDay[month-1],monthDay[month-1]);
		}
		else 	
		{
			System.out.println("Format error!");
		}
	}
	
	//�P�_�Ӧ~�O�_���|�~
	private boolean isLeapYear(int year)
	{
		return ((year%400==0)||((year%4==0) && (year%100!=0)));
	}
	
	//�L�X���
	private void show(int spaceDay,int monthDay)
	{
		System.out.println("\n-----------"+year+"/"+ month+"-----------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		//���L�X�Ӥ�ťդѼ�
		for(int i=0;i<spaceDay;i++) 
		{
			System.out.printf("%4s"," ");
		}
		//�b�L�X�Ӥ�Ѽ�
		for(int day=1;day<=monthDay;day++) 
		{
			System.out.printf("%4d",day);
			//�Ӥ�%7���l�Ʒ|����Ĥ@��§�����檺��l(=7-�ťդѼ�)
			if(day%7 == (7-spaceDay)%7) //spaceDay�i�൥��0�ҥH�n%7
				System.out.println();
		}
	}
}
