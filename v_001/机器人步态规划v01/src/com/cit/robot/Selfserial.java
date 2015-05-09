package com.cit.robot;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class Selfserial implements SerialPortEventListener {

	private String portname;

	private String rate;

	private String data;

	private String stop;

	private String parity;

	protected CommPortIdentifier portId;

	protected Enumeration<?> ports;

	protected List<String> portList;

	protected SerialPort serialPort;

	protected OutputStream outputStream = null;

	protected InputStream inputStream = null;

	protected String mesg;


	protected int sendCount, reciveCount;

	protected boolean isEmptyOfPort;

	@Override
	public void serialEvent(SerialPortEvent event) {
		// TODO Auto-generated method stub
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:

			byte[] readBuffer = new byte[100];
            
			try {
				while (inputStream.available() > 0) {
					inputStream.read(readBuffer);
				}
				StringBuilder receivedMsg = new StringBuilder("/-- ");
				receivedMsg.append(new String(readBuffer).trim()).append(
						" --/\n");
				// readTa.append(receivedMsg.toString());
				System.out.println(receivedMsg);
				reciveCount++;
				// readTa.setText(receivedMsg.toString());
				// statusLb.setText("  发送: "+sendCount+"                                      接收: "+reciveCount);
			} catch (IOException e) {
				// showErrMesgbox(e.getMessage());
			}
		}

	}

	public void setportname(String ss) {
		portname = ss;
	}

	public String getportname() {
		return portname;
	}

	public void setrate(String ss) {
		rate = ss;
	}

	public String getrate() {
		return rate;
	}

	public void setdata(String ss) {
		data = ss;
	}

	public String getdata() {
		return data;
	}

	public void setparity(String ss) {
		parity = ss;
	}

	public String getparity() {
		return parity;
	}

	public void setstop(String ss) {
		stop = ss;
	}

	public String getstop() {
		return stop;
	}

	public List<String> getportList() {
		return portList;
	}

	public void setisEmptyOfPort(boolean bb) {
		isEmptyOfPort = bb;
	}

	public boolean getisEmptyOfPort() {
		return isEmptyOfPort;
	}

	public boolean isSerialPort() {
		if (serialPort != null)
			return true;
		else
			return false;
	}

	public void scanPorts() {
		portList = new ArrayList<String>();
		Enumeration<?> en = CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier portId;
		while (en.hasMoreElements()) {
			portId = (CommPortIdentifier) en.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				String name = portId.getName();
				if (!portList.contains(name)) {
					portList.add(name);
				}
			}
		}
		if (null == portList || portList.isEmpty()) {
			// showErrMesgbox("未找到可用的串行端口号,程序无法启动!");
			setisEmptyOfPort(false);
			System.exit(0);
		} else {
			setisEmptyOfPort(true);
		}
	}

	public void openSerialPort() {
		// 获取要打开的端口
		try {
			portId = CommPortIdentifier.getPortIdentifier(portname);
		} catch (NoSuchPortException e) {
			// showErrMesgbox("抱歉,没有找到"+portname+"串行端口号!");
			// setComponentsEnabled(true);
			return;
		}
		// 打开端口
		try {
			serialPort = (SerialPort) portId.open("JavaRs232", 2000);
			// statusLb.setText(portname+"串口已经打开!");
		} catch (PortInUseException e) {
			// showErrMesgbox(portname+"端口已被占用,请检查!");
			// setComponentsEnabled(true);
			return;
		}

		// 设置端口参数
		try {
			System.out.println("rate:"+this.rate);
			int rate = Integer.parseInt(this.rate);
			System.out.println("data:"+this.data);
			int data = Integer.parseInt(this.data);
			// int stop = stopCombox.getSelectedIndex()+1;
			// int parity = parityCombox.getSelectedIndex();
			System.out.println("stop:"+this.stop);
			int stop = Integer.parseInt(this.stop) + 1;
			System.out.println("parity:"+this.parity);
			int parity = Integer.parseInt(this.parity);

			serialPort.setSerialPortParams(rate, data, stop, parity);
		} catch (UnsupportedCommOperationException e) {
			// showErrMesgbox(e.getMessage());
		}

		// 打开端口的IO流管道
		try {
			outputStream = serialPort.getOutputStream();
			inputStream = serialPort.getInputStream();
		} catch (IOException e) {
			// showErrMesgbox(e.getMessage());
		}

		// 给端口添加监听器
		try {
			serialPort.addEventListener(this);
		} catch (TooManyListenersException e) {
			// showErrMesgbox(e.getMessage());
		}

		serialPort.notifyOnDataAvailable(true);
		System.out.println("open success!!!");
	}

	public void closeSerialPort() {
		try {
			if (outputStream != null)
				outputStream.close();
			if (serialPort != null)
				serialPort.close();
			serialPort = null;
			// statusLb.setText(portname+"串口已经关闭!");
			sendCount = 0;
			reciveCount = 0;
			// sendTa.setText("");
			// readTa.setText("");
		} catch (Exception e) {
			// showErrMesgbox(e.getMessage());
		}
	}

	public void sendDataToSeriaPort(String ss) {
		try {
			sendCount++;
			outputStream.write(ss.getBytes());
			outputStream.flush();

		} catch (IOException e) {
			// showErrMesgbox(e.getMessage());
		}
		// sendTa.setText(mesg);

		// statusLb.setText("  发送: "+sendCount+"                                      接收: "+reciveCount);
	}

}
