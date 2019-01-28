import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;


class Jugyou {
    private String num;  // 授業名検索コード
    private String kamoku; //授業名
    private String tani; //各授業の取得可能単位数

    Jugyou(String str){
        String[] re = str.split(",", 3);
        this.num      = re[0];
        this.kamoku   = re[1];
        this.tani     = re[2];
    }
    

    public String toString(){
        return kamoku + "" + " 単位:" + tani;
    }
}

class test {
    static Jugyou[] jugyou = new Jugyou[164];
    
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        String str;
        String compare = "0";

        while(compare.compareTo("-1") != 0){
            int g = 0;
            System.out.print("授業コード:");
            compare = stdIn.nextLine();
            try {
                File file  = new File("単位.csv");
                Scanner sc = new Scanner(file);
                

                while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);          
                    if (re.length == 3){
                        
                        if(compare.compareTo(re[0]) == 0 ){
                            Jugyou jugyou = new Jugyou(str);
                            System.out.print(jugyou);
                            System.out.print("\n");
                            g = 1;
                        }
                    }    
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            if(compare.compareTo("-1") != 0 ){
                if(g == 0){
                    System.out.print("not faund");
                    System.out.print("\n");
                }
            }else{
                System.out.print("exit!");
                System.out.print("\n");
            }
        }
    }   
}