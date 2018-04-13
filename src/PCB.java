
public class PCB {

	private int id;
	private int cpu;
	private int size;
	private String state;
	
	public PCB(int id,int cpu,int size , String state) {
		this.id=id;
		this.cpu=cpu;
		this.size=size;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
