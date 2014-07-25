package cld;

import java.util.Scanner;

public class Calendar 
{
	public static void main(String[] argv) 
	{
		int mode;
		Scanner in = new Scanner(System.in);
		System.out.println("1.判斷是否為閏年  2.輸入年月傳回有幾天  3.輸入年月日傳回星期幾 "
							+ "4.輸入年月傳回整月  5.輸入年傳回有幾個六日");
		System.out.print("請選擇: ");
		mode = in.nextInt();
		Choice ch = new Choice(mode);
		ch.choice();

	}
}

