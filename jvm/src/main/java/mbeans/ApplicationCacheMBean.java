package mbeans;

/**
 * Created by GiBSoN on 2015-04-20.
 */
public interface ApplicationCacheMBean {

    int getMaxCacheSize();
    void setMaxCacheSize(int value);
    int getCachedObjects();
    void clearCache();
}
