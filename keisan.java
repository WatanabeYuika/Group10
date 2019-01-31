import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


class keisan {
    public int s_htani = 0; //必修単位      //専門
    public int s_shtani = 0; //選択必修単位
    public int s_stani = 0; //選択単位
    public int k_htani = 0; //必修単位      //共通
    public int k_shtani = 0; //選択必修単位
    public int k_stani = 0; //選択単位
    
    public void getTani(String a, String b, int k){
        String q = "共通";
        String w = "専門";
        String e = "必修";
        String r = "選択必修";
        String t = "選択";
    
        if(a.compareTo(q) == 0){ //共通
            if(b.compareTo(e) == 0){ //必修
                k_htani += k; 
            }else if(b.compareTo(r) == 0){ //選択必修
                k_shtani += k;
            }else if(b.compareTo(t) == 0){ //選択
                k_stani += k;
            }
        }else if(a.compareTo(w) == 0){ //専門
            if(b.compareTo(e) == 0){ //必修
                s_htani += k;
            }else if(b.compareTo(r) == 0){ //選択必修
                s_shtani += k;
            }else if(b.compareTo(t) == 0){ //選択
                s_stani += k;
            }
        }
    }    
}