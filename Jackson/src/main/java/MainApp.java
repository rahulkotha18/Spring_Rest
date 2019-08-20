import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class MainApp {
    public static void main(String args[]) throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        Employee e1=mapper.readValue(new File("/home/zadmin/Desktop/spring/Jackson/src/main/resources/f1.json"),Employee.class);
        System.out.println("id :"+e1.getId());
        System.out.println("name:"+e1.getName());
        Address ad=e1.getAddress();
        System.out.println("city:"+ad.getCity());
        System.out.println("country:"+ad.getCountry());
        String[] str=e1.getStudy();
        System.out.println("study:"+str[0]+"\t"+str[1]);
    }
}
