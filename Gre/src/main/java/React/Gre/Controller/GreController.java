package React.Gre.Controller;
import React.Gre.Entity.*;
import React.Gre.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class GreController
{

        @Autowired
        UserServices userServices;
        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @GetMapping("fillWords")
        public String fillWords () throws Exception {
                return userServices.fill();
        }
        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @GetMapping("words")
        public List<Words> getAllWords ()
        {
            return userServices.getAllWords();
        }

        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @GetMapping("users")
        public List<Users> getAllUsers ()
        {
            return userServices.getAllUsers();
        }

        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @GetMapping("user/{id}")
        public List<Words> getWordsOfUser ( @PathVariable int id)
        {
            return userServices.getWordsOfUser(id);
        }

        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @GetMapping("word/{id}")
        public List<Users> getUsersOfWord ( @PathVariable int id)
        {
            return userServices.getUsersOfWord(id);
        }
        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @PostMapping("auth")
        public int getAuthorization (@RequestBody Users user)
        {
            return userServices.getAuthorization(user);
        }

        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @PostMapping("/user")
        public Users addUser (@RequestBody Users users)
        {
            return userServices.addUser(users);
        }

        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @PostMapping("/addWord")
        public int addWord (@RequestBody Token token)
        {
            return userServices.addWord(token);
        }

        @CrossOrigin({"http://localhost:3000", "http://172.16.18.66:3000"})
        @PostMapping("/delWord")
        public int delWord (@RequestBody Token token)
        {
            return userServices.delWord(token);
        }
}
