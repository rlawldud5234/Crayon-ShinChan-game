package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test_main {
	private FileReader in; 
	private FileWriter out; 
	private char[] ch; 
	
	public Test_main() {
		main();
	}

	public void main() { 
		System.out.println("Start!");
		do {
		System.out.println("What is your choice?");
		System.out.println("1.load 2.write 3.save");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int choice=0;
		try { 
			choice = Integer.parseInt(bf.readLine());
			if(choice<1||choice>3) {
				throw new Exception(); 
			}else {
				if(choice==1) { 
					in = load(); 
				}else if(choice==2) {
					write();
				}else {
					if(save()) { break; }
				}				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Hmm... this is not 1 to 3");
			continue;
		}
		}while(true);
	}

	private boolean save() {
		Scanner scan = new Scanner(System.in);
		int tOrf; 
		String str; 
		int fileReadYS=0; 
		if(in instanceof FileReader) {
			System.out.println("There is the file you read before.");
			System.out.println("Do you want to save read file together?");
			System.out.println("1. yes, I want to save the file together 2. no, I don't want to save the file together");
			fileReadYS = scan.nextInt(); 
			scan.nextLine();
		}
		
		System.out.println("Input new txt file name or already exist name.");  

		str = scan.nextLine();
			try {
				if(fileReadYS==1) {
					out =new FileWriter("C:\\\\java\\"+str+".txt",true);
					int fileReadNumber;
					while((fileReadNumber=in.read())!=-1) {
						out.write(fileReadNumber);
					}
				}else {out = new FileWriter("C:\\\\java\\"+str+".txt");}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
		for(int i=0;i<ch.length;i++) {
				out.write(ch[i]);
		}  
		out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Do you want to End this Program? 1. yes 2. no");
		tOrf=scan.nextInt();
		scan.nextLine();
		if(tOrf==1) {
			return true;
		}else {return false;}
	}

	private void write() { 
		int i;
		String j;
		System.out.println("If you hit enter, It will be input");
		Scanner scan = new Scanner(System.in);
		j=scan.nextLine();
		ch = new char[j.length()];
		for(int p=0;p<j.length();p++) {
			ch[p]=j.charAt(p);
		}
	}
	
	private FileReader load() { 
		do {
		System.out.println("Input the name of txt file");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		FileReader in;
		try {
			in = new FileReader("C:\\\\java\\"+fileName+".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("There is no name you entered.");
			continue;
		}
		return in;
		}while(true);
	}
}