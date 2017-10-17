package es.ulpgc.eite.master.visitcanarymvp.detail;

import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;

/**
 * Created by Luis on 16/10/17.
 */

public class PlaceDetailPresenter {

  public static final String PARAM_PLACE_ID = "place_to_visit_id";

  private PlaceDetailActivity view;
  //private PlaceStore placeStore;
  private PlaceStore model;

  public PlaceDetailPresenter(PlaceDetailActivity view) {
    this.view=view;
    //fillPlaceStore();
    model = new PlaceStore(view);
    setupUI();
  }

  private void setupUI(){
    if(view != null) {
      String placeId = view.getIntent().getStringExtra(PARAM_PLACE_ID);
      //PlaceStore.Place place = placeStore.getPlaceById(placeId);
      PlaceStore.Place place = model.getPlaceById(placeId);

      if (place != null) {
        view.setupUI(place);
      }

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

}
