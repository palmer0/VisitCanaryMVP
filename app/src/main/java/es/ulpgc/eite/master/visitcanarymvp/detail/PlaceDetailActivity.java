package es.ulpgc.eite.master.visitcanarymvp.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.master.visitcanarymvp.R;
import es.ulpgc.eite.master.visitcanarymvp.master.PlaceListPresenter;
import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;
import es.ulpgc.mvp.arch.BaseActivity;


//@Viewable(presenter = PlaceDetailPresenter.class, layout = R.layout.activity_place_detail)
public class PlaceDetailActivity
    //extends BaseAnnotatedActivity<PlaceDetailContract.View, PlaceDetailContract.Presenter>
    extends BaseActivity<PlaceDetailContract.View, PlaceDetailContract.Presenter>
    implements PlaceDetailContract.View {
    
    
    //public static final String PARAM_PLACE_ID = "place_to_visit_id";

    //private PlaceStore placeStore;
    //private PlaceDetailPresenter presenter;

    @Override
    protected PlaceDetailContract.Presenter initPresenter() {
        return new PlaceDetailPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        //presenter = new PlaceDetailPresenter(this);

        //fillPlaceStore();
        //setupUI();

    }


    public Context getManagedContext(){
        return getBaseContext();
    }

    public void setupUI(PlaceStore.Place place){
        //setContentView(R.layout.activity_place_detail);

        setupToolbar(place.title);

        ImageView placePicture = findViewById(R.id.place_picture);
        int resId = getResources().getIdentifier(
            place.picture, "drawable", getPackageName());
        placePicture.setImageResource(resId);

        TextView placeDetail = findViewById(R.id.place_detail);
        placeDetail.setText(place.details);
    }

    /*
    private void setupUI(){
        setContentView(R.layout.activity_place_detail);

        String placeId = getIntent().getStringExtra(PARAM_PLACE_ID);
        PlaceStore.Place place = placeStore.getPlaceById(placeId);

        if (place != null) {
            setupToolbar(place.title);

            TextView placeDetail = (TextView) findViewById(R.id.place_detail);
            placeDetail.setText(place.details);
            ImageView placePicture = (ImageView) findViewById(R.id.place_picture);

            int resId= getResources().getIdentifier(place.picture, "drawable", getPackageName());
            placePicture.setImageResource(resId);
        }
    }
    */

    /*
    private void fillPlaceStore(){
        Resources res = getResources();
        List<String> titles = Arrays.asList(res.getStringArray(R.array.places_titles));
        List<String> details = Arrays.asList(res.getStringArray(R.array.places_details));
        List<String> pictures = Arrays.asList(res.getStringArray(R.array.places_pictures));

        placeStore = new PlaceStore(titles, details, pictures);
    }
    */

    private void setupToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(title);
        }
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            //navigateUpTo(new Intent(this, PlaceListActivity.class));
            //return true;
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    */
}
