package com.yevhenberladyniuk.debts.controller;

import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreatePartnerForm;
import com.yevhenberladyniuk.debts.dto.PartnerDto;
import com.yevhenberladyniuk.debts.service.PartnerService;
import com.yevhenberladyniuk.debts.service.PartnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/partners")
public class PartnerController {

    private PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerServiceImpl partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public String findAll(@AuthenticationPrincipal User user, Model model){

        List<Partner> partners = partnerService.findAll(user);
        model.addAttribute("partners", partners);

        return "partner/partnersList";
    }

    @GetMapping("/new")
    public String newPartner(){
        return "partner/add";
    }

    @PostMapping("/new")
    public String savePartner(CreatePartnerForm createPartnerForm, @AuthenticationPrincipal User user){

        partnerService.create(createPartnerForm, user);
        return "redirect:/partners";
    }

    @PostMapping("/delete/{id}")
    public String deletePartner(@PathVariable Long id, @AuthenticationPrincipal User user){

        partnerService.deletePartnerById(id, user);
        return "redirect:/partners";
    }

    @GetMapping("/edit/{id}")
    public String editPartner(@PathVariable Long id, Model model, @AuthenticationPrincipal User user){

        Partner partner = partnerService.findPartnerById(id, user);
        model.addAttribute("partner", partner);

        return "partner/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPartner(@PathVariable Long id, PartnerDto partnerDto, @AuthenticationPrincipal User user){

        partnerService.updatePartnerById(id, partnerDto, user);
        return "redirect:/partners";
    }
}
