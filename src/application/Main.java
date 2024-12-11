package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.SellerDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("----------- Test 1: Seller findByID -------------");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n----------- Test 2: Seller findByDepartment -------------");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n----------- Test 3: Seller findAll -------------");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n----------- Test 4: Seller insert -------------");
		Seller newSeller = new Seller(0, "Greg", "greg@gmail.com", new Date(), 4000, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted!");
		System.out.println(newSeller);
		
		System.out.println("\n----------- Test 5: Seller update -------------");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		System.out.println(seller);
		
		System.out.println("\n----------- Test 6: Seller delete -------------");
		System.out.print("Enter the id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete!");
		
		sc.close();

	}

}
