package com.example.GuestBook.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.GuestBook.model.Message;
import com.example.GuestBook.service.MessageService;
import com.example.GuestBook.service.UserService;

@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(MessageController.class);

	@GetMapping("/")
	public String index(Model model, @RequestParam(name = "send", defaultValue = "") String send,
			@RequestParam(name = "receive", defaultValue = "") String receive,
			@RequestParam(name = "mess", defaultValue = "") String mess) {
		// logger.info(send+":"+receive);
		model.addAttribute("users", userService.findAll());
		model.addAttribute("messages", messageService.findByUsernameAndUserreceive(send, receive));
		model.addAttribute("lastselected", send);
		model.addAttribute("lastselectedreceive", receive);
		if (mess.length() != 0 && !send.isEmpty() && !receive.isEmpty()) {
			messageService.save(new Message(send, mess, receive));
			return "redirect:/?send=" + send + "&receive=" + receive;
		} else
			return "message";
	}

	@GetMapping("/message/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("message", messageService.findOne(id));
		return "formmessage";
	}

	@PostMapping("/message/save")
	public String save(@Valid Message message, BindingResult result, RedirectAttributes redirect) {

		logger.info(message.getMes());

		if (result.hasErrors()) {
			return "form";
		}
		messageService.save(message);
		redirect.addFlashAttribute("success", "Saved message successfully!");
		return "redirect:/?send=" + message.getUsername() + "&receive=" + message.getUserreceive();
	}

	@GetMapping("/message/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		String send = messageService.findOne(id).getUsername();
		String receive = messageService.findOne(id).getUserreceive();
		messageService.delete(id);
		redirect.addFlashAttribute("success", "Deleted message successfully!");
		return "redirect:/?send=" + send + "&receive=" + receive;
	}

}
