import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class file {
	
	
	public static PCB[] load() throws FileNotFoundException {
		
	PCB arr[]=new PCB[10000];
	Scanner File =new Scanner(new File("data-file.txt"));
	int i=0;
	int sum = 0 ;
	
	while (File.hasNextLine()){
		String line=File.nextLine();
		String [] id= line.split("ID:");
		String [] id2=id[1].split(";");
		
		String [] cpu= line.split("CPU:");
		String [] cpu2= cpu[1].split(";");
		
		
		String [] size= line.split("SZ:");
		
		System.out.print(id2[0]+" ");
		System.out.print(cpu2[0]+" ");
		System.out.println(size[1]+" ");
		
		int Intid = Integer.parseInt(id2[0]);
		int Intcpu = Integer.parseInt(cpu2[0]);
		int Intsize = Integer.parseInt(size[1]);
		//PCB pcb = new PCB(Intid,Intcpu,Intsize);
		sum+=Intsize ; 
		//arr[i]=pcb;
		i++;
}
	System.out.println(sum/ 1024);
	return arr;
}
	

}