package com.trinh.bookmanager.models;

import java.sql.Date;

//import java.util.Date;

public class Book {
	private int ID;
	private String TenSP;
	private String TacGia;
	private String MoTa;
	private Date NgayPhatHanh;
	private int GiaTien;
	private String MaLoaiSP;
	private String AnhMinhHoa;

	public Book() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public String getTacGia() {
		return TacGia;
	}

	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public Date getNgayPhatHanh() {
		return NgayPhatHanh;
	}

	public void setNgayPhatHanh(Date ngayPhatHanh) {
		NgayPhatHanh = ngayPhatHanh;
	}

	public int getGiaTien() {
		return GiaTien;
	}

	public void setGiaTien(int giaTien) {
		GiaTien = giaTien;
	}

	public String getMaLoaiSP() {
		return MaLoaiSP;
	}

	public void setMaLoaiSP(String maLoaiSP) {
		MaLoaiSP = maLoaiSP;
	}

	public String getAnhMinhHoa() {
		return AnhMinhHoa;
	}

	public void setAnhMinhHoa(String anhMinhHoa) {
		AnhMinhHoa = anhMinhHoa;
	}

	@Override
	public String toString() {
		return "Book [ID=" + ID + ", TenSP=" + TenSP + ", TacGia=" + TacGia + ", MoTa=" + MoTa + ", NgayPhatHanh="
				+ NgayPhatHanh + ", GiaTien=" + GiaTien + ", MaLoaiSP=" + MaLoaiSP + ", AnhMinhHoa=" + AnhMinhHoa + "]";
	}

}
