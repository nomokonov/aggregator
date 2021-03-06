package ru.nomokonov.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nomokonov.aggregator.domain.Account;
import ru.nomokonov.aggregator.domain.User;
import ru.nomokonov.aggregator.repos.AccountRepo;
import ru.nomokonov.aggregator.repos.UserRepo;
import ru.nomokonov.aggregator.service.AccountService;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private AccountService accountService;


    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user,
                       @RequestParam(required = false, defaultValue = "") String filter,
                       Model model) {

        List<Account> accounts = accountService.findAll(user);
        model.addAttribute("accounts", accounts);
        return "accountsList";
    }

//    @PostMapping("/main")
//    public String add(
//            @AuthenticationPrincipal User user,
//            @Valid Message message,
//            BindingResult bindingResult,
//            Model model,
//            @RequestParam("file") MultipartFile file
//    ) throws IOException {
//        message.setAuthor(user);
//
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
//
//            model.mergeAttributes(errorsMap);
//            model.addAttribute("message", message);
//        } else {
//            if (file != null && !file.getOriginalFilename().isEmpty()) {
//                File uploadDir = new File(uploadPath);
//
//                if (!uploadDir.exists()) {
//                    uploadDir.mkdir();
//                }
//
//                String uuidFile = UUID.randomUUID().toString();
//                String resultFilename = uuidFile + "." + file.getOriginalFilename();
//
//                file.transferTo(new File(uploadPath + "/" + resultFilename));
//
//                message.setFilename(resultFilename);
//            }
//
//            model.addAttribute("message", null);
//
//            messageRepo.save(message);
//        }
//
//        Iterable<Message> messages = messageRepo.findAll();
//
//        model.addAttribute("messages", messages);
//
//        return "main";
//    }

}
