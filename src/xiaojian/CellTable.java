package xiaojian;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JPanel;


public class CellTable extends JPanel { //z
  private int row = 100;//
  private int col = 100; //设置行列，默认100*100
  private Cell[][] cell;

  
  public CellTable() {
    setTable(row,col);  
  }
  public int Getrow() {
	return row; 
  }
  public int Getcol() {
	return col;
  }
 /**
  * 
  * @param row
  * @param col
  */
  public void setTable(int row,int col)
 	{
	    this.removeAll();
	    this.setVisible(false);
 		this.row=row;
 		this.col=col;
 		this.removeAll();
 		cell=new Cell[row][col];
 		setLayout(new GridLayout(row,col,0,0));
      for(int i=0;i<row;i++)
      {
          for(int j=0;j<col;j++)
          {
              cell[i][j]=new Cell();
              add(cell[i][j]);
          }
      }
      this.validate();
      this.setVisible(true);
 	}
 
	 public Cell getCell(int i,int j)
	 {
		 return cell[i][j];
	 }
	 


	 
	 
public void updatecolor()
{
	for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
        	if(cell[i][j].isAlive()) cell[i][j].makeAlive();
	 ControlPnl.setcnttext();
	 ControlPnl.settimestext();
}

}
