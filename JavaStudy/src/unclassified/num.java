package unclassified;

/**
 * @author DIO的面包店
 * @since 2022/5/28 17:14
 */
public class num {

    public static void main(String[] args) {
        String s = "w6y2e2jq32w321oe342d3owq";
        char[] chars = s.toCharArray();
        String tmp = "";
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])){
                tmp += chars[i];
                if(i+1==chars.length || !Character.isDigit(chars[i+1])){
                    res += Integer.parseInt(tmp);
                    tmp = "";
                }
            }
        }
        System.out.println(res);
    }
}
