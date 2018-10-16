package es.ulpgc.eite.master.visitcanarymvp.detail;

import android.content.Context;

import java.util.List;

import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;
import es.ulpgc.mvp.arch.BaseContract;


interface PlaceDetailContract {

  interface Presenter extends BaseContract.Presenter<View> {

  }

  interface View extends BaseContract.View {

    Context getManagedContext();
    void setupUI(PlaceStore.Place place);
  }

  interface Model extends BaseContract.Model {

    void initStore(Context managedContext);
    PlaceStore.Place getPlace(String placeId);
  }

}
