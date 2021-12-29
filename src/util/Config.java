package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Config 读取系统的配置文件
 */
public class Config {
    private Properties pro = new Properties();

    public Config(String file) {
        try {
            pro.load(new FileReader(Config.class.getResource(file).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int getInt(String key) {
        return Integer.parseInt(pro.getProperty(key));
    }

    public String getString(String key) {
        return pro.getProperty(key);
    }

}