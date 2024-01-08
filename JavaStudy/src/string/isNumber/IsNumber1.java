package string.isNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 数字有效性 自动器解法
 * @Author: tmj
 * @Data: 2023/10/9 1:57
 */
public class IsNumber1 {
    public static void main(String[] args) {
        isNumber(".2e81");
    }

    public static boolean isNumber(String s) {
        Map<STATE, Map<CHARTYPE, STATE>> transfer = new HashMap<>();
        Map<CHARTYPE, STATE> initMap = new HashMap<>();
        initMap.put(CHARTYPE.SIGN, STATE.SIGN);
        initMap.put(CHARTYPE.NUM, STATE.INT);
        initMap.put(CHARTYPE.POINT, STATE.POINT);
        transfer.put(STATE.INIT, initMap);
        Map<CHARTYPE, STATE> signMap = new HashMap<>();
        signMap.put(CHARTYPE.NUM, STATE.INT);
        signMap.put(CHARTYPE.POINT, STATE.POINT);
        transfer.put(STATE.SIGN, signMap);
        Map<CHARTYPE, STATE> intMap = new HashMap<>();
        intMap.put(CHARTYPE.NUM, STATE.INT);
        intMap.put(CHARTYPE.POINT, STATE.POINT_WITH_INT);
        intMap.put(CHARTYPE.EXP, STATE.EXP);
        transfer.put(STATE.INT, intMap);
        Map<CHARTYPE, STATE> pointMap = new HashMap<>();
        pointMap.put(CHARTYPE.NUM, STATE.POINT_INT);
        transfer.put(STATE.POINT, pointMap);
        Map<CHARTYPE, STATE> pointWithIntMap = new HashMap<>();
        pointWithIntMap.put(CHARTYPE.NUM, STATE.POINT_INT);
        pointWithIntMap.put(CHARTYPE.EXP, STATE.EXP);
        transfer.put(STATE.POINT_WITH_INT, pointWithIntMap);
        Map<CHARTYPE, STATE> pointIntMap = new HashMap<>();
        pointIntMap.put(CHARTYPE.NUM, STATE.POINT_INT);
        pointIntMap.put(CHARTYPE.EXP, STATE.EXP);
        transfer.put(STATE.POINT_INT, pointIntMap);
        Map<CHARTYPE, STATE> expMap = new HashMap<>();
        expMap.put(CHARTYPE.SIGN, STATE.EXP_SIGN);
        expMap.put(CHARTYPE.NUM, STATE.EXP_INT);
        transfer.put(STATE.EXP, expMap);
        Map<CHARTYPE, STATE> expSignMap = new HashMap<>();
        expSignMap.put(CHARTYPE.NUM, STATE.EXP_INT);
        transfer.put(STATE.EXP_SIGN, expSignMap);
        Map<CHARTYPE, STATE> expIntMap = new HashMap<>();
        expIntMap.put(CHARTYPE.NUM, STATE.EXP_INT);
        transfer.put(STATE.EXP_INT, expIntMap);
        int len = s.length();
        STATE state = STATE.INIT;
        for (int i = 0; i < len; i++) {
            // 转换
            CHARTYPE chartype = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(chartype)) {
                return false;
            } else {
                state = transfer.get(state).get(chartype);
            }
        }
        return state == STATE.INT || state == STATE.POINT_INT
                || state == STATE.POINT_WITH_INT || state == STATE.EXP_INT || state == STATE.END;


    }


    private static CHARTYPE toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CHARTYPE.NUM;
        } else if (ch == '+' || ch == '-') {
            return CHARTYPE.SIGN;
        } else if (ch == '.') {
            return CHARTYPE.POINT;
        } else if (ch == 'e' || ch == 'E') {
            return CHARTYPE.EXP;
        } else {
            return CHARTYPE.ILLEGAL;
        }
    }

    // 枚举出所有状态
    enum STATE {
        /**
         * 初始化
         **/
        INIT,
        /**
         * +-符号
         **/
        SIGN,
        /**
         * 整数
         **/
        INT,
        /**
         * 小数点
         **/
        POINT,
        /**
         * 小数点左边有数字
         **/
        POINT_WITH_INT,
        /**
         * 小数点后面整数
         **/
        POINT_INT,
        /**
         * e符号
         **/
        EXP,
        /**
         * e后+-符号
         **/
        EXP_SIGN,
        /**
         * 指数数字
         **/
        EXP_INT,
        /**
         * 结束状态
         **/
        END
    }

    // 枚举出所有char类型
    enum CHARTYPE {
        /**
         * 数字
         **/
        NUM,
        /**
         * 正负
         **/
        SIGN,
        /**
         * 小数点
         **/
        POINT,
        /**
         * e指数符号
         **/
        EXP,
        /**
         * 非法
         **/
        ILLEGAL
    }

}
