package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== TESTE 7: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== TESTE 8: seller findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
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
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted completed");
		sc.close();
	}}
