package cld;


public class MyCalendar 
{
	private int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};//1-12�몺�Ѽ�
	
	//�P�_�Ӧ~�O�_���|�~
	public boolean isLeapYear(int year)
	{
		return ((year%400==0)||((year%4==0) && (year%100!=0)));
	}
	
	//�P�_�Ӧ~�Ӥ몺�ťդѼ�
	public int firstSpace(int year,int month)
	{
		int firstSpace = 1; //�褸1�~1�몺�ťդѼơA���1��1�鬰�P���@	
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
		
		//�Ӧ~1-12�몺�ťդѼ�
		int spaceDay[] = {firstSpace,0,0,0,0,0,0,0,0,0,0,0};
		//�p��ܸӦ~������ťդѼơA�C�Ӥ몺�ťդѼƵ���(�e�Ӥ몺�ťդѼ�+�e�Ӥ�Ѽ�)��7���l��
		for(int i=0;i<month-1;i++)
			spaceDay[i+1] = (spaceDay[i]+monthDay[i])%7;
		
		return spaceDay[month-1];
	}
	
	public int countDays(int year,int month)
	{
		//�P�_�Ӧ~2��Ѽ�
		if(isLeapYear(year)) monthDay[1] = 29;
		
		return monthDay[month-1];
	}
	
	public int countWeekDay(int year,int month,int day)
	{
		int weekDay;
		//�P���X = (�Ӥ�ťդѼ�+�Ӹ��P1�����t�Z)��7���l��
		weekDay = (firstSpace(year,month)+ day-1)%7;
		return weekDay;
	}
	
	//�L�X���
	public void showCalendar(int year,int month)
	{
		int spaceDay = firstSpace(year,month);
		
		System.out.println("\n----------"+year+"�~"+ month+"��"+"-----------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		//���L�X�Ӥ�ťդѼ�
		for(int i=0;i<spaceDay;i++) 
			System.out.printf("%4s"," ");
		
		//�b�L�X�Ӥ�Ѽ�
		for(int day=1;day<=monthDay[month-1];day++) 
		{
			System.out.printf("%4d",day);
			//�Ӥ�%7���l�Ʒ|����Ĥ@��§�����檺��l(=7-�ťդѼ�)
			if(day%7 == (7-spaceDay)%7) //spaceDay�i�൥��0�ҥH�n%7
				System.out.println();
		}
	}
	
	public void showWeekend(int year)
	{
		int countSat = 0;
		int countSun = 0;
		//�P�_�Ӧ~2��Ѽ�
		if(isLeapYear(year)) monthDay[1] = 29;
		//�p�⦳�X�Ӥ���
		for(int month=1;month<=12;month++)
		{
			for(int day=1;day<=monthDay[month-1];day++)
			{
				if(countWeekDay(year,month,day)==6) countSat++;
				if(countWeekDay(year,month,day)==0) countSun++;
			}
		}	
		System.out.println(year +"�~�@��"+countSat+"�ӬP����" + countSun+"�ӬP����");
	}
}
