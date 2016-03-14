package com.fuxuemingzhu.findjoy.module.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fuxuemingzhu.findjoy.R;
import com.fuxuemingzhu.findjoy.model.bean.TextJoy;
import com.fuxuemingzhu.findjoy.utils.RecentDateFormat;
import com.fuxuemingzhu.findjoy.utils.TextFilter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.utils.JTimeTransform;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class TextJoyVH extends BaseViewHolder<TextJoy> {
    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.time)
    TextView time;

    public TextJoyVH(ViewGroup parent) {
        super(parent, R.layout.item_joy_text);
        ButterKnife.bind(this, itemView);

    }


    @Override
    public void setData(TextJoy data) {
        content.setText(TextFilter.filter(data.getText()));
        time.setText(new JTimeTransform().parse("yyyy-MM-dd hh:mm:ss", data.getCt()).toString(new RecentDateFormat()));
        itemView.setOnClickListener(view ->
                new MaterialDialog.Builder(getContext())
                        .title(R.string.select)
                        .content(R.string.copy)
                        .positiveText(R.string.agree)
                        .negativeText(R.string.disagree)
                        .onPositive((dialog, which) -> {
                            // Gets a handle to the clipboard service.
                            ClipboardManager clipboard = (ClipboardManager) getContext().
                                    getSystemService(Context.CLIPBOARD_SERVICE);
                            // Creates a new text clip to put on the clipboard
                            ClipData clip = ClipData.newPlainText("joy", data.getText());
                            // Set the clipboard's primary clip.
                            clipboard.setPrimaryClip(clip);
                            Snackbar.make(itemView, "已将该段子复制到粘贴板", Snackbar.LENGTH_SHORT).show();
                        })
                        .show()
        );
    }
}
