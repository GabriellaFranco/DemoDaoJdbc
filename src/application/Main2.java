package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DepartmentDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;

public class Main2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("----------- Test 1: Department findByID -------------");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n----------- Test 2: Department findAll -------------");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n----------- Test 3: Department insert -------------");
		Department dep = new Department(0, "Software");
		departmentDao.insert(dep);
		System.out.println("Inserted! ");
		System.out.println(dep);
		
		System.out.println("\n----------- Test 4: Department update -------------");
		department = departmentDao.findById(3);
		department.setName("Games");
		departmentDao.update(department);
		System.out.println("Update complete!");
		System.out.println(department);
		
		System.out.println("\n----------- Test 5: Department delete -------------");
		System.out.print("Enter the id for the delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete complete! ");
	}

}
