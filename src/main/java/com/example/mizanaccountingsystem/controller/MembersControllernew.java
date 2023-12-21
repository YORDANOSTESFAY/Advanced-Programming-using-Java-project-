package com.example.mizanaccountingsystem.controller;

import com.example.mizanaccountingsystem.model.Member;
import com.example.mizanaccountingsystem.repository.ImemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class MembersControllernew {
    @Autowired
    ImemberRepository memberRepository;

    @RequestMapping(value = "/members/new", method = RequestMethod.GET)
    public String newMemberForm(Model model){
        model.addAttribute("members", new Member());
        return "members/new";
    }
    @RequestMapping(value = "/members/new", method = RequestMethod.POST)
    public String saveMember(Model model, Member members){
        memberRepository.save(members);

        //memberRepository.save(members);
        model.addAttribute("members", members);
        return "redirect:/members/list";

    }
    @RequestMapping(value = "/members/list", method = RequestMethod.GET)
    public String findAllMember(Model model){
        List<Member> members= memberRepository.findAll();
        model.addAttribute("members", members);
        return "members/list";
    }
    @RequestMapping(value = "/members/edit/{id}", method = RequestMethod.GET)
    public String editMember(Model model,@PathVariable Long id){
        Member members= memberRepository.findById(id).orElse(null);
        model.addAttribute("members", members);
        return "members/edit";
    }


    @RequestMapping(value = "/members/edit", method = RequestMethod.POST)
    public String updateMember(Model model,Member members){
        memberRepository.save(members);
        model.addAttribute("members", members);
        return "redirect:/members/list";
    }

    @RequestMapping(value = "/members/delete/{id}", method = RequestMethod.GET)
    public String deleteMember(@PathVariable Long id){
        memberRepository.deleteById(id);
        return "redirect:/members/list";
    }
}
