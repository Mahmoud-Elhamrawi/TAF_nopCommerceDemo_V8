package UserData;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class jsonDataReader {
    public String name;
    public String email;
    public String msg;

    public void jsonReader() throws IOException, ParseException {


        String path ="./src\\test\\resources\\contactUs.json";
        File srcFile = new File(path);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(srcFile));
        for(Object jsonObject :jsonArray)
        {
            JSONObject obj = (JSONObject) jsonObject;
            name = (String) obj.get("name");
            email =(String) obj.get("email");
            msg = (String) obj.get("msg");
        }
    }




}
