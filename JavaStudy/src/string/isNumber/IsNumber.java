package string.isNumber;

/**
 * @Description 有效数字 leetcode65
 * @Author: tmj
 * @Data: 2023/9/19 12:12
 */
public class IsNumber {
    public static void main(String[] args) {
        String s = new String("6e6.5");
        System.out.println(isNumber(s));

    }
    public static boolean isNumber(String s) {
        if(s.charAt(s.length()-1) == 'e' || s.charAt(s.length()-1) == 'E' ){
            return false;
        }
        String[] es = s.split("e|E");
//        // 分成了两个以上直接错误
//        if(es.length > 2){
//            return false;
//        }
        if (es.length == 1){
            return validateNumer(s,false);
        }
        if (es.length == 2){
            if(es[0].length() == 0){
                return false;
            }else {
                boolean left = validateNumer(es[0],false);
                boolean right = validateNumer(es[1],true);
                return left && right;
            }

        }
        return false;
    }

    private static boolean validateNumer(String s ,boolean isInt){
        int length = s.length();
        int jiajian = 0;
        int dian = 0;
        for(int i = 0 ; i< length; i++){
            if('+' == s.charAt(i) || '-' == s.charAt(i)){
                if(jiajian > 0){
                    return false;
                }
                if(i != 0 || i == length-1){
                    return false;
                }
                jiajian ++;
            }else if('.' == s.charAt(i)) {
                if(isInt){
                    return false;
                }
                if(dian > 0){
                    return false;
                }
                if(i == 0 ){
                    if(i+1 == length || s.charAt(i+1)<'0' || s.charAt(i+1) > '9'){
                        return false;
                    }
                }else{
                    if(i == 0){
                        return false;
                    }else if((s.charAt(i-1)<'0' || s.charAt(i-1) > '9') &&( s.charAt(i-1) != '+' && s.charAt(i-1) != '-')){
                        return false;
                    }else if(s.charAt(i-1) == '+' || s.charAt(i-1) == '-'){
                        if(i+1 == length){
                            return false;
                        }else if(s.charAt(i+1)<'0' || s.charAt(i+1) > '9') {

                        }
                    }
                }
                dian ++;
            }else{
                if(!(s.charAt(i)>='0' && s.charAt(i) <= '9')){
                    return false;
                }
            }
        }
        return true;
    }
}
