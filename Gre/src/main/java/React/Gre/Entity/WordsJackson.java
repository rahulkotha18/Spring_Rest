package React.Gre.Entity;

import React.Gre.Spring_Jpa.WordsJPA;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;

@Component
public class WordsJackson{
    @Autowired
    WordsJPA wordsRepository;
    public void fillData() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        Words e1[]=mapper.readValue(new File("/home/zadmin/Desktop/Spring_Rest/Gre/src/main/java/React/Gre/Utilities/data.json"),Words[].class);
        for(Words words:e1)
        {
            wordsRepository.save(words);
        }
    }
}
