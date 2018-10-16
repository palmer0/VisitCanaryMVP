package es.ulpgc.eite.master.visitcanarymvp.master;

import android.content.Context;
import android.util.Log;

import java.util.List;

import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;
import es.ulpgc.mvp.arch.BaseModel;

public class PlaceListModel
    extends BaseModel<PlaceListContract.Presenter> implements PlaceListContract.Model {


  private PlaceStore store;

  @Override
  public void onPresenterCreated() {
    super.onPresenterCreated();
    Log.d("VisitCanary.List.Model", "onPresenterCreated");
  }

  public void initStore(Context managedContext){
    Log.d("VisitCanary.List.Model", "initStore");

    store = new PlaceStore(managedContext);
  }

  public List<PlaceStore.Place> getPlaces() {
    return store.getPlaces();
  }

}
