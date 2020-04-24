package org.mula.finance.automation;

import android.content.*;
import org.mula.finance.*;
import org.mula.finance.receivers.*;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.ui.widgets.WidgetBehavior;
import org.mula.finance.core.utils.DateUtils;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"ACTION_CHECK", "", "ACTION_TOGGLE", "ACTION_UNCHECK", "EXTRA_BUNDLE", "", "EXTRA_STRING_BLURB", "mula-main_debug"})
public final class FireSettingReceiverKt {
    public static final int ACTION_CHECK = 0;
    public static final int ACTION_UNCHECK = 1;
    public static final int ACTION_TOGGLE = 2;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_BUNDLE = "com.twofortyfouram.locale.intent.extra.BUNDLE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_STRING_BLURB = "com.twofortyfouram.locale.intent.extra.BLURB";
}