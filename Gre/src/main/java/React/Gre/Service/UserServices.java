package React.Gre.Service;

import React.Gre.Entity.*;
import React.Gre.Spring_Jpa.StatusJPA;
import React.Gre.Spring_Jpa.UsersJPA;
import React.Gre.Spring_Jpa.WordsJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices
{
    @Autowired
    WordsJackson wordsJackson;
    @Autowired
    UsersJPA usersJPA;
    @Autowired
    WordsJPA wordsJPA;
    @Autowired
    StatusJPA statusJPA;
    public String fill() throws Exception
    {
        wordsJackson.fillData();
        return "data is already filled";
    }
    @Transactional
    public List<Words> getAllWords()
    {
        try {
            return wordsJPA.findAll();
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Transactional
    public List<Users> getAllUsers()
    {
        try {
        return usersJPA.findAll();
            }
        catch(Exception e)
        {
            return null;
        }
    }

    @Transactional
    public List<Words> getWordsOfUser(int id) {
        try {
            return usersJPA.findById(id).get().getWords();
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public List<Users> getUsersOfWord(int id)
    {
        try {
            return wordsJPA.findById(id).get().getUsers();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Transactional
    public int getAuthorization(Users user)
    {
        List<Users> usersList=null;
        try {
            usersList= usersJPA.findAll();
        }
        catch (Exception e)
        {
            return -1;
        }
        for(Users current_user:usersList)
        {
            if(current_user.getName().equals(user.getName()) && current_user.getPassword().equals(user.getPassword()) )
            {
                return current_user.getId() ;
            }
        }
        return  -1;
    }

    @Transactional
    public Users addUser(Users users)
    {
        usersJPA.save(users);
        return users;
    }

    @Transactional
    public int addWord(Token token)
    {
        Users users=usersJPA.getOne(token.getU_id());
        List<Words> wordsList=users.getWords();
        Words words=wordsJPA.getOne(token.getW_id());
        if(!wordsList.contains(words))
            wordsList.add(words);
        usersJPA.save(users);
        return 1;
    }

    @Transactional
    public int delWord(Token token)
    {
        Users users=usersJPA.getOne(token.getU_id());
        List<Words> wordsList=users.getWords();
        Words words=wordsJPA.getOne(token.getW_id());
        wordsList.remove(words);
        usersJPA.save(users);
        return 1;
    }
}
