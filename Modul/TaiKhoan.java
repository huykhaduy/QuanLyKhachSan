package Modul;
import java.io.Serializable;
import java.util.*;

import Controller.Program;
import Modul.Error.NotExsitException;
import Modul.NhanVien;

public class TaiKhoan implements Serializable {
		private static int staticid = 100;
		private int accountid;
		private String tenDangNhap;
		private String matKhau;
		private String vaiTro;
		private NhanVien nhanVien;
		
		public TaiKhoan() {	
			this.accountid = staticid++;	
			}

		public TaiKhoan(String tenDangNhap, String matKhau){
			this.accountid = staticid++;
			this.tenDangNhap =tenDangNhap;
			this.matKhau = matKhau;
		}

	public TaiKhoan(String tenDangNhap, String matKhau, String maNV){
		this.accountid = staticid++;
		this.tenDangNhap =tenDangNhap;
		this.matKhau = matKhau;
		try {
			this.nhanVien = Program.getDSNV().layDuLieuNV(maNV);
		} catch (NotExsitException e) {
			e.printStackTrace();
		}
	}


//		public TaiKhoan(String tenDangNhap, String matKhau, String vaiTro) {
//			this.accountid = staticid++;
//			this.tenDangNhap = tenDangNhap;
//			this.matKhau = matKhau;
//			this.vaiTro = vaiTro;
//		}

		public int getAccountid() {
			return accountid;
		}
		public void setAccountid(int accountid) {
			this.accountid = accountid;
		}
		public String getTenDangNhap() {
			return tenDangNhap;
		}
		public void setTenDangNhap(String tenDangNhap) {
			this.tenDangNhap = tenDangNhap;
		}
		public String getMatKhau() {
			return matKhau;
		}
		public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
		}
		public String getVaiTro() {
			return vaiTro;
		}
		public void setVaiTro(String vaiTro) {
			this.vaiTro = vaiTro;
		}
		public NhanVien getNhanVien() {
			return nhanVien;
		}
		public void setNhanVien(NhanVien nhanVien) {
			this.nhanVien = nhanVien;
		}
		// đăng nhập hệ thống
		
		public void show() {
			System.out.format("%s%-19s%s%-30s%s%-30s%s\n","|",this.accountid,"|",this.tenDangNhap,"|",this.matKhau,"|");
		}
		public void menu(boolean ttdangnhap) {
			if(this.vaiTro.equals("admin")) {
				ttdangnhap = true;
				String chon = null;
				System.out.format("%-30s%-80s\n","","------------------------------admin-------------------------------");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","|Phím","|","Chức Năng","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 1","| Xem danh sách phòng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 2","| Thêm phòng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 3","| Sửa phòng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 4","| Xóa phòng","","|");
		
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 5","| Xem danh sách dịch vụ","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 6","| Thêm dịch vụ","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 7","| Xóa dịch vụ","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 8","| Sửa dịch vụ","","|");
				
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 9","| Xem danh sách tài khoản","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 10","| Thêm tài khoản","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 11","| Sửa tài khoản","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 12","| Xóa tài khoản","","|");
				
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 0","| Đăng xuất","","|");
				System.out.format("%-30s%-80s\n","","------------------------------------------------------------------");
				Scanner sc = new Scanner(System.in);
					do {
						chon =  sc.nextLine();
						switch (chon){
						case "1":
							break;
						case "2":
							break;
						case "3":
							break;
						case "4":
							break;
						case "5":
							break;
						case "6":
							break;
						case "7":
							break;
						case "8":
							break;
						case "9":
							break;
						case "10":
							//dsTK.themTaiKhoan();
							break;
						case "11":
							//dsTK.suaTaiKhoan();
							break;
						case "12":
							//dsTK.xoaTaiKhoan();
							break;
							
						case "0":
							ttdangnhap = false;
							break;
						}
					}while(ttdangnhap);
			}else if(this.vaiTro.equals("letan")) {
				ttdangnhap = true;
				String chon = null;
				System.out.format("%-30s%-80s\n","","-----------------------------Lễ tân-------------------------------");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","|Phím","|","Chức Năng","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 2","| Xem danh sách khách hàng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 3","| Thêm khách hàng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 4","| Sửa thông tin khách hàng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 5","| Xóa khách hàng","","|");
		
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 6","| Xem danh phòng trống","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 7","| Lập phiếu thuê","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 8","| Xem danh sách phòng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 9","| Xem danh sách phòng","","|");
			
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 10","| Lập phiếu thu","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 11","| Sửa phiếu thuê","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 12","| Xóa phiếu thuê","","|");
			
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 13","| Lập hóa đơn","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 14","| Sửa phiếu thuê","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 15","| Xóa phiếu thuê","","|");
				
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 0","| Đăng xuất","","|");
				System.out.format("%-30s%-80s\n","","------------------------------------------------------------------");
				Scanner sc = new Scanner(System.in);
				do {
					chon =  sc.nextLine();
					switch (chon){
					case "1":
						break;
					case "2":
			
					case "3":
			
					}
				}while(ttdangnhap);
			}else {
				String chon = null;
				System.out.format("%-30s%-80s\n","","------------------------------Quản lý-------------------------------");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","|Phím","|","Chức Năng","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 1","| Xem danh sách nhân viên","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 2","| Thêm nhân viên","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 3","| Sửa thông tin nhân viên","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 4","| Xóa nhân viên","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 5","| Xem danh sách khách hàng","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 6","| Xem thống kê","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 7","| Xem danh sách tài khoản nhân viên","","|");
				System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 0","| Đăng xuất","","|");
				System.out.format("%-30s%-80s\n","","------------------------------------------------------------------");
				Scanner sc = new Scanner(System.in);
				do {
					chon =  sc.nextLine();
					switch (chon){
					case "1":
						break;
					case "2":
						break;
					case "3":
						break;
					case "4":
						break;
					case "5":
						break;
					case "6":
						break;
					case "7":
						break;
					case "0":
						ttdangnhap = false;
						break;
					}
				}while(ttdangnhap);
			}
		}
}



