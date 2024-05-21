package programmers.level2.kakaoblind1차;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 캐시 {
	
    public int solution(int cacheSize, String[] cities) {
    	
    	/**
    	 * =================================================
    	 * 내코드
    	 * =================================================
    	 */
        if(cacheSize == 0) return cities.length * 5;
        
        Set<String> cache = new HashSet<>();
        Queue<String> queue = new LinkedList<String>();
		
        int runTime = 0;
        for(String city : cities){
            city = city.toUpperCase();
            if(cache.contains(city)){
                runTime += 1;
                queue.remove(city);
                queue.add(city);
            }else{
                runTime += 5;
                if(cache.size() == cacheSize){
                    cache.remove(queue.poll());
                }
                cache.add(city);
                queue.add(city);
            }
        }
        return runTime;
    }
    
    public static void main(String[] args) {
    	
    	Object[][] p = {
    					{3,	new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 50},
    	{3,	new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},	21},
    	{2,	new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},	60},
    	{5,	new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},	52},
    	{2,	new String[]{"Jeju", "Pangyo", "NewYork", "newyork"},	16},
    	{0,	new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"},	25}
    	};
    	int cnt = 0;
    	for(Object[] ob : p) {
    		System.out.println(++cnt + " : " +  solution2((int) ob[0], (String[]) ob[1]) + " = " + ob[2]);
    	}
    	
	}
    /**
	 * =================================================
	 * 최적의 알고리즘 (LRU) Least Recently Used
	 * =================================================
	 */
    private static final int hitTm = 1;
    private static final int missTm = 5;
    
    public static int solution2(int cacheSize, String[] cities) {
    	
    	if(cacheSize == 0) return cities.length * missTm;
    	
    	LinkedHashMap<String, Integer> map = new LRUCache<>(cacheSize);
    	
    	int answer = 0;
    	
    	for(String city : cities) {
    		answer += map.containsKey(city.toUpperCase()) ? hitTm : missTm;
    		map.put(city.toUpperCase(), 0);
    	}

    	return answer;
    }
    
    @SuppressWarnings("serial")
	static class LRUCache<K, V> extends LinkedHashMap<K, V>{
    	
		private int capacity;
    	
    	public LRUCache(int capacity) {
    		super(capacity, 0.75f, true);
			this.capacity = capacity;
		}
    	
    	@Override
    	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
    		return this.size() > capacity;
    	}
    	
    }
}