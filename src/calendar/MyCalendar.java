/**************************************************************************
 * FileName			[ MyCalendar.java ]
 * PackageName			[ calendar ]
 * JavaProjectName		[ Calendar ]
 * Synopsis			[ This file defines the methods to show some
 * 				  information about calendar]
 * Author			[ Yong-Ting (Tony) Wu ]
 * Copyright			[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
***************************************************************************/

package calendar;

public class MyCalendar 
{
	private int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12�몺�Ѽ�
	
	//�P�_�Ӧ~�O�_���|�~
	private boolean isLeapYear(int year)
	{
		return ((year%400==0)||((year%4==0) && (year%100!=0)));
	}
	
	//�^�ǸӦ~�Ӥ몺�ťդѼ�
	private int getSpaceDay(int year,int month)
	{
		int firstSpace = 1; //�褸1�~1�몺�ťդѼơA����1��1�鬰�P���@	
		//�P�_�Ӧ~2���Ѽ�
		if(isLeapYear(year)) monthDay[1] = 29;
		//���X�Ӧ~1�몺�ťդѼơA�H�褸1�~������
		for(int tempYear=1;tempYear<year;tempYear++)
		{
			//(�ťդѼ�+�Ӧ~�Ѽ�)%7 = �U�@�~1�몺�ťդѼ�
			if(isLeapYear(tempYear)) firstSpace = (firstSpace+366)%7;
			else firstSpace = (firstSpace+365)%7;
		}
		//�Ӧ~1-12�몺�ťդѼ�
		int spaceDay[] = {firstSpace,0,0,0,0,0,0,0,0,0,0,0};
		//�p���ܸӦ~�������ťդѼơA�C�Ӥ몺�ťդѼƵ���(�e�Ӥ몺�ťդѼ�+�e�Ӥ��Ѽ�)��7���l��
		for(int i=0;i<month-1;i++)
			spaceDay[i+1] = (spaceDay[i]+monthDay[i])%7;
		return spaceDay[month-1];
	}
	
	//�L�X�O�_���|�~
	public void showLeapYear(int year)
	{
		if(year==0) { //�P�_�O�_�榡���~
			System.out.println("���J�榡���~");
		}else{
			if(isLeapYear(year)) System.out.println(year + "�~�O�|�~");
			else  System.out.println(year + "�~���O�|�~");
		}
	}
	
	//�L�X�Ӧ~�Ӥ��Ѽ�
	public void showDays(int year,int month)
	{
		if(year==0 || 0==month || month>12) { //�P�_�O�_�榡���~
			System.out.println("���J�榡���~");
		}else {
			//�P�_�Ӧ~2���Ѽ�
			if(isLeapYear(year)) monthDay[1] = 29;
			System.out.print(year+" �~ "+month+" ��");
			System.out.println(" �@�� "+ monthDay[month-1]+ " ��");
		}
	}
	
	//�L�X�Ӧ~�Ӥ��Ӥ��P���X
	public void showWeekDay(int year,int month,int day)
	{
		//�P�_�Ӧ~2���Ѽ�
		if(isLeapYear(year)) monthDay[1] = 29;
		//�P�_�O�_�榡���~
		if(year==0 || 0==month || month>12 || day>monthDay[month-1]) { 
			System.out.println("���J�榡���~");
		}else{
			String[] week = {"��","�@","�G","�T","�|","��","��"};
			//�P���X = (�Ӥ��ťդѼ�+�Ӹ��P1�����t�Z)��7���l��
			int weekDay = (getSpaceDay(year,month)+day-1)%7;
			System.out.print(year+"�~"+month+"��" + day+"��");
			System.out.println("�O�P��"+ week[weekDay]);
		}
	}
	
	//�L�X����
	public void showCalendar(int year,int month)
	{
		if(year==0 || 0==month || month>12) { //�P�_�O�_�榡���~
			System.out.println("���J�榡���~");
		}else{
			int spaceDay = getSpaceDay(year,month);
			
			System.out.println("\n----------"+year+"�~"+ month+"��"+"-----------");
			System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
			//���L�X�Ӥ��ťդѼ�
			for(int i=0;i<spaceDay;i++) 
				System.out.printf("%4s"," ");
			//�b�L�X�Ӥ��Ѽ�
			for(int day=1;day<=monthDay[month-1];day++) 
			{
				System.out.printf("%4d",day);
				//�Ӥ�%7���l�Ʒ|�����Ĥ@��§�����檺���l(=7-�ťդѼ�)
				if(day%7 == (7-spaceDay)%7) //spaceDay�i�൥��0�ҥH�n%7
					System.out.println();
			}
		}
	}
	
	//�L�X�Ӧ~���X�Ӥ���
	public void showWeekend(int year)
	{
		int countSat = 0;//���X�ӬP����
		int countSun = 0;//���X�ӬP����
		int weekDay;//�P�_�P���X
		if(year==0) { //�P�_�O�_�榡���~
			System.out.println("���J�榡���~");
		}else{
			//�P�_�Ӧ~2���Ѽ�
			if(isLeapYear(year)) monthDay[1] = 29;
			//�p�⦳�X�Ӥ���
			for(int month=1;month<=12;month++)
			{
				for(int day=1;day<=monthDay[month-1];day++)
				{	
					//�P���X = (�Ӥ��ťդѼ�+�Ӹ��P1�����t�Z)��7���l��
					weekDay = (getSpaceDay(year,month)+day-1)%7;
					if(weekDay==6) countSat++;
					if(weekDay==0) countSun++;
				}
			}	
			System.out.println(year +"�~�@��"+countSat+"�ӬP����" + countSun+"�ӬP����");
		}
	}
}
