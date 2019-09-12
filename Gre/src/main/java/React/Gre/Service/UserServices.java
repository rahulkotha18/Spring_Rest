package React.Gre.Service;

//import React.Gre.Entity.Status;
import React.Gre.Entity.Users;
//import React.Gre.Entity.token;
import React.Gre.Spring_Jpa.StatusRepository;
import React.Gre.Spring_Jpa.UsersRepository;
import React.Gre.Spring_Jpa.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    WordsRepository wordsRepository;
    @Autowired
    StatusRepository statusRepository;
    public Users addUser(Users user)
    {
        usersRepository.save(user);
        return user;
    }
//    public Status addWord(token token)
//    {
//        Status st=new Status();
//        st.setTokenid(token);
//        statusRepository.save(st);
//        return st;
//    }
}
