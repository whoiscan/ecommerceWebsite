package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Attachment;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface AttachmentRepository  extends JpaRepository<Attachment, UUID> {
    @Transactional()
    @Override
    <S extends Attachment> S save(S s);
}
