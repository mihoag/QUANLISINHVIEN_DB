package model;

public class lophoc {
  private String malop;
  private String tenlop;
public lophoc() {
	malop = "";
	tenlop = "";
}
public lophoc(String malop, String tenlop) {
	super();
	this.malop = malop;
	this.tenlop = tenlop;
}
public String getMalop() {
	return malop;
}
public void setMalop(String malop) {
	this.malop = malop;
}
public String getTenlop() {
	return tenlop;
}
public void setTenlop(String tenlop) {
	this.tenlop = tenlop;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tenlop;
	}
}
