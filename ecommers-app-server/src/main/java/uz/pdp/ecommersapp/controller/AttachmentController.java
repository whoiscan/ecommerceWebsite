package uz.pdp.ecommersapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.ecommersapp.entity.Attachment;
import uz.pdp.ecommersapp.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/api/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    @ResponseBody
    public UUID save(MultipartHttpServletRequest request){
        Attachment attachment=attachmentService.save(request);
        return attachment.getId();
    }
    @GetMapping("/getFile/{id}")
    public void getFile(HttpServletResponse response, @PathVariable Integer id){
        attachmentService.getFile(response,id);
    }

}
