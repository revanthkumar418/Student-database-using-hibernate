package com.te.StudentDataBase;

import java.security.PublicKey;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.SimpleAttributeSet;

import com.te.JpaWithHybernateDemo.Movies;

public class Crud extends Exception {
	Scanner scanner= new Scanner(System.in);
	

	
 public void readperticularData() throws invaliddataException {
	Scanner scanner=new Scanner(System.in);
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	
	
	try {
		factory=Persistence.createEntityManagerFactory("moviesData");
		manager=factory.createEntityManager();
		
		String read="from Student where rollno=:rollno";
		System.out.println("Enter rollno which you want to display");
		int rollno=scanner.nextInt();
         Query query=	manager.createQuery(read);
         query.setParameter("rollno", rollno);

         Student student=	(Student) query.getSingleResult();
         if(student!=null) {
        	 System.out.println("Rollno is : "+student.getRollno());
        	 System.out.println("Name is : "+ student.getName());
        	 
        	 System.out.println("Phno is :"+ student.getPhno());
        	 
        	 System.out.println("Date of birth is :"+ student.getDob());
        	 
        	 }else {
        	 throw new invaliddataException();
         }
        
	} catch (Exception e) {
		
		System.out.println("");
		
		e.printStackTrace();
	}finally {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
	}

}

public void insertdata() {
	
	Student student=new Student();
	student.setRollno(1);
	
	student.setName("krishna");
	student.setPhno(778011084);
	
	student.setDob("2005-02-02");
	
	EntityManagerFactory factory=null;
	EntityManager  manager=null;
	EntityTransaction transaction=null;
	
	try {
		
		factory=Persistence.createEntityManagerFactory("moviesData");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
		
		manager.persist(student);
		System.out.println("Data inserted successfully");
		System.out.println("::::::::::::::::::::::::::::::::::::");
		
		
		transaction.commit();
	}catch (Exception e) {
		
		System.out.println("");
		
		e.printStackTrace();
	}finally {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
	}
	

	
}

public void readall() {
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	
	
	try {
		factory=Persistence.createEntityManagerFactory("moviesData");
		manager=factory.createEntityManager();
		
		String readall="from Student";
       Query query=	manager.createQuery(readall);
       
  List<Student> list=query.getResultList();
     
  for (Student student:list) {
	  System.out.println("Rollno is : "+student.getRollno());
 	 System.out.println("Name is : "+ student.getName());
 	 System.out.println("Phno is :"+ student.getPhno());
 	 System.out.println("Date of birth is :"+ student.getDob());
 	 System.out.println(":::::::::::::::::::Next student::::::::::::");
}
     

	} catch (Exception e) {
		
		e.printStackTrace();
	}finally {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
	}
	
	
}

public  static void delete(String[] args){
	Scanner scanner=new Scanner(System.in);
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	
	try {
		factory=Persistence.createEntityManagerFactory("moviesData");
		manager= factory.createEntityManager();
		transaction= manager.getTransaction();
		
		transaction.begin();
		 System.out.println("enter the rollno you want to delete");
		 int rollno=scanner.nextInt();
		String update="delete Student where rollno=rollno";
Query query=	manager.createQuery(update);

//query.setParameter("rollno" ,Integer.parseInt(args[0]));
		
int result= query.executeUpdate();
if(result!=0) {
	System.out.println(result+"no of rows affected");
}else
{
	throw new invaliddataException();
}

		
		transaction.commit();
	} catch (Exception e) {
		
		System.out.println("");
		
		e.printStackTrace();
	}finally {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
	}
	
}

public void update(String[]args) {
Scanner scanner=new Scanner(System.in);

	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try {
		
		factory=Persistence.createEntityManagerFactory("moviesData");
		manager= factory.createEntityManager();
		transaction= manager.getTransaction();
		System.out.println("enter rollno you want to update");
		int rollno=scanner.nextInt();
		System.out.println("enter updated name");
		String name=scanner.next();
		System.out.println("enter updated phno");
		long phno=scanner.nextLong();
		System.out.println("enter dob");
		String dob=scanner.next();
		try {
		java.util.Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		}
		catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println("select which field you want to update");
//		System.out.println("yu want to update name");
		String option=scanner.next();
//		if(option==option) {
//			System.out.println("enter updated name");
//			String name1=scanner.next();
//			name=name;
//		}else {
//			name=name;
//		}
		transaction.begin();
		 
		String update="update Student set name=name where rollno=rollno";
Query query=	manager.createQuery(update);
//query.setParameter("name",args[0]);
//query.setParameter("phno",Long.parseLong(args[1]));
//query.setParameter("dob",args[2]);
//query.setParameter("rollno",Integer.parseInt(args[3]));
		
int result= query.executeUpdate();
System.out.println(result+"no of rows affected");
		
		transaction.commit();
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			
			manager.close();
		}
	}

}
}
