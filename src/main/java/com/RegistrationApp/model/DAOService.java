package com.RegistrationApp.model;

public interface DAOService {
	public void connectDB();
	public boolean verifylogin(String email, String password);
	public void saveregister(String name,String city,String email,String mobile);

}
