import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;


class Jugyou {
    private String kamoku; //授業名
    private String tani; //各授業の取得可能単位数

    Jugyou(String str){
        String[] re = str.split(",", 2);
        this.kamoku   = re[0];
        this.tani     = re[1];
    }
    

    public String toString(){
        return kamoku + " 単位数:" + tani;
    }
}

class test2 {
    static Jugyou[] kijiku = new Jugyou[31];
    static Jugyou[] gendai = new Jugyou[23];
    static Jugyou[] ryugaku = new Jugyou[7];
    static Jugyou[] rikei = new Jugyou[58];
    static Jugyou[] kyosyoku = new Jugyou[23];
    static Jugyou[] kyoutu = new Jugyou[22];
    
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        String str;
        int a = 0;
        String b = "0"; 

        while(a != -1){
            int g = 0;
            System.out.print("科目区分:" + "\n"
                                     + "基軸教育科目...1" + "\n"
                                     + "現代教養科目...2" + "\n"
                                     + "留学生科目...3" + "\n"
                                     + "教養等資格科目...4" + "\n"
                                     + "理系科目...5" + "\n"
                                     + "学部共通科目...6" + "\n");
            a = stdIn.nextInt();

            if(a==1){
                try {
                    File file  = new File("基軸教育科目.csv");
                    Scanner sc = new Scanner(file);
                    System.out.println("基軸教育科目");
                

                    while(sc.hasNextLine()){
                        str = sc.nextLine();               
                        String[] re = str.split(",", 0);
                        Jugyou kijiku = new Jugyou(str);
                        System.out.print(kijiku);
                        System.out.print("\n");
                        g = 1;
                    }
                    System.out.println("");
                } catch (FileNotFoundException e){
                    System.err.print(e);
                }
            }
            if(a==2){
                try {
                    File file  = new File("現代教養科目.csv");
                    Scanner sc = new Scanner(file);
                    System.out.println("現代教養科目");
                

                    while(sc.hasNextLine()){
                        str = sc.nextLine();               
                        String[] re = str.split(",", 0);
                        Jugyou gendai = new Jugyou(str);
                        System.out.print(gendai);
                        System.out.print("\n");
                        g = 1;
                    }
                    System.out.println("");
                } catch (FileNotFoundException e){
                    System.err.print(e);
                }

            }
            if(a==3){
                try {
                    File file  = new File("留学生科目.csv");
                    Scanner sc = new Scanner(file);
                    System.out.println("留学生科目");
                

                    while(sc.hasNextLine()){
                        str = sc.nextLine();               
                        String[] re = str.split(",", 0);
                        Jugyou ryugaku = new Jugyou(str);
                        System.out.print(ryugaku);
                        System.out.print("\n");
                        g = 1;
                    }
                    System.out.println("");
                } catch (FileNotFoundException e){
                    System.err.print(e);
                }

            }
            if(a==4){
                try {
                    File file  = new File("理系科目.csv");
                    Scanner sc = new Scanner(file);
                    System.out.println("理系科目");
                

                    while(sc.hasNextLine()){
                        str = sc.nextLine();               
                        String[] re = str.split(",", 0);
                        Jugyou rikei = new Jugyou(str);
                        System.out.print(rikei);
                        System.out.print("\n");
                        g = 1;
                    }
                    System.out.println("");
                } catch (FileNotFoundException e){
                    System.err.print(e);
                }

            }
            if(a==5){
                try {
                    File file  = new File("教職等資格科目.csv");
                    Scanner sc = new Scanner(file);
                    System.out.println("教職等資格科目");
                

                    while(sc.hasNextLine()){
                        str = sc.nextLine();               
                        String[] re = str.split(",", 0);
                        Jugyou kyosyoku = new Jugyou(str);
                        System.out.print(kyosyoku);
                        System.out.print("\n");
                        g = 1;
                    }
                    System.out.println("");
                } catch (FileNotFoundException e){
                    System.err.print(e);
                }

            }
            if(a==6){
                try {
                    File file  = new File("学部共通科目.csv");
                    Scanner sc = new Scanner(file);
                    System.out.println("学部共通科目");
                

                    while(sc.hasNextLine()){
                        str = sc.nextLine();               
                        String[] re = str.split(",", 0);
                        Jugyou kyoutu = new Jugyou(str);
                        System.out.print(kyoutu);
                        System.out.print("\n");
                        g = 1;
                    }
                    System.out.println("");
                } catch (FileNotFoundException e){
                    System.err.print(e);
                }

            }
            if(a==-1){
                System.out.print("exit!");
                System.out.print("\n");
            }else{
                if(g == 0){
                    System.out.print("not faund");
                    System.out.print("\n");
                }
            }
        }
    }   
}