/**
 * DateUtils.java
 * 日付操作関連共通関数
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yang.kang
 *
 */
public class DateUtils {

    /** 日付フォーマット:"yyyyMMddHHmmss" */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";

    public static final String YYYY_MM_DD_HH_MM_SS2 = "yyyy-MM-dd HH:mm:ss";

    /** 日付フォーマット:"yyyy-MM-dd" */
    public static final String YYYY_MM_DD_WITN_HYPHEN = "yyyy-MM-dd";

    /**
     * 日付オブジェクトにより、日付文字列を取得する
     * 
     * @param date
     *            日付オブジェクト
     * @param datePattenStr
     *            日付フォーマット
     * @return 日付文字列
     * */
    public static String getDateFromStr(Date date, String datePattenStr) {
        String retstr = null;

        if (date == null) {
            date = new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat(datePattenStr);

        retstr = sdf.format(date);

        return retstr;
    }

    public static Date formateDate(Date date,String datePattenStr){
    	String strDate = getDateFromStr(date,datePattenStr);
    	Date date1 = parseStringToDate(strDate, datePattenStr);
    	return date1;
    }
    /**
     * 指定された日付文字列によって、日付オブジェクトを生成する。
     * 
     * @param datestr
     *            日付文字列
     * @param datePattenStr
     *            日付フォーマット
     * @return 日付オブジェクト
     * */
    public static Date parseStringToDate(String datestr, String datePattenStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(datePattenStr);
        try {
            date = sdf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日付オブジェクトにより、日付文字列を取得する
     * 
     * @param date
     *            日付オブジェクト
     * @return 日付文字列
     * */
    public static String getDateFromStr(Date date) {
        String retstr = null;

        if (date == null) {
            date = new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);

        retstr = sdf.format(date);

        return retstr;
    }

    /**
     * 指定された日付を基に、日付を増やしたり、減少したり、する。
     * 
     * */
    public static String moveToDates(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        Date rerDate = calendar.getTime();
        return getDateFromStr(rerDate, YYYY_MM_DD_WITN_HYPHEN);
    }

    /**
     * 二つの日付を比較する共通関数。<br>
     * 
     * @param datestr
     *            一番目日付文字列
     * @param datestr2
     *            二番目日付文字列
     * @return 比較の結果
     * */
//    public static int compareDateValue(String datestr, String datestr2) {
//        int retvalue = 0;
//
//        Date dateobj = null;
//
//        Date dateobj2 = null;
//
//        if (StringUtils.IsEmpty(datestr) || StringUtils.IsEmpty(datestr2)) {
//            retvalue = 2;
//            return retvalue;
//        }
//
//        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_WITN_HYPHEN);
//
//        try {
//            dateobj = sdf.parse(datestr);
//            dateobj2 = sdf.parse(datestr2);
//            retvalue = dateobj.compareTo(dateobj2);
//        } catch (ParseException e) {
//            System.out.println(e.getLocalizedMessage());
//            retvalue = 2;
//        }
//
//        return retvalue;
//    }
}
