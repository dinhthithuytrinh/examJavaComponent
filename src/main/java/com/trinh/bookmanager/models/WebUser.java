package com.trinh.bookmanager.models;

public class WebUser {
	private String tenTaiKhoan;
	private String matKhau;
	private String email;
	private String hoTen;
	private int authLevel;

	public WebUser() {
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(int authLevel) {
		this.authLevel = authLevel;
	}

	@Override
	public String toString() {
		return "WebUser [tenTakKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", email=" + email + ", hoTen=" + hoTen
				+ ", authLevel=" + authLevel + "]";
	}

}
