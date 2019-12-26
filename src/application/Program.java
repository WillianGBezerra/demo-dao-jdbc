package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TESTE 1: seller findById ===");
		System.out.println("Enter the Id's seller to search: ");
		Seller seller = sellerDao.findById(sc.nextInt());
		System.out.println(seller);

		System.out.println("\n=== TESTE 2: seller findByDepartment ===");
		System.out.println("Enter the Id's department to search: ");
		Department department = new Department(sc.nextInt(), null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 4: seller insert ===");
		System.out.println("Enter seller name: ");
		String name = sc.next();
		System.out.println("Enter seller email: ");
		String email = sc.next();
		System.out.println("Enter seller birthdate: ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter seller salary: ");
		double baseSalary = sc.nextDouble(); 
		System.out.println("Enter seller department: ");
		department = new Department(sc.nextInt(), null);
		Seller newSeller = new Seller(null, name, email,new java.sql.Date(birthDate.getTime()), baseSalary, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+ newSeller.getId());
		
		System.out.println("\n=== TESTE 5: seller update ===");
		System.out.println("Enter the Id: ");
		seller = sellerDao.findById(sc.nextInt());
		System.out.println("Enter seller name to update: ");
		seller.setName(sc.next());
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		sellerDao.deleteById(sc.nextInt());
		System.out.println("Deleted completed");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== TESTE 7: department findById ===");
		System.out.println("Enter the id to search: ");
		department = departmentDao.findById(sc.nextInt());
		System.out.println(department);
		
		System.out.println("\n=== TESTE 8: seller findAll ===");
		List<Department> listDep = departmentDao.findAll();
		for (Department obj : listDep) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE 9: department insert ===");
		System.out.println("Enter new department: ");
		department = new Department(null,sc.next());
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId()+"!");

		System.out.println("\n=== TESTE 10: department update ===");
		System.out.println("Enter id for Update name: ");
		department = departmentDao.findById(sc.nextInt());
		System.out.println("Enter name: ");
		department.setName(sc.next());
		departmentDao.update(department);
		System.out.println("Update completed!");

		System.out.println("\n=== TESTE 11: department delete ===");
		System.out.println("Enter id for delete test: ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("Deleted completed!");
		
		sc.close();
	}
}
