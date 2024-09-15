package v1.openai;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
    ChatService chatService;

    public Controller(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/query")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }
}
