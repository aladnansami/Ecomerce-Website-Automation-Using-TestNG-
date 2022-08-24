package Utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws IOException, ParseException {
        Utils util=new Utils();
        util.readUserCredentials(0);
        util.getEmail();
        util.getPassword();
    }




    public void readUserCredentials(int pos) throws IOException, ParseException {

        String fileName="./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray=(JSONArray) obj;
        JSONObject userObj = (JSONObject) jsonArray.get(pos);

        setEmail((String) userObj.get("email"));
        setPassword((String) userObj.get("password"));


    }

    public void writeUserInfo(String email,String password) throws IOException, ParseException {

        String fileName="./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));

        JSONObject userObj=new JSONObject();
        userObj.put("email",email);
        userObj.put("password",password);

        JSONArray jsonArray=(JSONArray) obj;
        jsonArray.add(userObj);

        FileWriter file=new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("saved!");
        System.out.println(jsonArray);

    }

    public int getUserCount() throws IOException, ParseException {
        String fileName="./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray=(JSONArray) obj;
        return jsonArray.size()-1;
    }
    public void takeScreenShot(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);

    }

    public String generateRandomPassword(int len)
    {
        String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++)
        {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public int generateRandomNumber(int max,int min)
    {
        int randomId=(int)(Math.random()*(max-min+min));
        return randomId;
    }


}
