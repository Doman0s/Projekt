package pl.edu.wszib.power.tool.rental.service.implementation;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.power.tool.rental.database.IUserDAO;
import pl.edu.wszib.power.tool.rental.exceptions.LoginUsedException;
import pl.edu.wszib.power.tool.rental.model.Ruser;
import pl.edu.wszib.power.tool.rental.model.User;
import pl.edu.wszib.power.tool.rental.service.IAuthService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthService implements IAuthService {
    @Autowired
    IUserDAO userDAO;

    @Resource
    Session session;

    @Override
    public void login(String login, String password) {
        Optional<User> user = this.userDAO.getUserByLogin(login);

        if(user.isEmpty() || !user.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            return;
        }
        this.session.setUser(user.get());
    }

    @Override
    public void register(Ruser ruser) {
        Optional<User> user = this.userDAO.getUserByLogin(ruser.getLogin());

        if(user.isPresent()) {
            throw new LoginUsedException("Login is already used");
        }

        ruser.setPassword(DigestUtils.md5Hex(ruser.getPassword()));

        User userNew = new User();
        userNew.setName(ruser.getName());
        userNew.setSurname(ruser.getSurname());
        userNew.setLogin(ruser.getLogin());
        userNew.setPassword(ruser.getPassword());

        this.userDAO.addUser(userNew);
    }

    @Override
    public void modifyUser(User user) {
        User userUpdated = new User();

        userUpdated.setId(this.session.getUser().getId());
        userUpdated.setName(user.getName());
        userUpdated.setSurname(user.getSurname());
        userUpdated.setLogin(user.getLogin());
        userUpdated.setPassword(this.session.getUser().getPassword());
        this.userDAO.updateUser(userUpdated);
    }

    @Override
    public void changePassword(Ruser ruser) {
        User userUpdated = new User();

        ruser.setPassword(DigestUtils.md5Hex(ruser.getPassword()));

        userUpdated.setId(this.session.getUser().getId());
        userUpdated.setName(this.session.getUser().getName());
        userUpdated.setSurname(this.session.getUser().getSurname());
        userUpdated.setLogin(this.session.getUser().getLogin());
        userUpdated.setPassword(ruser.getPassword());

        this.userDAO.updateUser(userUpdated);
    }
}
