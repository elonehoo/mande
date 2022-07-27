package elone.hoo.mande.service.history;

import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;

public interface HistoryService {

  History save(InstallHistory history);
}
