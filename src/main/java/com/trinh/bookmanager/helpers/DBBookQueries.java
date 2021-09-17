package com.trinh.bookmanager.helpers;

import com.trinh.bookmanager.models.Book;

public class DBBookQueries {

	public static String getBook() {
		return "select * from SanPham order by ID DESC";
	}

	public static String getGenre() {
		return "select * from LoaiSanPham order by MaLoaiSP";
	}

	public static String insertBook(Book b) {
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

	public static String updateBook(Book b) {
		return String.format("UPDATE SanPham "
				+ "SET TenSP='%s', TacGia='%s', MoTa='%s', NgayPhatHanh='%s', GiaTien=%d, MaLoaiSP='%s', AnhMinhHoa='%s' "
				+ "WHERE ID =%d", b.getTenSP(), b.getTacGia(), b.getMoTa(), b.getNgayPhatHanh(), b.getGiaTien(),
				b.getMaLoaiSP(), b.getAnhMinhHoa(), b.getID());

	}

	public static String loadBook(String bookId) {
		return "select * from SanPham where ID=" + bookId;
	}

	public static String deleteBook(String bookId) {
		return "delete from SanPham where ID=" + bookId;
	}
}
