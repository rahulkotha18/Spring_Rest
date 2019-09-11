package React.Gre.Controller;
import React.Gre.Entity.Users;
import React.Gre.Entity.Words;
import React.Gre.Entity.WordsJackson;
import React.Gre.Spring_Jpa.UsersRepository;
import React.Gre.Spring_Jpa.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreController {
    @Autowired
    WordsJackson wordsJackson;
    @RequestMapping("fillWords")
    public String fill() throws Exception {

        //wordsJackson.fillData();
        return "data is already filled";
    }
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    WordsRepository wordsRepository;
    @CrossOrigin("http://localhost:3000")
    @GetMapping("words")
    public List<Words> getAllWords()
    {
        return  wordsRepository.findAll();
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("users")
    public List<Users> getAllUsers()
    {
        return  usersRepository.findAll();
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("user/{id}")
    public List<Words> getWordsOfUser(@PathVariable int id)
    {
        return  usersRepository.findById(id).get().getWords();
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("word/{id}")
    public List<Users> getUsersOfWord(@PathVariable int id)
    {
        return  wordsRepository.findById(id).get().getUsers();
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("auth")
    public int getAuthorization(@RequestBody Users user)
    {
        List<Users> usersList=usersRepository.findAll();
        for(Users current_user:usersList)
        {
            if(current_user.getName().equals(user.getName()) && current_user.getPassword().equals(user.getPassword()) )
            {
                return current_user.getId() ;
            }
        }
        return  -1;
    }

}
