package es.ulpgc.eite.master.visitcanarymvp.detail;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;
import es.ulpgc.mvp.arch.BaseModel;

public class PlaceDetailModel
    extends BaseModel<PlaceDetailContract.Presenter> implements PlaceDetailContract.Model {


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

  @Override
  public PlaceStore.Place getPlace(String placeId) {
    return store.getPlaceById(placeId);
  }

}
