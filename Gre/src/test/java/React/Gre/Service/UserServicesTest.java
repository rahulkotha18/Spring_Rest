package React.Gre.Service;
import React.Gre.Entity.Token;
import React.Gre.Entity.Users;
import React.Gre.Entity.Words;
import React.Gre.GreApplication;
import React.Gre.Spring_Jpa.StatusJPA;
import React.Gre.Spring_Jpa.UsersJPA;
import React.Gre.Spring_Jpa.WordsJPA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:test.properties")
@SpringBootTest(classes = {GreApplication.class})
public class UserServicesTest
{
    @Autowired
    UsersJPA usersJPA;
    @Autowired
    StatusJPA statusJPA;
    @Autowired
    WordsJPA wordsJPA;
    @Autowired
    UserServices userServices;
    public static List<Words> wordsList;
    @Before
    public void addDummys()
    {
        Users users=new Users(13,"pavan","tiger rice");
        usersJPA.save(users);
        Words words=new Words(1,"ego","destructive");
        wordsJPA.save(words);
        wordsList=new ArrayList<>();
        wordsList.add(words);
        words=new Words(2,"sreetej","block chain");
        wordsJPA.save(words);
        wordsList.add(words);
        Token token=new Token(13,1);
        userServices.addWord(token);
        token=new Token(13,2);
        userServices.addWord(token);
    }
    @Test
    @Transactional
    public void addUserTest()
    {
        Assert.assertEquals(usersJPA.getOne(13).getName(),"pavan");
    }
    @Test
    public void addWordTest()
    {
        Token token=new Token(13,1);
        Assert.assertEquals(userServices.addWord(token),1);
    }
    @Test
    public void delWordTest()
    {

        Token token=new Token(13,1);
        Assert.assertEquals(userServices.delWord(token),1);
    }
    @Test
    public void getAuthorizationTest()
    {
        Users user=new Users(1,"pavan","tiger rice");
        Assert.assertNotEquals(userServices.getAuthorization(user),-1);
    }
    @Test
    public void getAllUsersTest()
    {
        Assert.assertEquals(userServices.getAllUsers().size(),1);
    }
    @Test
    public void getAllWordsTest()
    {
        Assert.assertEquals(userServices.getAllWords().size(),2);
    }
    @Test
    @Transactional
    public void fillTest() throws Exception {
        Assert.assertNotNull("name",userServices.fill());
    }
    @Test
    @Transactional
    public void getWordsOfUserTest()
    {
        Assert.assertEquals(userServices.getWordsOfUser(13).toArray().length,wordsList.toArray().length);
    }
}

