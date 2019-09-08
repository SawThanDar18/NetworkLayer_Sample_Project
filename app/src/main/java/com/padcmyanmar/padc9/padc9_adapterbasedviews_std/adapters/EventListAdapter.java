package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.R;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.delegates.EventItemDelegate;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.views.holders.EventItemViewHolder;

public class EventListAdapter extends BaseRecyclerAdapter<EventItemViewHolder, EventVO> {

    private EventItemDelegate eventItemDelegate;

    public EventListAdapter(EventItemDelegate eventItemDelegate) {
        this.eventItemDelegate = eventItemDelegate;
    }

    @NonNull
    @Override
    public EventItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_list_items, viewGroup, false);
        return new EventItemViewHolder(itemView, eventItemDelegate);
    }
}
