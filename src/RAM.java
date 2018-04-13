
public class RAM {

	Queue<PCB> job = new Queue<>();
	Queue<Process> buffer = new Queue<>();
	Queue<PCB> ready = new Queue<>();
	private int sizeRAM = 0;
	private int available = 0 ;
	private HD h;

	public RAM(int sizeRAM) {
		this.sizeRAM = (sizeRAM*1024);
		this.available = this.sizeRAM - (32*1024);
		h =  new HD(10*1024*1024);
		// print number of process in HD
		System.out.println(h.jop.size());
		System.out.println("==============================");

	}

	// this method for get process from HD less than or equal 160MB
	public void jopScheduling() {
		boolean flag = true;
		for(;flag && !h.jop.isEmpty();) {
			Process p ;
			if(!buffer.isEmpty())
				p = buffer.dequeue();
			else
				p = h.jop.dequeue();
			if(p.getSz() <= available) {
				available -=p.getSz();
				PCB pcb = new PCB(p.getId(),p.getCpu(),p.getSz(),"new");
				job.enqueue(pcb);
			}
			else { 
				flag = false;
				buffer.enqueue(p);
			}
		}
	}

	
	
	// Print PCB in RAM
	public void print() {
		int ramSize = 0;
		int i ;
		for(i = 0 ; !job.isEmpty() ; i++) {
			PCB p = job.dequeue();
			System.out.println("id:"+p.getId()+", cpu:"+p.getCpu()+", sz:"+p.getSize()+" state: "+p.getState());
			ramSize += p.getSize();
		}
		System.out.println(ramSize/1024+"MB");
		System.out.println("=============================="+i+"==============================");
		available = this.sizeRAM - (32*1024);
	}

	
	
	
	
	
	
	
	// for sort PCB in ready queue order by smallest time
	public void sortBySize() {
		PCB[] pcb = new PCB[job.size()];
		int npcb = job.size();
		for(int i = 0 ; i <job.size() ; i++) {
			pcb[i] = job.dequeue();
			job.enqueue(pcb[i]);
			System.out.println("id:"+pcb[i].getId()+", cpu:"+pcb[i].getCpu()+", sz:"+pcb[i].getSize()+" state: "+pcb[i].getState());
		}
		for (;!(npcb == 0 );) {
			int min = 0 ;
			for(int i = 1 ; i < npcb; i++ ) {
				if( pcb[min].getCpu() > pcb[i].getCpu())
					min = i;
			}
			PCB p =  pcb[min] ;
			p.setState("ready");
			pcb[min] = pcb[npcb-1];
			ready.enqueue(p);
			npcb--;
		}
	}
	
	// put process in ready queue with change state to "ready"
	public void shortScheduling() {
		
	}
	
}
