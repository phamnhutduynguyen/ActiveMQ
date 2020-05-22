package Entities;

public class Sinhvien {
	private String mssv;
	private String hoten;
	private int namsinh;
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	public Sinhvien(String mssv, String hoten, int namsinh) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.namsinh = namsinh;
	}
	@Override
	public String toString() {
		return "Sinhvien [mssv=" + mssv + ", hoten=" + hoten + ", namsinh=" + namsinh + "]";
	}
	
	
}
