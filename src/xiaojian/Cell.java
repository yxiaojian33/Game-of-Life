package xiaojian;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Cell extends JButton implements MouseListener {
  private static final long serialVersionUID = 1L; 
  private boolean isalive = false;
  
  /**
   * 初始细胞，默认细胞死亡
   * 并为其添加鼠标事件，点击改变存活状态.
  */ 
  public Cell() {
    setBackground(ConfigUtils.death);
    this.addMouseListener(this);
    
  }
  
  public boolean isAlive() {
    return isalive;
    
  }

  /**
   * 使细胞存活.
  */ 
  public void makeAlive() {
    isalive = true;
    setBackground(ConfigUtils.alive);
    
  }
  
  /**
   * 使细胞死亡.
  */ 
  public void makeDie() {
    isalive = false;
    setBackground(ConfigUtils.death);

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO 自动生成的方法存根
 
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO 自动生成的方法存根
    if (isalive) {
      setBackground(ConfigUtils.death);
      isalive = false;
  }
	else 
	{
		setBackground(ConfigUtils.alive);
		isalive=true;
	}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
