package es.ulpgc.eite.master.visitcanarymvp.master;

import android.content.Intent;

import es.ulpgc.eite.master.visitcanarymvp.detail.PlaceDetailActivity;
import es.ulpgc.eite.master.visitcanarymvp.detail.PlaceDetailPresenter;
import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;

/**
 * Created by Luis on 16/10/17.
 */

public class PlaceListPresenter {

  private PlaceListActivity view;
  //private PlaceStore placeStore;
  private PlaceStore model;

  public PlaceListPresenter(PlaceListActivity view) {
    this.view=view;
    //fillPlaceStore();
    model = new PlaceStore(view);
    setupUI();
  }

  private void setupUI(){
    if(view != null) {
      //view.setupUI(placeStore.getPlaces());
      view.setupUI(model.getPlaces());
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
    if(view != null) {
      //Context context = view.getContext();
      //Intent intent = new Intent(context, PlaceDetailActivity.class);
      Intent intent = new Intent(view, PlaceDetailActivity.class);
      intent.putExtra(PlaceDetailPresenter.PARAM_PLACE_ID, placeId);
      //context.startActivity(intent);
      view.startActivity(intent);
    }
  }
}
