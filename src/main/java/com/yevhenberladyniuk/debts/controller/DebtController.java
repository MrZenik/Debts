package com.yevhenberladyniuk.debts.controller;

import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreateDebtForm;
import com.yevhenberladyniuk.debts.dto.DebtDto;
import com.yevhenberladyniuk.debts.service.DebtService;
import com.yevhenberladyniuk.debts.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partners/{partnerId}/debts")
public class DebtController {

    private DebtService debtService;

    private PartnerService partnerService;

    @Autowired
    public DebtController(DebtService debtService, PartnerService partnerService) {
        this.debtService = debtService;
        this.partnerService = partnerService;
    }

    @GetMapping("/create")
    public String create(@PathVariable Long partnerId, Model model, @AuthenticationPrincipal User user){

        Partner partner = partnerService.findById(partnerId, user);
        model.addAttribute("partner", partner);

        return "debt/create";
    }

    @PostMapping("/create")
    public String create(CreateDebtForm createDebt, @PathVariable Long partnerId, @AuthenticationPrincipal User user){

        debtService.create(createDebt, user);

        return "redirect:/partners/" + partnerId;
    }

    @PostMapping("/delete/{id}")
    public String deleteDebt(@PathVariable Long id, @PathVariable Long partnerId, @AuthenticationPrincipal User user){

        debtService.deleteById(partnerId, id, user);

        return "redirect:/partners/" + partnerId;
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long partnerId, @PathVariable Long id, Model model, @AuthenticationPrincipal User user){

        model.addAttribute("partner", partnerService.findById(partnerId, user));
        model.addAttribute("debt", debtService.findByIdAndPartnerId(id, partnerId, user));

        return "debt/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long partnerId, @PathVariable Long id, DebtDto debtDto, @AuthenticationPrincipal User user){

        debtService.updateById(id, debtDto, partnerId, user);
        return "redirect:/partners/" + partnerId;
    }

}
