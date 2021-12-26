/**
 * @Author Gladson Antony
 * @Date Apr 25, 2017
 */
package controllers;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader {

    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    @Property(value = "Browser")
    private String Browser;

    @Property(value = "Url")
    private String WebsiteUrl;

    @Property(value = "MaxPageLoadTime")
    private int MaxPageLoadTime;

    @Property(value = "ImplicitlyWait")
    private int ImplicitlyWait;

    public String getBrowser() {
        return Browser;
    }

    public String getWebsiteUrl() {
        return WebsiteUrl;
    }

    public int getMaxPageLoadTime() {
        return MaxPageLoadTime;
    }

    public int getImplicitlyWait() {
        return ImplicitlyWait;
    }

}
