package com.trinh.bookmanager.helpers;

import com.trinh.bookmanager.models.Book;

public class DBBookQueries {

	public static String getBook() {
		return "select * from SanPham order by TenSP DESC";
	}

	public static String getGenre() {
		return "select * from LoaiSanPham order by MaLoaiSP";
	}

	public static String insertBook(Book b) {
		// %t
		return String.format(
				"INSERT INTO SanPham(TenSP, TacGia, MoTa, NgayPhatHanh, GiaTien, MaLoaiSP, AnhMinhHoa) "
						+ "VALUES ('%s','%s','%s','%s', %d, '%s', '%s')",
				b.getTenSP(), b.getTacGia(), b.getMoTa(), b.getNgayPhatHanh(), b.getGiaTien(), b.getMaLoaiSP(),
				b.getAnhMinhHoa());
	}

	public static String getGenreBook() {
		return "select MaLoaiSP from LoaiSanPham order by MaLoaiSP";
	}

	public static String getWebUserByUsernameAndPassword(String tentaikhoan, String matkhau) {
		return String.format("select * from TaiKhoan where TenTaiKhoan='%s' and MatKhau='%s'", tentaikhoan, matkhau);
	}
//
//	public static String updateCity(Book b) {
//		// UPDATE city SET Name='...' , CountryCode='...', Country='...',
//		// Population=.... WHERE id = ....
//		return String.format(
//				"UPDATE city SET Name='%s' , CountryCode='%s', Country='%s', Population=%d, imageUrl='%s' WHERE id =%d",
//				c.getName(), c.getCountryCode(), c.getCountry(), c.getPopulation(), c.getImageUrl(), c.getId());
//	}
//
//	public static String loadCity(String cityId) {
//		return "select * from city where id=" + cityId;
//	}
//
//	public static String deleteCity(String cityId) {
//		return "delete from city where id=" + cityId;
//	}
}
