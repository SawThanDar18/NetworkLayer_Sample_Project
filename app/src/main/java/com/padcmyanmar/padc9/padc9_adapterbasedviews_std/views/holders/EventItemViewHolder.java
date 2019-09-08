package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.R;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.delegates.EventItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventItemViewHolder extends BaseViewHolder<EventVO>{

    private EventItemDelegate eventItemDelegate;

    @BindView(R.id.tvEventName)
    TextView tvEventName;

    @BindView(R.id.tvStartTime)
    TextView tvStartTime;

    @BindView(R.id.tvAgeRange)
    TextView tvAgeRange;

    @BindView(R.id.tvLocation)
    TextView tvLocation;

    @BindView(R.id.tvAddress)
    TextView tvAddress;

    @BindView(R.id.tvOrganizerName)
    TextView tvOrganizerName;

    @BindView(R.id.tvEventOwnerRole)
    TextView tvEventOwnerRole;

    @BindView(R.id.ivEvent)
    ImageView ivEvent;

    @BindView(R.id.ivGender)
    ImageView ivGender;

    @BindView(R.id.ivOrganizer)
    ImageView ivOrganizer;

    @BindView(R.id.tvEndTime)
    TextView tvEndTime;

    public EventItemViewHolder(@NonNull View itemView, final EventItemDelegate delegate) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        eventItemDelegate = delegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventItemDelegate.onTapEventItem(mData.getId());
            }
        });
    }

    @Override
    public void bindData(EventVO data) {

        mData = data;  //bind data

        tvEventName.setText(data.getEventName());
        tvStartTime.setText(data.getEventStartTime());
        tvEndTime.setText(data.getEventEndTime());
        tvLocation.setText(data.getEventLocation());
        tvAddress.setText(data.getEventLocationFullAddress());
        tvOrganizerName.setText(data.getEventOrganizer().getOrganizerName());
        tvEventOwnerRole.setText(data.getEventOrganizer().getOrganizerRole());
        Glide.with(itemView)
                .load(data.getEventOrganizer().getOrganizerPhotoUrl())
                .into(ivOrganizer);
    }
}
