package unclassified;

import java.io.*;

/**
 * @author DIO的面包店
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
//        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\DIO的面包店\\Desktop\\test.txt");
            System.out.println(fis.read());
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine().substring(2);
            while (str != null){
                System.out.println(str);
                str = br.readLine();
            }

            br.close();
            isr.close();
            fis.close();

            short a =1;
//            a = a+1;
            a+=1;
            a = (short) (a+1);
            byte b = (byte) (127+10);
        System.out.println(b);
        String st = "n";
        System.out.println();

        st = st +"";
        System.out.println(st.hashCode());


//            b = b+10;

//            Reader reader = new InputStreamReader(fis);
//            System.out.println(reader.read());

//            FileReader fr = new FileReader("D:\\文件集\\FJava八股文\\Java八股文\\200道java面试题资料.pdf");
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//            String[] arrs = null;
//            while ((line = br.readLine()) != null){
//                arrs = line.split(",");
//                System.out.println(arrs[0] + " : " + arrs[1] + " : " +arrs[2] );
//            }
//            br.close();
//            isr.close();
//            fis.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }




}
