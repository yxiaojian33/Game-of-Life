package xiaojian;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Main extends JFrame {
  private static final long serialVersionUID = 1L; 
  private CellTable ct;
  private CellTableAdapter adapter;
  private ControlPnl cpnl;
  
  /**
  * 2019/5/5 created by xiaojian
  ***** 主界面构造
  由ControlPnl和CellTable两部分组成.
  */ 
  public Main() {
    ct = new CellTable();
    ct.setPreferredSize(new Dimension(800,800));
    adapter=new CellTableAdapter(ct);
    cpnl = new ControlPnl(adapter,this);
    cpnl.setPreferredSize(new Dimension(800,100));
    setTitle("小剑生命游戏");
    try {
    	adapter.setTablebyfile("滑翔机枪");
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
  
  /**
   * 程序入口.
   */ 
  public static void main(String[] args) {
    Main m = new Main();
    m.setSize(850,900);
    m.setVisible(true);
    
  }
  
}
