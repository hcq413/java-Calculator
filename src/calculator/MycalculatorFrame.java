package calculator;


import java.awt.BorderLayout;      
import java.awt.Color;
import java.awt.Container;  
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MycalculatorFrame extends JFrame implements ActionListener{
	
	boolean flagIn=true;
    double pre,later;
    char operator=' ';
  
    String r;
	String buttonNames[][]={{"MC","MR","MS","M+","M-"},
			{"←","CE","C","±","√"},{"7","8","9","/","%"},
			{"4","5","6","*","1/x"},{"1","2","3","-","="},
			{"0",".","+"}};
	
	JButton[][] button=new JButton[buttonNames.length][];
	JTextField Result=new JTextField("0");

	GridBagConstraints constraints=new GridBagConstraints();
    GridBagLayout bgla=new GridBagLayout();

	public MycalculatorFrame() {
	this.setTitle("计算器");
		setBak();         //调用背景方法
		Container c = getContentPane(); //获取JFrame面板
		JPanel jp = new JPanel();      //创建个JPanel
		jp.setOpaque(false);           //把JPanel设置为透明，这样就不会遮住后面的背景，就能在JPanel随意加组件了
	    c.add(jp);
		
		jp.setLayout(new BorderLayout());
		jp.setBorder(BorderFactory.createEmptyBorder(20, 10, 5, 5));
		Result.setFont(new Font("楷体",Font.BOLD,30));
		Result.setPreferredSize(new Dimension(400, 60));
		Result.setHorizontalAlignment(JTextField.CENTER);
		Result.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,0,0)));
		jp.add(Result);
	
		Result.setEditable(false);
		
		c.add(jp,BorderLayout.NORTH);
	
        JPanel jp2=new JPanel();
		jp2.setOpaque(false);
		jp2.setLayout(bgla);
      
		
		
		constraints.insets=new Insets(0,0,5,5);
		constraints.fill=GridBagConstraints.BOTH;
		
		for(int i=0;i<buttonNames.length;i++)
		{
			button[i]=new JButton[buttonNames[i].length];
		
			constraints.gridy=i;
			
				
				
			
			
			for(int j=0;j<button[i].length;j++)
			{
				
			
				button[i][j]=new JButton(buttonNames[i][j]);
				 
				
				button[i][j].setBackground(Color.blue);
				button[i][j].setForeground(Color.white);
				button[i][j].setFont(new Font("楷体",Font.BOLD,15));
			    button[i][j].addActionListener(this);
	   
				constraints.gridx=j;
				
				
				if(i==4 && j==4)
				{
					constraints.gridheight=2;
				}
				else if(i==5 && j==0)
				{
					constraints.gridwidth=2;
				}
				else if(i==5 && j>0)
				{
					constraints.gridx=j+1;
				}
				
			
				bgla.setConstraints(button[i][j], constraints);
				jp2.add(button[i][j]);
				
			
				constraints.gridheight=1;
				constraints.ipadx=10;
				constraints.ipady=8;
				constraints.gridwidth=1;
			}
		}
		
		c.add(jp2,BorderLayout.CENTER);
		
		setSize(500, 400);
		this.setIconImage(this.getToolkit().getImage("image//bg2.jpg"));
		
		this.addWindowListener(new Handler());
			
				
		//居中显示窗口
		int windowWidth=this.getWidth();
		int windowHeight=this.getHeight();
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		this.setLocation(screenWidth/2-windowWidth/2,screenHeight/2-windowHeight/2);
	
		setVisible(true); 
	} 
	
	class Handler implements WindowListener
	{

		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
			if(javax.swing.JOptionPane.showConfirmDialog(null, "   主人不要我了吗   *_* ??!    ")==JOptionPane.YES_OPTION)
				System.exit(0);
			
		}

		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon(getClass().getResource(
                "bg.jpg")); //添加图片
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
String counter=e.getActionCommand();
		
		
		if(counter.length()==1)
		{
			
				
			
			char ch=counter.charAt(0);
			
			switch(ch)
			{
			case '0':
				if(flagIn==false)
					{
					Result.setText(Result.getText()+counter);
					
					
					}
				else
					{
					Result.setText(counter);
					
					}
				
				break;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				if(flagIn==true)
				{
					Result.setText(counter);
					
					flagIn=false;
				}
				else
					{
					Result.setText(Result.getText()+counter);
					
					}
				break;
			case '.':
				if(flagIn==true&&!Result.getText().contains("."))
				{
					Result.setText("0.");
					
					flagIn=false;
				}
				else if(flagIn==false&&!Result.getText().contains("."))
					
					{
					Result.setText(Result.getText()+counter);
					
					}
					else if(Result.getText().contains("."))
					    return;
				break;
		
				
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
				pre=Double.parseDouble(Result.getText());
				operator=ch;
				flagIn=true;
				break;
			case '=':
				later=Double.parseDouble(Result.getText());
				count();
				flagIn=true;
				break;
			case '←':
				String s=Result.getText();
				s=s.substring(0,s.length()-1);
				if(s.equals(""))    s="0";
				{
					Result.setText(s);
					
				}
				
				flagIn=true;
				break;
			case 'C':
				Result.setText("0");
				
				pre=0;
				later=0;
				operator=' ';
				flagIn=true;
				break;
			case '±':
				String re=Result.getText();
				if(Integer.valueOf(re)>0)
				Result.setText("-"+re);
				else if(Result.getText().contains("-"))
				Result.setText(re.replaceAll("-", "+"));
				
				else if (Integer.valueOf(re)<0)
					Result.setText("+"+re);
				else if(Result.getText().contains("+"))
					Result.setText(re.replaceAll("+", "-"));
				
				
			
				
			}
			
				
		}
		else if(counter.equals("CE"))
		{
			Result.setText("0");
			
			flagIn=true;
		}
		else if(counter.equals("MS"))
		{
			 r=Result.getText();
		}
		else if(counter.equals("MR"))
		{
			Result.setText(r);
		}
		else if(counter.equals("M+"))
		{
			String rr=Result.getText();
			Result.setText(String.valueOf(Integer.valueOf(r)-Integer.valueOf(rr)));
		}
		else if(counter.equals("M-"))
		{
			String rr=Result.getText();
			Result.setText(String.valueOf(Integer.valueOf(r)+Integer.valueOf(rr)));
		}
		}
		
	

		
	
	public void count()
	{
		double result=0;
		
		switch(operator)
		{
		
		case '+':
			result=pre+later;
			break;
		case '-':
			result=pre-later;
			break;
		case '*':
			result=pre*later;
			break;
		case '/':
			result=pre/later;
			break;
		case '%':
			result=pre%later;
			
			break;
		}
		Result.setText(String.valueOf(result));
		
	}
	
	
} 
