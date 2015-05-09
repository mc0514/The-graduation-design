package com.cit.robot;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Selfslider {

	// 定义滑动条的个数
	protected int slidernum = 17;

	protected String mesg1 = "null";
	protected String mesg2 = "null";
	protected String mesg3 = "null";
	protected String mesg4 = "null";
	protected String mesg5 = "null";
	protected String mesg6 = "null";
	protected String mesg7 = "null";
	protected String mesg8 = "null";
	protected String mesg9 = "null";
	protected String mesg10 = "null";
	protected String mesg11 = "null";
	protected String mesg12 = "null";
	protected String mesg13 = "null";
	protected String mesg14 = "null";
	protected String mesg15 = "null";
	protected String mesg16 = "null";
	protected String mesg17 = "null";

	Box sliderBox = new Box(BoxLayout.Y_AXIS);
	JTextField showVal = new JTextField();

	ChangeListener listener1;
	ChangeListener listener2;
	ChangeListener listener3;
	ChangeListener listener4;
	ChangeListener listener5;
	ChangeListener listener6;
	ChangeListener listener7;
	ChangeListener listener8;
	ChangeListener listener9;
	ChangeListener listener10;
	ChangeListener listener11;
	ChangeListener listener12;
	ChangeListener listener13;
	ChangeListener listener14;
	ChangeListener listener15;
	ChangeListener listener16;
	ChangeListener listener17;

	public Box addSliders() {
		// Box box = new Box(BoxLayout.X_AXIS);
		Box box = new Box(BoxLayout.PAGE_AXIS);
		JSlider slider1 = new JSlider(-50, 50);
		JSlider slider2 = new JSlider(-50, 50);
		JSlider slider3 = new JSlider(-50, 50);
		JSlider slider4 = new JSlider(-50, 50);
		JSlider slider5 = new JSlider(-50, 50);
		JSlider slider6 = new JSlider(-50, 50);
		JSlider slider7 = new JSlider(-50, 50);
		JSlider slider8 = new JSlider(-50, 50);
		JSlider slider9 = new JSlider(-50, 50);
		JSlider slider10 = new JSlider(-50, 50);
		JSlider slider11 = new JSlider(-50, 50);
		JSlider slider12 = new JSlider(-50, 50);
		JSlider slider13 = new JSlider(-50, 50);
		JSlider slider14 = new JSlider(-50, 50);
		JSlider slider15 = new JSlider(-50, 50);
		JSlider slider16 = new JSlider(-50, 50);
		JSlider slider17 = new JSlider(-50, 50);

		addSlider(slider1, listener1);
		setSlidervalue1(Integer.toString(slider1.getValue()));
		addSlider(slider2, listener2);
		setSlidervalue2(Integer.toString(slider2.getValue()));
		addSlider(slider3, listener3);
		setSlidervalue3(Integer.toString(slider3.getValue()));
		addSlider(slider4, listener4);
		setSlidervalue4(Integer.toString(slider4.getValue()));
		addSlider(slider5, listener5);
		setSlidervalue5(Integer.toString(slider5.getValue()));
		addSlider(slider6, listener6);
		setSlidervalue6(Integer.toString(slider6.getValue()));
		addSlider(slider7, listener7);
		setSlidervalue7(Integer.toString(slider7.getValue()));
		addSlider(slider8, listener8);
		setSlidervalue8(Integer.toString(slider8.getValue()));
		addSlider(slider9, listener9);
		setSlidervalue9(Integer.toString(slider9.getValue()));
		addSlider(slider10, listener10);
		setSlidervalue10(Integer.toString(slider10.getValue()));
		addSlider(slider11, listener11);
		setSlidervalue11(Integer.toString(slider11.getValue()));
		addSlider(slider12, listener12);
		setSlidervalue12(Integer.toString(slider12.getValue()));
		addSlider(slider13, listener13);
		setSlidervalue13(Integer.toString(slider13.getValue()));
		addSlider(slider14, listener14);
		setSlidervalue14(Integer.toString(slider14.getValue()));
		addSlider(slider15, listener15);
		setSlidervalue15(Integer.toString(slider15.getValue()));
		addSlider(slider16, listener16);
		setSlidervalue16(Integer.toString(slider16.getValue()));
		addSlider(slider17, listener17);
		setSlidervalue17(Integer.toString(slider17.getValue()));

		box.add(slider1);
		box.add(slider2);
		box.add(slider3);
		box.add(slider4);
		box.add(slider5);
		box.add(slider6);
		box.add(slider7);
		box.add(slider8);
		box.add(slider9);
		box.add(slider10);
		box.add(slider11);
		box.add(slider12);
		box.add(slider13);
		box.add(slider14);
		box.add(slider15);
		box.add(slider16);
		box.add(slider17);

		sliderBox.add(box);
		return sliderBox;
	}

	public void slidersInit() {
		listener1 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue1(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg1);
				System.out.println("serv1: " + mesg1);

			}
		};

		listener2 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue2(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg2);
				System.out.println("serv2: " + mesg2);

			}
		};

		listener3 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue3(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg3);
				System.out.println("serv3: " + mesg3);

			}
		};

		listener4 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue4(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg4);
				System.out.println("serv4: " + mesg4);

			}
		};

		listener5 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue5(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg5);
				System.out.println("serv5: " + mesg5);

			}
		};

		listener6 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue6(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg6);
				System.out.println("serv6: " + mesg6);

			}
		};

		listener7 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue7(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg7);
				System.out.println("serv7: " + mesg7);

			}
		};

		listener8 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue8(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg8);
				System.out.println("serv8: " + mesg8);

			}
		};

		listener9 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue9(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg9);
				System.out.println("serv9: " + mesg9);

			}
		};

		listener10 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue10(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg10);
				System.out.println("serv10: " + mesg10);

			}
		};

		listener11 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue11(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg11);
				System.out.println("serv11: " + mesg11);

			}
		};

		listener12 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue12(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg12);
				System.out.println("serv12: " + mesg12);

			}
		};

		listener13 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue13(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg13);
				System.out.println("serv13: " + mesg13);

			}
		};

		listener14 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue14(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg14);
				System.out.println("serv14: " + mesg14);

			}
		};

		listener15 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue15(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg15);
				System.out.println("serv15: " + mesg15);

			}
		};

		listener16 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue16(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg16);
				System.out.println("serv16: " + mesg16);

			}
		};

		listener17 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				setSlidervalue17(Integer.toString(source.getValue()));
				showVal.setText("当前滑动条的值为：" + mesg17);
				System.out.println("serv17: " + mesg17);

			}
		};

	}

	public void setSlidervalue1(String ss) {
		mesg1 = ss;
	}

	public String getSlidervalue1() {
		return mesg1;
	}

	public void setSlidervalue2(String ss) {
		mesg2 = ss;
	}

	public String getSlidervalue2() {
		return mesg2;
	}

	public void setSlidervalue3(String ss) {
		mesg3 = ss;
	}

	public String getSlidervalue3() {
		return mesg3;
	}

	public void setSlidervalue4(String ss) {
		mesg4 = ss;
	}

	public String getSlidervalue4() {
		return mesg4;
	}

	public void setSlidervalue5(String ss) {
		mesg5 = ss;
	}

	public String getSlidervalue5() {
		return mesg5;
	}

	public void setSlidervalue6(String ss) {
		mesg6 = ss;
	}

	public String getSlidervalue6() {
		return mesg6;
	}

	public void setSlidervalue7(String ss) {
		mesg7 = ss;
	}

	public String getSlidervalue7() {
		return mesg7;
	}

	public void setSlidervalue8(String ss) {
		mesg8 = ss;
	}

	public String getSlidervalue8() {
		return mesg8;
	}

	public void setSlidervalue9(String ss) {
		mesg9 = ss;
	}

	public String getSlidervalue9() {
		return mesg9;
	}

	public void setSlidervalue10(String ss) {
		mesg10 = ss;
	}

	public String getSlidervalue10() {
		return mesg10;
	}

	public void setSlidervalue11(String ss) {
		mesg11 = ss;
	}

	public String getSlidervalue11() {
		return mesg11;
	}

	public void setSlidervalue12(String ss) {
		mesg12 = ss;
	}

	public String getSlidervalue12() {
		return mesg12;
	}

	public void setSlidervalue13(String ss) {
		mesg13 = ss;
	}

	public String getSlidervalue13() {
		return mesg13;
	}

	public void setSlidervalue14(String ss) {
		mesg14 = ss;
	}

	public String getSlidervalue14() {
		return mesg14;
	}

	public void setSlidervalue15(String ss) {
		mesg15 = ss;
	}

	public String getSlidervalue15() {
		return mesg15;
	}

	public void setSlidervalue16(String ss) {
		mesg16 = ss;
	}

	public String getSlidervalue16() {
		return mesg16;
	}

	public void setSlidervalue17(String ss) {
		mesg17 = ss;
	}

	public String getSlidervalue17() {
		return mesg17;
	}

	public JTextField getShowval() {
		return showVal;
	}

	public void addSlider(JSlider slider, ChangeListener listener) {

		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 设置绘制刻度标签，默认绘制数值刻度标签
		slider.setPaintLabels(true);

		slider.addChangeListener(listener);

		// box.add(new JLabel(description + "："));

	}

}
