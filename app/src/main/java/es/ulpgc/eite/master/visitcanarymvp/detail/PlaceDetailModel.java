package es.ulpgc.eite.master.visitcanarymvp.detail;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.master.visitcanarymvp.data.PlaceRepository;
import es.ulpgc.eite.master.visitcanarymvp.data.PlaceStore;
import es.ulpgc.mvp.arch.BaseModel;

public class PlaceDetailModel
    extends BaseModel<PlaceDetailContract.Presenter> implements PlaceDetailContract.Model {


  @Override
  public void onPresenterCreated() {
    super.onPresenterCreated();
    Log.d("VisitCanary.List.Model", "onPresenterCreated");
  }


  @Override
  public PlaceStore.Place getPlace(Context managedContext, String placeId) {
    return PlaceRepository.getInstance(managedContext).getPlace(placeId);
  }


}
