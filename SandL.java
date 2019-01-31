import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SandL{
    public String filename;
    public String[][] data;
    public File file;   

    SandL(int koma,int youbi,String filename){
	this.filename = filename;
	data = new String[koma][youbi];
	file = new File(filename);        
    }

    public void loadFile(){
	try{
	    Scanner sc = new Scanner(file);

	    for(int i=0;i<data.length;i++){
		for(int j=0;j<data[i].length;j++){
		    data[i][j] = sc.nextLine();
		}
	    }
	}catch(IOException e){
	    System.err.print(e);
	}
    }

    public void saveFile(){
	try{
	    FileWriter fw = new FileWriter(filename);
	    PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

	    for(int i=0;i<6;i++){
		for(int j=0;j<5;j++){
		    pw.println(data[i][j]);;
		}
	    }
	    pw.close();
	}catch(IOException e){
	    System.err.print(e);
	}
    }

    public void save2File(){
	try{
	    FileWriter fw = new FileWriter(filename);
	    PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
	    for(int i=0;i<6;i++){
		for(int j=0;j<5;j++){
		    pw.println(data[i][j]);;
		}
	    }
	    pw.close();
	}catch(IOException e){
	    System.err.print(e);
	}
    }
}

    
	
	
	
