package es.ulpgc.eite.master.visitcanarymvp.detail;

import android.content.Context;

import es.ulpgc.eite.master.visitcanarymvp.data.PlaceStore;
import es.ulpgc.mvp.arch.BaseContract;


interface PlaceDetailContract {

  interface Presenter extends BaseContract.Presenter<View> {

  }

  interface View extends BaseContract.View {

    Context getManagedContext();
    void setupUI(PlaceStore.Place place);
  }

  interface Model extends BaseContract.Model {

    PlaceStore.Place getPlace(Context managedContext, String placeId);
  }

}
