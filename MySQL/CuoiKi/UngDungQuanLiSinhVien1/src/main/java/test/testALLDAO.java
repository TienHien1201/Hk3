package test;

import java.util.ArrayList;

import dao.KhoaDataAccessObject;
import model.Khoa;

public class testALLDAO {
	public static void main(String[] args) {

		/*///Test Insert
		// Insert 1 cột
		Khoa khoa = new Khoa("CDS","Công Dân Số", "2024-11-20","F206", "0392645290","GV01");
		KhoaDataAccessObject.getInstance().Insert(khoa);
	   /*Insert nhiều cột cùng 1 lúc 
		for (int i = 0; i < 1000; i++) {
			Khoa khoa3 = new Khoa("KT1" + i,"Ke Toan i: "+ i, "2015-6-13", "F309","3131313131", "GV02");
			KhoaDataAccessObject.getInstance().Insert(khoa3);
		}*/
		
		
		/*//Test Update
		Khoa k = new Khoa("CDS","Cơ Điện Số", "2023-12-12","F408", "0392645290","GV01");
		KhoaDataAccessObject.getInstance().Uppdate(k);*/
		
		/*//Test Delete
		Khoa k = new Khoa("CDS","Công Dân Số", "2023-11-20","F205", "0392645290","GV05");
		KhoaDataAccessObject.getInstance().Delete(k);
		/*Cũng có thể delete nhiều dòng trong table như Insert
		for (int i = 0; i < 1000; i++) {
			Khoa khoa = new Khoa("KT" + i,"Ke Toan i: "+ i, "2015-6-13", "F309","3131313131", "GV02");
			KhoaDataAccessObject.getInstance().Delete(khoa3);
			}*/
		/*...*/
		
		
		/*//Test select * 
		ArrayList<Khoa> list = KhoaDataAccessObject.getInstance().selecALL();
		for (Khoa k : list) {
			System.out.println(k.toString());}*/
		
		//Test select(truy vấn 1 dòng của table nào đó dựa trên MA...)
		System.out.println("-----------------------------------------------------");
		Khoa find = new Khoa();
		find.setMAKHOA("CNTT");
		Khoa k = KhoaDataAccessObject.getInstance().selectById(find);
		System.out.println(k);
		
		/*//Test select với condition(truy vấn 1 dòng của table nào đó dựa trên condition của where)
			System.out.println("-----------------------------------------------------");
			ArrayList<Khoa> list1 = KhoaDataAccessObject.getInstance().selecByCondition("MAKHOA='KT-QT'");
			for (Khoa k1 : list1) {
				System.out.println(k1.toString());
			}*/
		
		/*//Test PrepareStatement
		Khoa u_find = new Khoa("x\' or 1=1; -- ", "","","","","");
		Khoa u_result =KhoaDataAccessObject.getInstance().selectById(u_find);
		System.out.println(u_result);*/
	}
}
