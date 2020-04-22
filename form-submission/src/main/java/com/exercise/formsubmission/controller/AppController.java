package com.exercise.formsubmission.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.exercise.formsubmission.model.AppModel;
import com.exercise.formsubmission.model.Customer;
import com.exercise.formsubmission.service.CustomerService;

@Controller
public class AppController {
    final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/getAppForm")
    public String getAppForm(ModelMap modelMap) {
        logger.info("get customers");
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer c : customers) {
            logger.info("###### {}-{}-{}", c.getId(), c.getName(), c.getEmail());
        }

        modelMap.addAttribute("customers", customers);
        return "appForm";
    }

    @GetMapping("/")
    public String index(ModelMap modelMap) {

        return getAppForm(modelMap);
    }

    @PostMapping("/viewAppDetails")
    public String viewAppDetails(@RequestParam("name") String name, @RequestParam("email") String email,
            ModelMap modelMap) {

        modelMap.put("name", name);
        modelMap.put("email", email);
        modelMap.put("appName", appModel.getAppName());

        Customer customer = new Customer();

        customer.setName(name);
        customer.setEmail(email);

        customerService.addCustomer(customer);
        
        logger.info("add customer");

        return "appDetails";
    }

    @Value("${app.name}")
    private String appName;
    @Autowired
    private AppModel appModel;

    @Bean
    public AppModel getAppName() {

        AppModel anAppModel = new AppModel();

        anAppModel.setAppName(appName);

        return anAppModel;
    }
}