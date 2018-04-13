import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HD {
	public int size;
	private int sumSize ;
	//public PCB arr[];
	Process [] process ;
	int nProcess ;
	Queue<Process> jop = new Queue<>();
	//public PCB arr[];
	Random rand = new Random();

	
// here generate process in HardDisk with size 0.5G 
	public HD (int size) {
		process = new Process[1000];
		nProcess = 0;
		boolean flag = true ;
		for(int i = 0 ; flag ;i++) {
			int  sz = rand.nextInt(16384) + 16;
			sumSize +=sz;
			if(sumSize <= size * 0.05) {
				int cpu = rand.nextInt(200) + 16;
				process[nProcess++] =new Process(i , cpu , sz);
			}
			else flag = false ;
		}
		sortBySize();
	}

	// for print process Information ( id , CpuTime , size)
	public void print() {
		int ramSize = 0;
		for(int i = 0 ; !jop.isEmpty() ; i++) {
			Process p = jop.dequeue();
			System.out.println("id:"+p.getId()+", cpu:"+p.getCpu()+", sz:"+p.getSz());
		    ramSize += p.getSz();
		}
	}


	// for sort process in queue order by smallest size
	public void sortBySize() {
		int n = nProcess;
		for (;!(nProcess == 0 );) {
			int min = 0 ;
			for(int i = 1 ; i < nProcess; i++ ) {
				if( process[min].getSz() > process[i].getSz())
					min = i;
			}
			Process p =  process[min] ;
			process[min] = process[nProcess-1];
			jop.enqueue(p);
			nProcess--;
		}
	}
}

