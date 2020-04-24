package org.mula.finance.automation;

import android.content.*;
import androidx.appcompat.widget.*;
import androidx.appcompat.widget.Toolbar;
import android.widget.*;
import org.mula.finance.R;
import org.mula.androidbase.activities.BaseRootView;
import org.mula.androidbase.utils.StyledResources;
import org.mula.finance.core.models.HabitList;
import java.util.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u001eH\u0002R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lorg/mula/finance/automation/EditSettingRootView;", "Lorg/mula/androidbase/activities/BaseRootView;", "context", "Landroid/content/Context;", "habitList", "Lorg/mula/finance/core/models/HabitList;", "controller", "Lorg/mula/finance/automation/EditSettingController;", "args", "Lorg/mula/finance/automation/SettingUtils$Arguments;", "(Landroid/content/Context;Lorg/mula/finance/core/models/HabitList;Lorg/mula/finance/automation/EditSettingController;Lorg/mula/finance/automation/SettingUtils$Arguments;)V", "actionSpinner", "Landroidx/appcompat/widget/AppCompatSpinner;", "getActionSpinner", "()Landroidx/appcompat/widget/AppCompatSpinner;", "setActionSpinner", "(Landroidx/appcompat/widget/AppCompatSpinner;)V", "habitSpinner", "getHabitSpinner", "setHabitSpinner", "tbar", "Landroidx/appcompat/widget/Toolbar;", "getTbar", "()Landroidx/appcompat/widget/Toolbar;", "setTbar", "(Landroidx/appcompat/widget/Toolbar;)V", "getToolbar", "getToolbarColor", "", "onClickSave", "", "populateHabitSpinner", "mula-main_debug"})
public final class EditSettingRootView extends org.mula.androidbase.activities.BaseRootView {
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = org.mula.finance.R.id.toolbar)
    public androidx.appcompat.widget.Toolbar tbar;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = org.mula.finance.R.id.habitSpinner)
    public androidx.appcompat.widget.AppCompatSpinner habitSpinner;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = org.mula.finance.R.id.actionSpinner)
    public androidx.appcompat.widget.AppCompatSpinner actionSpinner;
    private final org.mula.finance.core.models.HabitList habitList = null;
    private final org.mula.finance.automation.EditSettingController controller = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.Toolbar getTbar() {
        return null;
    }
    
    public final void setTbar(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.Toolbar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatSpinner getHabitSpinner() {
        return null;
    }
    
    public final void setHabitSpinner(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatSpinner p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatSpinner getActionSpinner() {
        return null;
    }
    
    public final void setActionSpinner(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatSpinner p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.appcompat.widget.Toolbar getToolbar() {
        return null;
    }
    
    @java.lang.Override()
    public int getToolbarColor() {
        return 0;
    }
    
    @butterknife.OnClick(value = {2131361927})
    public final void onClickSave() {
    }
    
    private final void populateHabitSpinner() {
    }
    
    public EditSettingRootView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.HabitList habitList, @org.jetbrains.annotations.NotNull()
    org.mula.finance.automation.EditSettingController controller, @org.jetbrains.annotations.Nullable()
    org.mula.finance.automation.SettingUtils.Arguments args) {
        super(null);
    }
}