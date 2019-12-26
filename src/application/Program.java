package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TESTE 1: seller findById ===");
		Seller seller = sellerDao.findById(5);
		System.out.println(seller);

		System.out.println("\n=== TESTE 2: seller findByDepartment ===");
		Department department = new Department(2, null);
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
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+ newSeller.getId());
		
		System.out.println("\n=== TESTE 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted completed");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== TESTE 7: department findById ===");
		department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== TESTE 8: seller findAll ===");
		List<Department> listDep = departmentDao.findAll();
		for (Department obj : listDep) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE 9: department insert ===");
		department = new Department(null, "Storebooks");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());

		System.out.println("\n=== TESTE 10: department update ===");
		System.out.println("Enter id for Update name: ");
		department = departmentDao.findById(sc.nextInt());
		System.out.println("Enter name for Update");
		department.setName(sc.next());
		departmentDao.update(department);
		System.out.println("Update completed");

		System.out.println("\n=== TESTE 11: department delete ===");
		System.out.println("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted completed");
		
		sc.close();
	}
}
