package es.ulpgc.eite.master.visitcanarymvp.list;

import android.content.Context;
import android.util.Log;

import java.util.List;

import es.ulpgc.eite.master.visitcanarymvp.data.PlaceRepository;
import es.ulpgc.eite.master.visitcanarymvp.data.PlaceStore;
import es.ulpgc.mvp.arch.BaseModel;

public class PlaceListModel
    extends BaseModel<PlaceListContract.Presenter> implements PlaceListContract.Model {


  @Override
  public void onPresenterCreated() {
    super.onPresenterCreated();
    Log.d("VisitCanary.List.Model", "onPresenterCreated");
  }


  @Override
  public List<PlaceStore.Place> getPlaces(Context managedContext) {
    return PlaceRepository.getInstance(managedContext).getPlaces();
  }


}
