package ch.swissonid.design_lib_sample.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ch.swissonid.design_lib_sample.R;


public class ListItem extends RelativeLayout{

    private String mText;
    private Drawable mLeftIcon;

    @InjectView(R.id.list_item_left_icon)
    ImageView mLeftIconView;

    @InjectView(R.id.list_item_text)
    TextView mTextView;

    public ListItem(Context context){
        super(context);
        init();
        onFinishInflate();
    }

    public ListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        getAttributes(context, attrs);
    }

    private void init() {
        inflate(getContext(), R.layout.list_item_widget, this);
    }

    private void getAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ListItem,
                0, 0);
        try {
            mText = typedArray.getString(R.styleable.ListItem_text);
            mLeftIcon = typedArray.getDrawable(R.styleable.ListItem_leftIcon);

        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
        setText(mText);
        setLeftIcon(mLeftIcon);
    }

    public void setLeftIcon(final Drawable leftIcon) {
        if(isInEditMode()) return;
        mLeftIconView.setImageDrawable(leftIcon);
    }

    public void setText(final String text){
        if(isInEditMode()) return;
        mTextView.setText(text);
    }
}
