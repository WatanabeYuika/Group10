public class TestSandL{
    public static void main(String args[]){
	int i,j;
	String str;
	
        /* i=5;
	j=5;
	str="test1.txt"; //case1 */

	i=3;
	j=5;
	str="text2.csv";//case2

	SandL sl=new SandL(i,j,str);
	sl.loadFile();
	
	for(int m=0;m<i;m++){
	    for(int n=0;n<j;n++){
		System.out.println(sl.data[m][n]);
	    }
	}

	System.out.println("======================");

	int kari;
	String karis;
	for(int m=0;m<i;m++){
	    for(int n=0;n<j;n++){
		kari=(int)(Math.random()*10);
		karis=String.valueOf(kari);
		sl.data[m][n]=karis;
	    }
	}

	for(int m=0;m<i;m++){
	    for(int n=0;n<j;n++){
		System.out.println(sl.data[m][n]);
	    }
	}

	sl.saveFile();
    }
}
