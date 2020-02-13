package com.antiy.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 日期获取工具类
 */
public class DateUtil {

    private static DateUtil instance = new DateUtil();
    private static SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf_mm_dd  = new SimpleDateFormat("MM月dd日");

    private DateUtil(){}

    public static DateUtil getInstance(){
        return instance;
    }

    /**
     * 根据传入时间获取 该时间所在的一周的日期
     * @param date 传入时间参数
     * @return
     */
    public static Map<String,Date> weekDateOfToday(Date date){
        Map<String,Date> weekMap = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);


        try {
            //周一
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            Date mon = calendar.getTime();

            //周二
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            Date tues = calendar.getTime();

            //周三
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            Date wen = calendar.getTime();

            //周四
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            Date thur = calendar.getTime();

            //周五
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            Date fri = calendar.getTime();

            //周六
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            String satday = simpleDateFormat.format(calendar.getTime());
            Date sat = simpleDateFormat.parse(satday);

            //周天
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            String sunday = simpleDateFormat.format(calendar.getTime());
            Date sun = simpleDateFormat.parse(sunday);
            weekMap.put("monday",mon);
            weekMap.put("tuesday",tues);
            weekMap.put("wednesday",wen);
            weekMap.put("thursday",thur);
            weekMap.put("friday",fri);
            weekMap.put("saturday",sat);
            weekMap.put("sunday",sun);
        }catch (Exception e){
            e.printStackTrace();
        }




        return weekMap;
    }

    /**
     * 根据传入时间获取 该时间所在的一周的日期
     * @param date 传入时间参数
     * @return
     */
    public static List<String> weekDayOfToday(Date date){
        List<String> weekList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
        //周一
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String mon = simpleDateFormat.format(calendar.getTime());


        //周二
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        String tues = simpleDateFormat.format(calendar.getTime());

        //周三
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        String wen = simpleDateFormat.format(calendar.getTime());

        //周四
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        String thur = simpleDateFormat.format(calendar.getTime());

        //周五
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        String fri = simpleDateFormat.format(calendar.getTime());

        //周六
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String sat = simpleDateFormat.format(calendar.getTime());

        //周天
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String sun = simpleDateFormat.format(calendar.getTime());

        weekList.add(sun);
        weekList.add(mon);
        weekList.add(tues);
        weekList.add(wen);
        weekList.add(thur);
        weekList.add(fri);
        weekList.add(sat);

        return weekList;
    }

    /**
     * 获取当前输入时间所在月份的所有 天
     * @return
     */
    public static List<String> getDaysOfNowMonth(){
        List<String> monthDayList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("d");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        //获取当月最后一天
        Integer last = Integer.parseInt(format.format(ca.getTime()));
        for (int i = 1;i <= last;i++ ){
            monthDayList.add(i+"");
        }
        return monthDayList;
    }

    /**
     * 获取当前输入时间所在月份的所有日期
     * @return
     */
    public static Map<String,Date> getDateOfNowMonth(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Map<String,Date> dateMap = new HashMap<>();
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));


        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);

        try {
            //第一天
            String firstDateStr = simpleDateFormat.format(c.getTime());
            Date firstDate = simpleDateFormat.parse(firstDateStr);
            //最后一天
            String lastDateStr = simpleDateFormat.format(ca.getTime());
            Date lastDate = simpleDateFormat.parse(lastDateStr);

            dateMap.put("firstDay",firstDate);
            dateMap.put("lastDay",lastDate);
        }catch (Exception e){
            e.printStackTrace();
        }

        return dateMap;
    }

    /**
     * 获取今日前number日的日期
     * @param number
     * @return
     */
    public static Date getDayFromToday(Integer number){
        try {

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_YEAR, -number);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(c.getTime());
            return simpleDateFormat.parse(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取今日的日期
     * @return
     */
    public static Date getDayToday(){
        try {
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DAY_OF_MONTH, 1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = simpleDateFormat.format(c.getTime());
            return simpleDateFormat.parse(dateStr);
        }catch (Exception e){
            e.printStackTrace();
        }
            return null;
    }

    public static List<String> getMonthDayList(){
        List<String> dayList = new ArrayList<>();
        dayList.add("7");
        dayList.add("14");
        dayList.add("21");
        dayList.add("28");
        return dayList;
    }
    /**
     * 返回两个时间之间相差多少天
     * @param now
     * @param past
     * @return
     */
    public static Integer dayNumberBetweenToDate(Date now , Date past){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String pastString = simpleDateFormat.format(past);
            Date pastDate = simpleDateFormat.parse(pastString);
            return (int)(((now.getTime() - pastDate.getTime() )/ (1000 * 3600 * 24)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前日期前30天的日期
     */
    public static Map<String, Integer> getLast30DayMap(){
        try {
            Calendar calc =Calendar.getInstance();    
            Map<String, Integer> bloodMap = new LinkedHashMap<>();
             for(int i=0;i<30;i++){  
                   calc.setTime(new Date());    
                   calc.add(Calendar.DATE, -i);
                   Date minDate = calc.getTime();    
                   bloodMap.put(sdf_mm_dd.format(minDate), 0);
                  }  
             return bloodMap;
        } catch (Exception e) {
              e.printStackTrace();
        }
        return null;
    }

    /**
     * 取30天前0点的时间
     * @return
     */
    public static Long getBefore30Day() {
        Calendar before = Calendar.getInstance();
        before.set(before.get(Calendar.YEAR),before.get(Calendar.MONTH),before.get(Calendar.DAY_OF_MONTH)-29,0,0,0);
        long before30Day = before.getTime().getTime();
        return before30Day;
    }

    /**
     * 取今天23点59:59的时间
     * @return
     */
    public static Long getToday235959() {
        Calendar now = Calendar.getInstance();
        now.set(now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH),23,59,59);
        long today = now.getTime().getTime();
        return today;
    }

    public static void main(String[] args) {
        Map<String, Integer> last30DayMap = getLast30DayMap();
        for (Map.Entry<String, Integer> en : last30DayMap.entrySet()) {
            System.out.println(String.format("%s:%d", en.getKey(), en.getValue()));
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-29,0,0,0);
        long tt = calendar.getTime().getTime();
        System.out.println(tt);

        Calendar today = Calendar.getInstance();
        today.set(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH),23,59,59);
        long t1 = today.getTime().getTime();
        System.out.println(t1);
    }
}