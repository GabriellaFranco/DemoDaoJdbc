package application;

import java.util.List;

import model.dao.SellerDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		
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
		
		

	}

}
