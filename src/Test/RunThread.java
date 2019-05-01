package Test;

public class RunThread extends Thread{
	private CellTable ct;
	
	public RunThread(CellTable ct)
	{
		this.ct=ct;
	}
	public void change()
	{
		ct.changePause();
	}

	@Override
	public void run() 
	{
	// TODO 自动生成的方法存根
		while(ct.isPause()) 
		{
		try {
				ct.once();
				Thread.sleep(Config.freshtime);
			} catch (InterruptedException e)
		    {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
			
	}
}
	


