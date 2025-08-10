package com.auth.check.json_check.controller.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvccheck")
public class BasicMVCController {

    /**
     * This method handles HTTP GET requests to the root "/" endpoint.
     * It returns the "index" view.
     *
     * @return The logical view name ("index"), which Spring MVC will resolve to
     * src/main/resources/templates/index.html using Thymeleaf.
     */
    @GetMapping("/")
    public String home() {
        return "index"; // This refers to src/main/resources/templates/index.html
    }
    
    /**
     * This method handles HTTP GET requests to the "/hello" endpoint.
     * It now prepares data and returns the name of a Thymeleaf template.
     *
     * @GetMapping("/hello") maps HTTP GET requests onto this handler method.
     *
     * @RequestParam("name") binds the value of the HTTP request parameter named "name"
     * to the 'name' method parameter.
     * defaultValue = "World" provides a default value if the "name" parameter is not provided.
     *
     * @param model The Model object used to pass data from the controller to the view.
     * @param name The name parameter from the request.
     * @return The logical view name ("hello"), which Spring MVC will resolve to
     * src/main/resources/templates/hello.html using Thymeleaf.
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(name = "name", defaultValue = "World") String name, Model model) {
        // Add the 'name' attribute to the model, which will be accessible in the Thymeleaf template.
        model.addAttribute("name", name);
        return "hello"; // This refers to src/main/resources/templates/hello.html
    }
    
}
