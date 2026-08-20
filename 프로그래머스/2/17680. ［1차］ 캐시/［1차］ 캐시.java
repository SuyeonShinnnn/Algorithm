import java.util.*;

class Solution {
    public Memory search(List<Memory> cache, String c) {
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i).name.toLowerCase().equals(c.toLowerCase())) {
                return new Memory(c, 0, i);
            }
        }
        return null;
    }
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        
        List<Memory> cache = new LinkedList<>();
        
        int hitted = 0;
        for(String c : cities) {
            Memory m = search(cache, c);
            
            if(m == null && cache.size() < cacheSize) {
                cache.add(new Memory(c, 0, cache.size()));
            }
            else if(m == null && cache.size() == cacheSize) {
                Memory r = cache.remove(0);
                hitted += r.count;
                
                cache.add(new Memory(c, 0, 0));
            }
            else if(m != null) {
                Memory r = cache.remove(m.idx);
                r.count++;
                cache.add(r);
            }
        }
        
        for(Memory m: cache) {
            hitted += m.count;
        }
        
        return hitted + 5 * (cities.length - hitted);
    }
}

class Memory {
    String name;
    int count;
    int idx;
    
    public Memory(String name, int count, int idx) {
        this.name = name;
        this.count = count;
        this.idx = idx;
    }
    
    public String toString() {
        return name + " " + count;
    }
}