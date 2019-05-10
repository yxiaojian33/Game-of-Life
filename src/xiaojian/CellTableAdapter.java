package xiaojian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CellTableAdapter {
	private static CellTable ct;
	private boolean pause;
	private int times = 0;//繁衍次数;
	private int [][] number;
	public CellTableAdapter(CellTable ct)
	{
		this.ct=ct;
	}
	public CellTable GetCellTable()
	{
		return ct;
	}
	 public boolean isPause()
	 {
		 return pause;
	 }
	 
	 public boolean changePause()
	 {
		 pause=pause?false:true;
		 return pause;
	 }
	 public int Gettimes() {
		 return times;
	 }
    public void clean()
    {
   	 times=0;//清空繁衍次数
   	 ControlPnl.cnt.setText("0");
   	 ControlPnl.times.setText("0");
   	 for(int i=0;i<ct.Getrow();i++)
	            for(int j=0;j<ct.Getcol();j++)
	            	ct.getCell(i, j).makeDie();
    }
    public void setTablebyfile(String path) throws Exception
	 {
		 File file1 = new File("./Shape/"+path+".txt"); // 创建File类对象		
		 FileInputStream fis = new FileInputStream(file1); // 创建FileInputStream类对象读取File	
		 InputStreamReader isr =  new InputStreamReader(fis);	 // 创建InputStreamReader对象接收文件流	
		 BufferedReader br =br = new BufferedReader(isr);	 // 创建reader缓冲区将文件流装进去		
		 String lineTxt = null;			// 从缓冲区中逐行读取代码，调用readLine()方法	
		 this.clean();//清空细胞群布局，使所有细胞死亡
		 while ((lineTxt = br.readLine()) != null)
		 {	
			String array[]=lineTxt.split(" ") ;
			int first= Integer.valueOf(array[0])>=0?Integer.valueOf(array[0]):ct.Getrow()+Integer.valueOf(array[0]);
			int second= Integer.valueOf(array[1])>=0?Integer.valueOf(array[1]):ct.Getcol()+Integer.valueOf(array[1]);
			try
			{
				ct.getCell(first,second).makeAlive();
			}catch(ArrayIndexOutOfBoundsException e)
			{
				throw new Exception("细胞生活区不足");
			}
		 }
		 
	 }
    public void getNumber()
    {
    	number=new int[ct.Getrow()][ct.Getcol()];
   	 	for(int i=0;i<ct.Getrow();i++)
   	 	{
	            for(int j=0;j<ct.Getcol();j++)
	            {
	                number[i][j]=getNearNumber(i,j);//number是周围活细胞的个数
	               
	            }
	        }
    }
    public int getNearNumber(int i,int j) {
   	 int num=0;
   	 for(int z=i-1;z<i+2;z++)
        {
            for(int y=j-1;y<j+2;y++)
            {
                if(z<0||z>=ct.Getrow()||y<0||y>=ct.Getcol()){continue;}//边界越界
                if(ct.getCell(z, y).isAlive())
                    num++;
            }
        }
        //如果自身是活细胞的话，number需要-1
        if(ct.getCell(i, j).isAlive())
            num--;
		return num;
    }
    public int getCount()
    {
   	 int cnt=0;
   	 for(int i=0;i<ct.Getrow();i++)
	            for(int j=0;j<ct.Getcol();j++)
	            	if(ct.getCell(i, j).isAlive()) cnt++;
		return cnt;
   	 
    }

	 public void once(){
		 times++;
		 getNumber();
		 int cnt=0;
	        //周围活细胞的个数在上下限内，则变为活细胞，否则变成死细胞
		 for(int i=0;i<ct.Getrow();i++)
	        {
	            for(int j=0;j<ct.Getcol();j++)
	            {
	                switch(number[i][j])
	                {

	                    case 2:
	                        break;//不变
	                    case 3:
	                    	ct.getCell(i, j).makeAlive();
	                        break;
	                    default:
	                    	ct.getCell(i, j).makeDie();;
	                }
	            }
	        }
		 ControlPnl.setcnttext();
		 ControlPnl.settimestext();
	    }
}
