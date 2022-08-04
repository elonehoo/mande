package elone.hoo.mande.store.model;

import elone.hoo.mande.entity.model.po.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Model store
 * @author Elone Hoo <huchengyea@163.com>
 */
@Repository
public interface ModelStore extends JpaRepository<Model,String>, JpaSpecificationExecutor<Model> {
}
