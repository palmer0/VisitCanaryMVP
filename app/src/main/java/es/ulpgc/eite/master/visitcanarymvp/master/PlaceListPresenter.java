package es.ulpgc.eite.master.visitcanarymvp.master;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;

import es.ulpgc.eite.master.visitcanarymvp.detail.PlaceDetailPresenter;
import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;
import es.ulpgc.mvp.arch.BasePresenter;

/**
 * Created by Luis on 16/10/17.
 */

public class PlaceListPresenter
    extends BasePresenter<PlaceListContract.View, PlaceListContract.Model>
    implements PlaceListContract.Presenter {

  //private PlaceListActivity view;
  //private PlaceStore placeStore;
  //private PlaceStore model;


//  public PlaceListPresenter(PlaceListActivity view) {
//    this.view=view;
//    //fillPlaceStore();
//    model = new PlaceStore(view);
//    setupUI();
//  }


  @SuppressLint("LongLogTag")
  @Override
  public void onPresenterCreated() {
    super.onPresenterCreated();
    Log.d("VisitCanary.List.Presenter", "onPresenterCreated");

    if(isViewAttached()) {
      model.initStore(getView().getManagedContext());
    }
  }

  @SuppressLint("LongLogTag")
  @Override
  public void onPresenterResumed() {
    super.onPresenterResumed();
    Log.d("VisitCanary.List.Presenter", "onPresenterResumed");

    setupUI();
  }


  @SuppressLint("LongLogTag")
  @Override
  public void onPresenterDestroy() {
    super.onPresenterDestroy();
    Log.d("VisitCanary.List.Presenter", "onPresenterDestroy");
  }


  @Override
  protected PlaceListContract.Model initModel() {
    return new PlaceListModel();
  }

  
  private void setupUI(){
    if(isViewAttached()) {
      //view.setupUI(placeStore.getPlaces());
      getView().setupUI(model.getPlaces());
    }
  }

  /*
  private void fillPlaceStore(){
    if(view != null) {
      Resources res = view.getResources();
      List<String> titles = Arrays.asList(res.getStringArray(R.array.places_titles));
      List<String> details = Arrays.asList(res.getStringArray(R.array.places_details));
      List<String> pictures = Arrays.asList(res.getStringArray(R.array.places_pictures));

      placeStore = new PlaceStore(titles, details, pictures);
    }
  }
  */

  public void placeClicked(String placeId) {
    if(isViewAttached()) {
      getOutStateBundle().putString(PlaceDetailPresenter.PARAM_PLACE_ID, placeId);
      getView().openDetailActivity();
    }
  }

//  public void placeClicked(String placeId) {
//    if(view != null) {
//      //Context context = view.getContext();
//      //Intent intent = new Intent(context, PlaceDetailActivity.class);
//      Intent intent = new Intent(view, PlaceDetailActivity.class);
//      intent.putExtra(PlaceDetailPresenter.PARAM_PLACE_ID, placeId);
//      //context.startActivity(intent);
//      view.startActivity(intent);
//    }
//  }

}
