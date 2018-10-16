package es.ulpgc.eite.master.visitcanarymvp.list;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.master.visitcanarymvp.R;
import es.ulpgc.eite.master.visitcanarymvp.data.PlaceStore;
import es.ulpgc.eite.master.visitcanarymvp.detail.PlaceDetailActivity;
import es.ulpgc.mvp.arch.BaseAnnotatedActivity;
import es.ulpgc.mvp.arch.Viewable;


@Viewable(presenter = PlaceListPresenter.class, layout = R.layout.activity_place_list)
public class PlaceListActivity
    extends BaseAnnotatedActivity<PlaceListContract.View, PlaceListContract.Presenter>
    //extends BaseActivity<PlaceListContract.View, PlaceListContract.Presenter>
    implements PlaceListContract.View {


    @Override
    protected PlaceListContract.Presenter initPresenter() {
        return new PlaceListPresenter();
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);
    }
    */

    public Context getManagedContext(){
        return getBaseContext();
    }


    public void setupUI(List<PlaceStore.Place> places) {
        setupToolbar();
        setupAdapter(places);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setTitle(getString(R.string.title_place_list));
        }
    }

    private void setupAdapter(List<PlaceStore.Place> places) {

        RecyclerView recyclerView = findViewById(R.id.place_list);
        recyclerView.setAdapter(new PlaceListAdapter(places));
    }

    public void openDetailActivity() {
        openActivity(PlaceDetailActivity.class);
    }


    class PlaceListAdapter
            extends RecyclerView.Adapter<PlaceListAdapter.PlaceViewHolder> {

        private List<PlaceStore.Place> places;

        public PlaceListAdapter(List<PlaceStore.Place> places) {
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

            holder.placeView.setOnClickListener(view ->
                presenter.placeClicked(holder.placeItem.id)
            );
        }

        @Override
        public int getItemCount() {
            return places.size();
        }

        class PlaceViewHolder extends RecyclerView.ViewHolder {
            public final View placeView;
            public final TextView placeTitleView;
            public PlaceStore.Place placeItem;

            public PlaceViewHolder(View view) {
                super(view);
                placeView = view;
                placeTitleView = view.findViewById(R.id.place_title);
            }

            @Override
            public String toString() {
                return placeTitleView.getText().toString();
            }
        }
    }

}
