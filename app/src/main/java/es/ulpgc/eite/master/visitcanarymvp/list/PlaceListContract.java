package es.ulpgc.eite.master.visitcanarymvp.list;

import android.content.Context;

import java.util.List;

import es.ulpgc.eite.master.visitcanarymvp.data.PlaceStore;
import es.ulpgc.mvp.arch.BaseContract;


interface PlaceListContract {

  interface Presenter extends BaseContract.Presenter<View> {

    void placeClicked(String placeId);
  }

  interface View extends BaseContract.View {

    Context getManagedContext();
    void setupUI(List<PlaceStore.Place> places);
    void openDetailActivity();
  }

  interface Model extends BaseContract.Model {

    List<PlaceStore.Place> getPlaces(Context managedContext);
  }

}
