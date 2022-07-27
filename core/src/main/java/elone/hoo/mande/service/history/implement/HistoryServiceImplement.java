package elone.hoo.mande.service.history.implement;

import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.service.history.HistoryService;
import elone.hoo.mande.store.history.HistoryStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HistoryServiceImplement implements HistoryService {

  @Resource
  private HistoryStore historyStore;


  @Override
  public History save(InstallHistory entity) {
    History history = historyStore.save(entity.useHistory());
    return history;
  }
}
