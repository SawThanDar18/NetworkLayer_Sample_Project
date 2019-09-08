package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.R;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.adapters.EventListAdapter;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.models.EventModel;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.delegates.EventItemDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements EventItemDelegate {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        final EventListAdapter adapter = new EventListAdapter(this);
        recyclerView.setAdapter(adapter);

        eventModel.getEvents(new EventModel.GetEventsFromNetworkDelegate() {
            @Override
            public void onSuccess(List<EventVO> events) {
                adapter.setNewData(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                showSnackbar(errorMessage);
            }
        });
    }

    @Override
    public void onTapEventItem(int eventId) {
        Intent intent = EventDetails_Activity.newIntent(getApplicationContext(), eventId);
        startActivity(intent);
    }
}
