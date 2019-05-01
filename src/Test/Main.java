package Test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Main extends JFrame 
{

	private CellTable ct;
	private JButton run=new JButton();
    private RunThread b;
    private ControlPnl cpnl;
	public Main() {		
		 
		ct = new CellTable();
	    ct.setPreferredSize(new Dimension(800,800));
	    cpnl=new ControlPnl(ct,this);
		cpnl.setPreferredSize(new Dimension(800,100));
	    setTitle("小剑生命游戏");
	    try {
			ct.setTablebyfile("滑翔机枪");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        setLayout(new BorderLayout());
        

        add(BorderLayout.WEST,cpnl);
        add(BorderLayout.SOUTH,ct);
        ControlPnl.setcnttext();
        ControlPnl.settimestext();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
     
	}
	public static void main(String[] args) {


		Main m = new Main();
		m.setSize(850,900);
		m.setVisible(true);

	}
}
