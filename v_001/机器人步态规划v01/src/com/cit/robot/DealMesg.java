package com.cit.robot;

public class DealMesg {

	private StringBuilder receiveMessage = new StringBuilder();

	private StringBuilder sendMessage = new StringBuilder();

	public StringBuilder getreceiveMessage() {
		return this.receiveMessage;
	}

	public void setreceiveMessage(StringBuilder sb) {
		this.receiveMessage = sb;
	}

	public StringBuilder getsendMessage() {
		return this.sendMessage;
	}

	public void setsendMessage(StringBuilder sb) {
		this.sendMessage = sb;
	}
	
	public StringBuilder appendMessage(String ss1,String ss2,String ss3,String ss4,String ss5,String ss6, String ss7,String ss8,String ss9,String ss10,String ss11,String ss12,String ss13,String ss14,String ss15,String ss16,String ss17)
    {
		StringBuilder temp = new StringBuilder();
		temp.append("serv1:"+ss1+"/");
		temp.append("serv2:"+ss2+"/");
		temp.append("serv3:"+ss3+"/");
		temp.append("serv4:"+ss4+"/");
		temp.append("serv5:"+ss5+"/");
		temp.append("serv6:"+ss6+"/");
		temp.append("serv7:"+ss7+"/");
		temp.append("serv8:"+ss8+"/");
		temp.append("serv9:"+ss9+"/");
		temp.append("serv10:"+ss10+"/");
		temp.append("serv11:"+ss11+"/");
		temp.append("serv12:"+ss12+"/");
		temp.append("serv13:"+ss13+"/");
		temp.append("serv14:"+ss14+"/");
		temp.append("serv15:"+ss15+"/");
		temp.append("serv16:"+ss16+"/");
		temp.append("serv17:"+ss17+"/");
		temp.append("#");
		return temp;
	}
}
