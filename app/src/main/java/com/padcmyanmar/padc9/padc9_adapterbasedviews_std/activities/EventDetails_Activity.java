package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.R;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.adapters.EventDetailImageAdapter;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetails_Activity extends BaseActivity {

    @BindView(R.id.tvEventTitle)
    TextView tvEventTitle;

    @BindView(R.id.tvDiscount)
    TextView tvDiscount;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.ivTagImage)
    ImageView ivTagImage;

    @BindView(R.id.tvDate)
    TextView tvDate;

    @BindView(R.id.tvCategory)
    Button tvCategory;

    @BindView(R.id.tvAge)
    TextView tvAgeRange;

    public static final String EXTRA_ID_EXTRA = "eventIdExtra";

    public static Intent newIntent(Context context, int eventIdExtra){
        Intent intent = new Intent(context, EventDetails_Activity.class);
        intent.putExtra(EXTRA_ID_EXTRA, eventIdExtra);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        ButterKnife.bind(this);

        ViewPager viewPager = findViewById(R.id.viewPager);

        EventDetailImageAdapter eventDetailImageAdapter = new EventDetailImageAdapter();
        viewPager.setAdapter(eventDetailImageAdapter);

        int eventId = getIntent().getIntExtra(EXTRA_ID_EXTRA, 0);

        EventVO eventVO = eventModel.findEventById(eventId);
        bindData(eventVO);
    }

    private void bindData(EventVO eventVO){
        tvEventTitle.setText(eventVO.getEventName());
        Glide.with(ivTagImage).load(eventVO.getEventOrganizer().getOrganizerPhotoUrl()).into(ivTagImage);
        tvDate.setText(eventVO.getEventStartTime());
        tvAgeRange.setText(eventVO.getEventRequirements().getAgeRange());
    }
}
