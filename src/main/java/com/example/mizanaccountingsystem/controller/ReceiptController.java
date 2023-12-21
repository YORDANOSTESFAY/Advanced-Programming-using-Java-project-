package com.example.mizanaccountingsystem.controller;
import com.example.mizanaccountingsystem.model.Receipt;
import com.example.mizanaccountingsystem.model.Member;
import com.example.mizanaccountingsystem.repository.ImemberRepository;
import com.example.mizanaccountingsystem.repository.IreceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.List;
@Controller
public class ReceiptController {

    @Autowired
    IreceiptRepository receiptrepository;

    @Autowired
    ImemberRepository memberRepository;
    @RequestMapping(value = "/receipts/new", method = RequestMethod.GET)
    public String newreceiptsForm(Model model){
        Receipt receipts=new Receipt();
        model.addAttribute("receipts", receipts);
        List<Member> members= memberRepository.findAll();
        model.addAttribute("member",members);
        return "receipts/new";
    }
    @RequestMapping(value = "/receipts/new", method = RequestMethod.POST)
    public String saveReceipts(Model model, Receipt receipts){
        receiptrepository.save(receipts);
        model.addAttribute("receipts", receipts);
        return "redirect:/receipts/list";

    }
    @RequestMapping(value = "/receipts/list", method = RequestMethod.GET)
    public String findAllDownloads(Model model){
        List<Receipt> receipt= receiptrepository.findAll();
        model.addAttribute("receipt", receipt);
        return "receipts/list";
    }
    @RequestMapping(value = "/receipts/edit/{id}", method = RequestMethod.GET)
    public String editDownloads(Model model,@PathVariable Long id){
        Receipt receipts= receiptrepository.findById(id).orElse(null);
        model.addAttribute("receipts", receipts);
        List<Member> members= memberRepository.findAll();
        model.addAttribute("member",members);
        return "receipts/edit";

    }


    @RequestMapping(value = "/receipts/edit", method = RequestMethod.POST)
    public String updateDownloads(Model model,Receipt receipts){
        receiptrepository.save(receipts);
        model.addAttribute("receipts", receipts);
        return "redirect:/receipts/list";
    }

    @RequestMapping(value = "/receipts/delete/{id}", method = RequestMethod.GET)
    public String deleteDownloads(@PathVariable Long id){
        receiptrepository.deleteById(id);
        return "redirect:/receipts/list";
    }
}
