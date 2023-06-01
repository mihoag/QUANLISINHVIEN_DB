package model;

public class sinhvien {
private String masv;
private String tensv;
private String diachi;
private String malop;
public sinhvien(String masv, String tensv, String diachi, String malop) {
	super();
	this.masv = masv;
	this.tensv = tensv;
	this.diachi = diachi;
	this.malop = malop;
}
public sinhvien() {
	super();
	// TODO Auto-generated constructor stub
}
public String getMasv() {
	return masv;
}
public void setMasv(String masv) {
	this.masv = masv;
}
public String getTensv() {
	return tensv;
}
public void setTensv(String tensv) {
	this.tensv = tensv;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public String getMalop() {
	return malop;
}
public void setMalop(String malop) {
	this.malop = malop;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
	return tensv;
	}
}
