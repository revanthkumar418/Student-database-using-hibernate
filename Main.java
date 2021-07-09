package com.te.StudentDataBase;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws invaliddataException {
		Student student=new Student();
		Crud  crud=new Crud();
		Scanner scanner=new Scanner(System.in);
		System.out.println("WELCOME TO STUDENT DATABASE");
		while(true) {
			
			System.out.println("choose your option");
			System.out.println("--------enter 1 for insert data------- ");
			System.out.println("--------enter 2 for see particular record --------");
			System.out.println( "-------enter 3 for readall  data----------");
			System.out.println("--------enter 4 for delete data-------");
			System.out.println("--------enter  5 for update data-------");

			int key=scanner.nextInt();
			switch (key) {
			case 1:
				crud.insertdata();
				System.out.println("data enterd succsessfully");
				
				break;
			case 2:
				crud.readperticularData();
				break;
				
				
			case 3:
				crud.readall();
				break;
			case 4:
				crud.delete(args);
				break;
			case 5: 
				crud.update(args);
				break;
			default:
				break;
			}
		}
	}
}
