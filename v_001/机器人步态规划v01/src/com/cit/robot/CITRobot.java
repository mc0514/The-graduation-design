package com.cit.robot;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CITRobot extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int WIN_WIDTH = 1000;

	protected int WIN_HEIGHT = 800;

	private JComboBox<?> portCombox, rateCombox, dataCombox, stopCombox,
			parityCombox;

	private Button openPortBtn, closePortBtn, sendMsgBtn;

	private JLabel statusLb;

	protected String mesg1;
	protected String mesg2;
	protected String mesg3;
	protected String mesg4;
	protected String mesg5;
	protected String mesg6;
	protected String mesg7;
	protected String mesg8;
	protected String mesg9;
	protected String mesg10;
	protected String mesg11;
	protected String mesg12;
	protected String mesg13;
	protected String mesg14;
	protected String mesg15;
	protected String mesg16;
	protected String mesg17;

	protected int sendCount, reciveCount;

	Selfslider slider = new Selfslider();
	Selfserial serial = new Selfserial();
	DealMesg dealmesg = new DealMesg();

	public CITRobot() {
		super("机器人步态规划v01");
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		serial.scanPorts();

		slider.slidersInit();
		initComponents();
		System.out.println("start init!!!");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	protected void initComponents() {

		Font lbFont = new Font("微软雅黑", Font.TRUETYPE_FONT, 14);
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();

		JLabel baudrateLb = new JLabel("波特率：");
		baudrateLb.setFont(lbFont);
		JLabel stopbitsLb = new JLabel("停止位：");
		stopbitsLb.setFont(lbFont);
		JLabel portnameLb = new JLabel("串口号：");
		portnameLb.setFont(lbFont);
		JLabel databitsLb = new JLabel("数据位：");
		databitsLb.setFont(lbFont);
		JLabel parityLb = new JLabel("校验位：");
		parityLb.setFont(lbFont);
		statusLb = new JLabel();
		statusLb.setOpaque(true);
		statusLb.setFont(lbFont);

		portCombox = new JComboBox<String>((String[]) serial.getportList()
				.toArray(new String[0]));

		portCombox.addActionListener(this);

		dataCombox = new JComboBox<Integer>(new Integer[] { 5, 6, 7, 8, 40 });
		dataCombox.setSelectedIndex(3);
		dataCombox.addActionListener(this);

		parityCombox = new JComboBox<String>(new String[] { "NONE", "ODD",
				"EVEN", "MARK", "SPACE" });
		parityCombox.addActionListener(this);

		rateCombox = new JComboBox<Integer>(new Integer[] { 2400, 4800, 9600,
				14400, 19200, 38400, 56000 });
		rateCombox.setSelectedIndex(2);
		rateCombox.addActionListener(this);

		stopCombox = new JComboBox<String>(new String[] { "1", "2", "1.5" });
		stopCombox.addActionListener(this);

		openPortBtn = new Button("打开端口");
		openPortBtn.addActionListener(this);
		closePortBtn = new Button("关闭端口");
		closePortBtn.addActionListener(this);
		sendMsgBtn = new Button(" 发送 ");
		sendMsgBtn.setSize(100, 50);
		sendMsgBtn.addActionListener(this);

		eastPanel.setLayout(new GridLayout(7, 2, 40, 40));
		eastPanel.add(portnameLb);
		portnameLb.setLocation(10, 20);
		eastPanel.add(portCombox);
		eastPanel.add(baudrateLb);
		eastPanel.add(rateCombox);
		eastPanel.add(databitsLb);
		eastPanel.add(dataCombox);
		eastPanel.add(stopbitsLb);
		eastPanel.add(stopCombox);
		eastPanel.add(parityLb);
		eastPanel.add(parityCombox);
		eastPanel.add(openPortBtn);
		eastPanel.add(closePortBtn);

		northPanel.setLayout(new FlowLayout());
		northPanel.add(statusLb);

		southPanel.setLayout(new FlowLayout());
		southPanel.add(sendMsgBtn);

		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(slider.getShowval());
		centerPanel.add(slider.addSliders());

		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setOpaque(false);
		contentPane.add(westPanel, BorderLayout.WEST);
		contentPane.add(eastPanel, BorderLayout.EAST);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == portCombox || e.getSource() == rateCombox
				|| e.getSource() == dataCombox || e.getSource() == stopCombox
				|| e.getSource() == parityCombox) {
			// statusLb.setText(serial.initStatus());
		}
		if (e.getSource() == openPortBtn) {
			setComponentsEnabled(false);
			setInitSerial();
			serial.openSerialPort();
		}
		if (e.getSource() == closePortBtn) {
			if (serial.isSerialPort()) {
				serial.closeSerialPort();
			}
			setComponentsEnabled(true);
		}

		if (e.getSource() == sendMsgBtn) {
			if (!serial.isSerialPort()) {
				showErrMesgbox("请先打开串行端口!");
				return;
			}
			// mesg = "test!!";
			StringBuilder temp = new StringBuilder();
			System.out.println("/---send: ---/");
			System.out.println("serv1: " + slider.getSlidervalue1());
			System.out.println("serv2: " + slider.getSlidervalue2());
			System.out.println("serv3: " + slider.getSlidervalue3());
			System.out.println("serv4: " + slider.getSlidervalue4());
			System.out.println("serv5: " + slider.getSlidervalue5());
			System.out.println("serv6: " + slider.getSlidervalue6());
			System.out.println("serv7: " + slider.getSlidervalue7());
			System.out.println("serv8: " + slider.getSlidervalue8());
			System.out.println("serv9: " + slider.getSlidervalue9());
			System.out.println("serv10: " + slider.getSlidervalue10());
			System.out.println("serv11: " + slider.getSlidervalue11());
			System.out.println("serv12: " + slider.getSlidervalue12());
			System.out.println("serv13: " + slider.getSlidervalue13());
			System.out.println("serv14: " + slider.getSlidervalue14());
			System.out.println("serv15: " + slider.getSlidervalue15());
			System.out.println("serv16: " + slider.getSlidervalue16());
			System.out.println("serv17: " + slider.getSlidervalue17());

			mesg1 = slider.getSlidervalue1();
			mesg2 = slider.getSlidervalue2();
			mesg3 = slider.getSlidervalue3();
			mesg4 = slider.getSlidervalue4();
			mesg5 = slider.getSlidervalue5();
			mesg6 = slider.getSlidervalue6();
			mesg7 = slider.getSlidervalue7();
			mesg8 = slider.getSlidervalue8();
			mesg9 = slider.getSlidervalue9();
			mesg10 = slider.getSlidervalue10();
			mesg11 = slider.getSlidervalue11();
			mesg12 = slider.getSlidervalue12();
			mesg13 = slider.getSlidervalue13();
			mesg14 = slider.getSlidervalue14();
			mesg15 = slider.getSlidervalue15();
			mesg16 = slider.getSlidervalue16();
			mesg17 = slider.getSlidervalue17();

			/*
			 * if (null == mesg || mesg.isEmpty()) {
			 * showErrMesgbox("请输入你要发送的内容!"); return; }
			 */

			temp = dealmesg.appendMessage(mesg1, mesg2, mesg3, mesg4, mesg5,
					mesg6, mesg7, mesg8, mesg9, mesg10, mesg11, mesg12, mesg13,
					mesg14, mesg15, mesg16, mesg17);
			System.out.println("temp: "+temp);
			serial.sendDataToSeriaPort(temp.toString());
		}
	}

	/*
	 * public String initStatus() { portname =
	 * portCombox.getSelectedItem().toString(); rate =
	 * rateCombox.getSelectedItem().toString(); data =
	 * dataCombox.getSelectedItem().toString(); stop =
	 * stopCombox.getSelectedItem().toString(); parity =
	 * parityCombox.getSelectedItem().toString();
	 * 
	 * StringBuffer str = new StringBuffer("当前串口号:");
	 * str.append(portname).append(" 波特率:"); str.append(rate).append(" 数据位:");
	 * str.append(data).append(" 停止位:"); str.append(stop).append(" 校验位:");
	 * str.append(parity); return str.toString(); }
	 */

	public void setComponentsEnabled(boolean enabled) {
		openPortBtn.setEnabled(enabled);
		openPortBtn.setEnabled(enabled);
		portCombox.setEnabled(enabled);
		rateCombox.setEnabled(enabled);
		dataCombox.setEnabled(enabled);
		stopCombox.setEnabled(enabled);
		parityCombox.setEnabled(enabled);
	}

	public void showErrMesgbox(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public String getPortName() {
		return portCombox.getSelectedItem().toString();
	}

	public String getrate() {
		return rateCombox.getSelectedItem().toString();
	}

	public String getdata() {
		return dataCombox.getSelectedItem().toString();
	}

	public String getstop() {
		//return stopCombox.getSelectedItem().toString();
		return Integer.toString(stopCombox.getSelectedIndex()+1);
	}

	public String getparity() {
		return Integer.toString(parityCombox.getSelectedIndex());
	}

	public void setInitSerial() {
		serial.setportname(getPortName());
		serial.setdata(getdata());
		// serial.setportname(ss);
		serial.setrate(getrate());
		serial.setstop(getstop());
		serial.setparity(getparity());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CITRobot();

	}

}
