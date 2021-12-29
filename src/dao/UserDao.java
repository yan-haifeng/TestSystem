package dao;

import beans.User;
import util.Config;

import java.io.*;

public class UserDao {
    Config propertiesConfig = new Config("/config.properties");
    final String API = UserDao.class.getResource("/").getPath().substring(1);
    String url = (API + new Config("/config.properties").getString("UserFile")).replace("/","\\");

    public User getUserById(String id){
        User user = new User();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        String[] userList = null;
        try {
            fileReader = new FileReader(url);
            bufferedReader = new BufferedReader(fileReader);
            while (true){
                line = bufferedReader.readLine();
                if (line == null) break;
                //掠过空行与注释
                if("".equals(line.trim()) || line.charAt(0) == '#') continue;
                //user 查找逻辑
                userList = line.split(":");
                if(userList[0].equals(id)){
                    //文件数据错误
                    if(userList.length != 5) return null;
                    //找到id
                    user.setId(userList[0]);
                    user.setName(userList[1]);
                    user.setPassword(userList[2]);
                    user.setPhoneNum(userList[3]);
                    user.setEmail(userList[4]);
                    break;
                }
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
