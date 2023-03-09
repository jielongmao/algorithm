package unclassified;

import java.util.Scanner;

/**
 * @author DIO的面包店
 * @since 2022/5/25 12:32
 */
public class OD3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int zuo = 1;
        int you = 2;
        int qian = 3;
        int hou = 4;
        int shang = 5;
        int xia = 6;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'L'){
                int tmp = shang;
                shang = you;
                you = xia;
                xia =zuo;
                zuo = tmp;
            }else if(arr[i]=='R'){
                int tmp = shang;
                shang =zuo;
                zuo =xia;
                xia =you;
                you =tmp;
            }else if(arr[i]=='F'){
                int tmp = shang;
                shang = hou;
                hou =xia;
                xia =qian;
                qian =tmp;
            }else if(arr[i]=='B'){
                int tmp = shang;
                shang =qian;
                qian =xia;
                xia =hou;
                hou =tmp;
            }else if(arr[i]=='A'){
                int tmp =qian;
                qian =zuo;
                zuo = hou;
                hou = you;
                you = tmp;
            }else if(arr[i]=='C'){
                int tmp =qian;
                qian = you;
                you = hou;
                hou = zuo;
                zuo = tmp;
            }
        }
//        System.out.println(zuo+you+qian+hou+shang+xia);
        System.out.print(zuo);
        System.out.print(you);
        System.out.print(qian);
        System.out.print(hou);
        System.out.print(shang);
        System.out.print(xia);


    }

}
