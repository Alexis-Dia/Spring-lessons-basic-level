package ironbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Druzik on 5/4/2020
 */
@Controller
@RequestMapping(value = "/user")
public class SimpleController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/all")
    public List<String> getUsers() {

        List<String> allUsers = new ArrayList<>();
        allUsers.add("Admin");

        return allUsers;
    }
}
