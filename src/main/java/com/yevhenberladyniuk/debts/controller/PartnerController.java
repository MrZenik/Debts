package com.yevhenberladyniuk.debts.controller;

import com.yevhenberladyniuk.debts.domain.Debt;
import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreatePartnerForm;
import com.yevhenberladyniuk.debts.dto.PartnerDto;
import com.yevhenberladyniuk.debts.service.DebtService;
import com.yevhenberladyniuk.debts.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partners")
public class PartnerController {

    private DebtService debtService;

    private PartnerService partnerService;

    @Autowired
    public PartnerController(DebtService debtService, PartnerService partnerService) {
        this.debtService = debtService;
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

        partnerService.deleteById(id, user);
        return "redirect:/partners";
    }

    @GetMapping("/edit/{id}")
    public String editPartner(@PathVariable Long id, Model model, @AuthenticationPrincipal User user){

        Partner partner = partnerService.findById(id, user);
        model.addAttribute("partner", partner);

        return "partner/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPartner(@PathVariable Long id, PartnerDto partnerDto, @AuthenticationPrincipal User user){

        partnerService.updateById(id, partnerDto, user);
        return "redirect:/partners";
    }

    @GetMapping("/{partnerId}")
    public String findPartner(@PathVariable Long partnerId, Model model, @AuthenticationPrincipal User user){

        Partner partner = partnerService.findById(partnerId, user);
        model.addAttribute("partner", partner);

        List<Debt> debts = debtService.findAllByPartner(partnerId, user);
        model.addAttribute("debts", debts);

        return "partner/partnerInfo";
    }

}
