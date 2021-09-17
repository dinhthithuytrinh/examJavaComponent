package com.trinh.bookmanager.models;

public class Genre {
	private String MaLoaiSP;
	private String TenLoaiSP;

	public Genre() {
	}

	public String getMaLoaiSP() {
		return MaLoaiSP;
	}

	public void setMaLoaiSP(String maLoaiSP) {
		MaLoaiSP = maLoaiSP;
	}

	public String getTenLoaiSP() {
		return TenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		TenLoaiSP = tenLoaiSP;
	}

	@Override
	public String toString() {
		return "Genre [MaLoaiSP=" + MaLoaiSP + ", TenLoaiSP=" + TenLoaiSP + "]";
	}

}
