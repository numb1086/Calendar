package cld;

import java.util.Scanner;

public class Calendar 
{
	public static void main(String[] argv) 
	{
		int mode;
		Scanner in = new Scanner(System.in);
		System.out.println("1.�P�_�O�_���|�~  2.��J�~��Ǧ^���X��  3.��J�~���Ǧ^�P���X "
							+ "4.��J�~��Ǧ^���  5.��J�~�Ǧ^���X�Ӥ���");
		System.out.print("�п��: ");
		mode = in.nextInt();
		Choice ch = new Choice(mode);
		ch.choice();

	}
}

