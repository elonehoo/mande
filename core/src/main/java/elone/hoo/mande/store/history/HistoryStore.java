package elone.hoo.mande.store.history;

import elone.hoo.mande.entity.history.po.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * History store
 * @author Elone Hoo <huchengyea@163.com>
 */
@Repository
public interface HistoryStore extends JpaRepository<History,String>, JpaSpecificationExecutor<History>{

  /**
   * get history entity list by status
   *
   * @param flag false is to get the list of the history entity that is not processed
   * @return History entity list
   */
  List<History> findByStateAndPromise(boolean flag,String promise);
}
