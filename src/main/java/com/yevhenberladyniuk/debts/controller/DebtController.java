package com.yevhenberladyniuk.debts.controller;

import com.yevhenberladyniuk.debts.domain.Debt;
import com.yevhenberladyniuk.debts.domain.Partner;
import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreateDebt;
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

import java.util.List;

@Controller
@RequestMapping("/debts")
public class DebtController {

    private DebtService debtService;

    private PartnerService partnerService;

    @Autowired
    public DebtController(DebtService debtService, PartnerService partnerService) {
        this.debtService = debtService;
        this.partnerService = partnerService;
    }

    @GetMapping("/{partnerId}")
    public String findDebt(@PathVariable Long partnerId, Model model, @AuthenticationPrincipal User user){

        List<Debt> debts = debtService.findAllByPartner(partnerService.findById(partnerId, user));
        model.addAttribute("debts", debts);
        model.addAttribute("partner", partnerService.findById(partnerId, user));

        return "debt/debtList";
    }

    @GetMapping("/create/{partnerId}")
    public String create(@PathVariable Long partnerId, @AuthenticationPrincipal User user, Model model){

        Partner partner = partnerService.findById(partnerId, user);
        model.addAttribute("partner", partner);

        return "debt/create";
    }

    @PostMapping("/create/{partnerId}")
    public String create(CreateDebt createDebt, @PathVariable Long partnerId, @AuthenticationPrincipal User user){

        Partner partner = partnerService.findById(partnerId, user);
        debtService.create(createDebt, partner);

        return "redirect:/debts/" + partner.getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteDebt(@PathVariable Long id, Long partnerId, @AuthenticationPrincipal User user){
        debtService.deleteById(partnerService.findById(partnerId, user), id);

        return "redirect:/debts/" + partnerId;
    }

}
