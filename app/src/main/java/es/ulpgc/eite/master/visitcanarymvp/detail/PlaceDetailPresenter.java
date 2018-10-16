package es.ulpgc.eite.master.visitcanarymvp.detail;

import android.annotation.SuppressLint;
import android.util.Log;

import es.ulpgc.eite.master.visitcanarymvp.master.PlaceListModel;
import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;
import es.ulpgc.mvp.arch.BasePresenter;

/**
 * Created by Luis on 16/10/17.
 */

public class PlaceDetailPresenter
    extends BasePresenter<PlaceDetailContract.View, PlaceDetailContract.Model>
    implements PlaceDetailContract.Presenter {

  public static final String PARAM_PLACE_ID = "place_to_visit_id";

  //private PlaceDetailActivity view;
  //private PlaceStore placeStore;
  //private PlaceStore model;


//  public PlaceDetailPresenter(PlaceDetailActivity view) {
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
  protected PlaceDetailContract.Model initModel() {
    return new PlaceDetailModel();
  }

  private void setupUI(){
    if(isViewAttached()) {

      String placeId = getInStateBundle().getString(PARAM_PLACE_ID);
      PlaceStore.Place place = model.getPlace(placeId);

      if (place != null) {
        getView().setupUI(place);
      }

    }
  }


//  private void setupUI(){
//    if(view != null) {
//      String placeId = view.getIntent().getStringExtra(PARAM_PLACE_ID);
//      //PlaceStore.Place place = placeStore.getPlaceById(placeId);
//      PlaceStore.Place place = model.getPlaceById(placeId);
//
//      if (place != null) {
//        view.setupUI(place);
//      }
//
//    }
//  }

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

}
