package mbeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GiBSoN on 2015-04-20.
 */
public class ApplicationCache implements ApplicationCacheMBean {

    private int maxCacheSize = 100;
    private List<Object> cache = new ArrayList<>();

    public synchronized int getMaxCacheSize() {
        return maxCacheSize;
    }

    public synchronized void setMaxCacheSize(int value) {
        if(value < 1) {
            throw new IllegalArgumentException("Value must be >= 1");
        }
        maxCacheSize = value;
    }

    public synchronized int getCachedObjects() {
        return cache.size();
    }

    public synchronized void clearCache() {
        cache.clear();
    }

    public synchronized void cacheObject(Object o) {
        while(cache.size() >= maxCacheSize) {
            cache.remove(0);
        }
        cache.add(o);
    }
}
