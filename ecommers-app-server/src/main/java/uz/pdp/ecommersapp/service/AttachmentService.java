package uz.pdp.ecommersapp.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.ecommersapp.entity.Attachment;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public interface AttachmentService {
    Attachment save(MultipartHttpServletRequest request);
    void getFile(HttpServletResponse response, Integer id);
    void  deleteFile(UUID id);
}
