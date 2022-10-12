package com.springboot.sampleprj.controller;

import com.springboot.sampleprj.model.CompanyShare;
import com.springboot.sampleprj.service.CompanyShareService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/company")
public class ShareController {

    @Autowired
    CompanyShareService companyShareService;

    @GetMapping(value = "/list")
    public ModelAndView list() {

        ModelAndView model = new ModelAndView("companyshare_list");
        List<CompanyShare> companyShareList = companyShareService.getAllCompanyShares();
        model.addObject("companyShareList", companyShareList);

        return model;
    }

    @GetMapping(value = "/addcompanyshare/")
    public ModelAndView addCompanyShare() {

        ModelAndView model = new ModelAndView();
        CompanyShare cmpShare = new CompanyShare();
        model.addObject("companyShareForm", cmpShare);
        model.setViewName("companyshare_form");

        return model;
    }

    @GetMapping(value = "/editcompanyshare/{id}")
    public ModelAndView editCompanyShare(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        CompanyShare cmShare = companyShareService.getCompanyShareById(id);
        model.addObject("companyShareForm", cmShare);
        model.setViewName("companyshare_form");

        return model;
    }

    @GetMapping(value = "/addcompanyshare")
    public ModelAndView add(@ModelAttribute("companyShareForm") CompanyShare cmpShare) {

        companyShareService.addCompanyShare(cmpShare);
        return new ModelAndView("redirect:/company/list");

    }

    @GetMapping(value = "/deletecompany/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {

        companyShareService.deleteCompanyShare(id);
        return new ModelAndView("redirect:/company/list");

    }

}
