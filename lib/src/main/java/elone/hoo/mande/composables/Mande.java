package elone.hoo.mande.composables;

import elone.hoo.mande.enums.Promise;
import elone.hoo.mande.store.MandeStore;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class Mande {

  private final MandeStore mandeStore;

  public void useAccept(Promise promise, String modelId, Map<String,String> body, Map<String,String> headers) {

  }



}
