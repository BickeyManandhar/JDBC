package com.jdbc.method;

public class User {

	public static void main(String[] args) {
		DatabaseUtils dbu= new DatabaseUtils();
		//dbu.insertData(1234, "Rojan", "Checking", 123456.89, "rojan@yahoo.com", "test5@123");
		//dbu.updateData(1234,"Rojaan", "Saving", 122345.10,"rojan@hotmail.com", "test6@123");
		//dbu.deleteData(1234);
		dbu.selectData();

	}

}
