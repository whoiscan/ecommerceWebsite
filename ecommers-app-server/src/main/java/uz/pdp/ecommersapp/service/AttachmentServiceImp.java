package uz.pdp.ecommersapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.ecommersapp.entity.Attachment;
import uz.pdp.ecommersapp.entity.AttachmentContent;
import uz.pdp.ecommersapp.repository.AttachmentContentRepository;
import uz.pdp.ecommersapp.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

@Service
public class AttachmentServiceImp implements AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @Override
    public Attachment save(MultipartHttpServletRequest request) {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        Attachment image = new Attachment();

        while (itr.hasNext()) {
            try {
                mpf = request.getFile(itr.next());
                image.setName(mpf.getName());
                image.setOriginalName(mpf.getOriginalFilename());
                image.setSize(mpf.getSize());
                image.setContentType(mpf.getContentType());
                image = attachmentRepository.save(image);
                AttachmentContent content = new AttachmentContent();
                content.setBytes(mpf.getBytes());
                content.setAttachment(image);
               attachmentContentRepository.save(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

    @Override
    public void getFile(HttpServletResponse response, Integer id) {
        try {
            AttachmentContent content = attachmentContentRepository.getOne(id);
            response.setContentType(content.getAttachment().getContentType());
           FileCopyUtils.copy(content.getBytes(), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteFile(UUID id) {
        attachmentRepository.deleteById(id);
    }
}
