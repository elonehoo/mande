package elone.hoo.mande.store.whitelist;

import elone.hoo.mande.entity.whitelist.po.Whitelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Whitelist store
 * @author Elone Hoo <huchengyea@163.com>
 */
@Repository
public interface WhitelistStore extends JpaRepository<Whitelist,String>, JpaSpecificationExecutor<Whitelist> {
  Whitelist findByAppKeyAndName(String appKey, String name);
}
