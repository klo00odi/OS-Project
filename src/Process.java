
public class Process  {
	private int id ;
	private int cpu ;
	private int sz ;

	public Process(int id , int cpu , int sz) {
		// TODO Auto-generated constructor stub
		this.id = id ;
		this.cpu=cpu;
		this.sz=sz;
	
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSz() {
		return sz;
	}

	public void setSz(int sz) {
		this.sz = sz;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getCpu() {
		return cpu;
	}
}
