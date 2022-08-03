package elone.hoo.mande.store.whitelist;

import elone.hoo.mande.entity.whitelist.po.Whitelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WhitelistStore extends JpaRepository<Whitelist,String>, JpaSpecificationExecutor<Whitelist> {
}
