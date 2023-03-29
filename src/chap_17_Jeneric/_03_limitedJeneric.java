package chap_17_Jeneric;

import java.lang.module.FindException;
import java.util.*;

public class _03_limitedJeneric {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Long> lList = new ArrayList<Long>();

        for (int i = 0; i < 10; i++) {
            lList.add((long) 5 * i);
        }
        System.out.println(_03_limitedJeneric.sumList(lList));

        List<Number> numList = new ArrayList<Number>();

        for (int i = 0; i < 10; i++) {
            numList.add((Integer) 3 * i);
        }
        System.out.println(_03_limitedJeneric.max(numList));

        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i),Integer.valueOf(((int)Math.random() *100)+ 1));
        }
        System.out.println(_03_limitedJeneric.maxKey(map));
    }

    //리스트를 받아서 리스트 요소의 합계를 리턴
    public static <T extends Number> double sumList(List<T> tList) {
        double sum = 0.0;

        for (T t : tList) {
            sum += t.doubleValue();
        }
        return sum;
    }

    //와일드 카드는 매개변수로만 사용 가능하다.
    public static int max(List<? super Integer> list) {
        int max = (int) list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if ((int) list.get(i) > max) {
                max = (int) list.get(i);
            }
        }

        return max;
    }

    public static <K, V extends  Number>int sumMapValue(Map<K,V>map){
        int sum = 0;

        for (V v : map.values()){
            sum+= (int)v;
        }
        return sum;
    }

    //Map의 value의 맥스 값을 찾고 해당 키 값을 리턴하는 메소드
    public static <K,V extends Number> K maxKey(Map<K,V>map){
        //
        K maxKey = null;
        V maxVal = null;
        int index = 0;          //Set<Entry<K,V>>
        for(Map.Entry<K,V> ent : map.entrySet()){
            if (index == 0){
                maxKey = ent.getKey();
                maxVal = ent.getValue();
            }else {
                if (ent.getValue().doubleValue() > maxVal.doubleValue()){
                    maxKey = ent.getKey();
                    maxVal = ent.getValue();
                }
            }
        }

        return maxKey;
    }
    public int add(List<?>inList){
        return 1;
    }// 와일드 카드는 메소드의 매개변수에 어던타입의 클래스든 다 지정할 수 있게 할 대 사용



}