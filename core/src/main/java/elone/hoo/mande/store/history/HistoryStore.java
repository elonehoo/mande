package elone.hoo.mande.store.history;

import elone.hoo.mande.entity.history.po.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * History store
 * @author Elone Hoo <huchengyea@163.com>
 */
@Repository
public interface HistoryStore extends JpaRepository<History,String>, JpaSpecificationExecutor<History>{

}
