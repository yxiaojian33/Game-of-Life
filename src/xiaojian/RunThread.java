package xiaojian;

public class RunThread extends Thread{
	private CellTableAdapter adapter;
	
	public RunThread (CellTableAdapter adapter)
	{
		this.adapter=adapter;
	}
	public void change()
	{
		adapter.changePause();
	}

	@Override
	public void run() 
	{
	// TODO 自动生成的方法存根
		while(adapter.isPause()) 
		{
		try {
			adapter.once();
				Thread.sleep(ConfigUtils.freshtime);
			} catch (InterruptedException e)
		    {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
			
	}
}
	


