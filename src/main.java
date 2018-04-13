import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import java.io.*;
import java.util.Random;

public class main {

	public static void main(String[] args) throws FileNotFoundException {

		//file l = new file();
		//l.load();

	//	HD h = new HD(10000000);
		//h.print();

RAM ram = new RAM(192);

ram.jopScheduling();
//ram.print();
ram.sortBySize();
	}



}

