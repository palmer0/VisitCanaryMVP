package es.ulpgc.eite.master.visitcanarymvp.master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.master.visitcanarymvp.R;
import es.ulpgc.eite.master.visitcanarymvp.model.PlaceStore;


public class PlaceListActivity extends AppCompatActivity {

    //private PlaceStore placeStore;
    private PlaceListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new PlaceListPresenter(this);
        //fillPlaceStore();
        //setupUI();

    }

    /*
    private void setupUI(){
        setContentView(R.layout.activity_place_list);

        setupToolbar();
        setupRecyclerView();
    }
    */

    public void setupUI(List<PlaceStore.Place> places){
        setContentView(R.layout.activity_place_list);

        setupToolbar();
        setupRecyclerView(places);
    }

    private void setupRecyclerView(List<PlaceStore.Place> places) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);
        recyclerView.setAdapter(new PlaceRecyclerViewAdapter(places));
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    /*
    private void setupRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);
        recyclerView.setAdapter(new PlaceRecyclerViewAdapter(placeStore.getPlaces()));
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


    class PlaceRecyclerViewAdapter
            extends RecyclerView.Adapter<PlaceRecyclerViewAdapter.PlaceViewHolder> {

        private List<PlaceStore.Place> places;

        public PlaceRecyclerViewAdapter(List<PlaceStore.Place> places) {
            this.places = places;
        }

        @Override
        public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.place_list_content, parent, false);
            return new PlaceViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final PlaceViewHolder holder, int position) {
            holder.placeItem = places.get(position);
            holder.placeTitleView.setText(places.get(position).title);
            //holder.placeTitleView.setText(holder.placeItem.title);

            holder.placeIdView.setText(places.get(position).id);

            holder.placeView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    presenter.placeClicked(holder.placeItem.id);

                    /*
                    Context context = view.getContext();
                    Intent intent = new Intent(context, PlaceDetailActivity.class);
                    intent.putExtra(PlaceDetailActivity.PARAM_PLACE_ID, holder.placeItem.id);
                    context.startActivity(intent);
                    */
                }
            });
        }

        @Override
        public int getItemCount() {
            return places.size();
        }

        class PlaceViewHolder extends RecyclerView.ViewHolder {
            public final View placeView;
            public final TextView placeTitleView;
            public final TextView placeIdView;
            public PlaceStore.Place placeItem;

            public PlaceViewHolder(View view) {
                super(view);
                placeView = view;
                placeTitleView = view.findViewById(R.id.place_title);
                placeIdView = view.findViewById(R.id.place_id);
            }

            @Override
            public String toString() {
                return placeTitleView.getText().toString();
            }
        }
    }
}
