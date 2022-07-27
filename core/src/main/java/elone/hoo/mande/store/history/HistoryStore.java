package elone.hoo.mande.store.history;

import elone.hoo.mande.entity.history.po.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryStore extends JpaRepository<History,String>, JpaSpecificationExecutor<History>{

}
