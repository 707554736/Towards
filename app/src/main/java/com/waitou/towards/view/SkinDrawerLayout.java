package com.waitou.towards.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

import com.jaeger.library.StatusBarUtil;
import com.to.aboomy.theme_lib.skin.SkinCompatSupportable;
import com.to.aboomy.theme_lib.config.ThemeUtils;
import com.waitou.towards.R;

/**
 * Created by waitou on 17/3/5.
 */

public class SkinDrawerLayout extends DrawerLayout implements SkinCompatSupportable {

    public SkinDrawerLayout(Context context) {
        this(context, null);
    }

    public SkinDrawerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void applySkin() {
        StatusBarUtil.setColorNoTranslucentForDrawerLayout((Activity) getContext(), this, ThemeUtils.getThemeAttrColor(getContext(), R.attr.colorPrimary));
    }
}
