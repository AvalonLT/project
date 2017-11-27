package lt.jonas.project.controller;

import lt.jonas.project.model.Teacher;
import lt.jonas.project.model.User1;
import lt.jonas.project.service.SecurityService;
import lt.jonas.project.service.TeacherService;
import lt.jonas.project.service.UserService;
import lt.jonas.project.util.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserValidation userValidation;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user1Form", new User1());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user1Form") User1 user1Form, BindingResult bindingResult, Model model) {
        //Binding resuls ateina error'ai is formos. Juos reikia apsirasyti formoje.
        userValidation.validate(user1Form, bindingResult);
        if(bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.save(user1Form);
            securityService.login(user1Form.getUsername(), user1Form.getPasswordconfirm());
            return "redirect:/login";
        }
    }

    @RequestMapping(value = {"/","/welcomepage", "/loginok"}, method = RequestMethod.GET)
    public String welcome() {
        return "redirect:main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "wrong username and password");
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "name", method = RequestMethod.GET)
    public String getName(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "name";

    }

    @RequestMapping(value = "/getrole", method = RequestMethod.GET)
    public String getRole(Model model, Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        while(iterator.hasNext()) {
            GrantedAuthority next = iterator.next();
            String role = next.getAuthority();
            if (role.equals("admin")) {
                return "adminwindow";
            }
        }
        return "window";
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public UserTest studentList(){
//        return new UserTest();
//    }


}
