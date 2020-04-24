package org.mula.finance.activities.habits.list.views;

import android.content.*;
import android.os.*;
import androidx.recyclerview.widget.*;
import android.view.*;
import com.google.auto.factory.*;
import org.mula.finance.R;
import org.mula.finance.activities.common.views.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.models.Habit;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003123B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eJ.\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020 J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eJ\b\u0010+\u001a\u00020\u001dH\u0014J\b\u0010,\u001a\u00020\u001dH\u0014J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020/H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HabitCardListView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "adapter", "Lorg/mula/finance/activities/habits/list/views/HabitCardListAdapter;", "cardViewFactory", "error/NonExistentClass", "controller", "Ldagger/Lazy;", "Lorg/mula/finance/activities/habits/list/views/HabitCardListController;", "(Landroid/content/Context;Lorg/mula/finance/activities/habits/list/views/HabitCardListAdapter;Lerror/NonExistentClass;Ldagger/Lazy;)V", "attachedHolders", "", "Lorg/mula/finance/activities/habits/list/views/HabitCardViewHolder;", "Lerror/NonExistentClass;", "checkmarkCount", "", "getCheckmarkCount", "()I", "setCheckmarkCount", "(I)V", "value", "dataOffset", "getDataOffset", "setDataOffset", "touchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "attachCardView", "", "holder", "bindCardView", "Landroid/view/View;", "habit", "Lorg/mula/finance/core/models/Habit;", "score", "", "checkmarks", "", "selected", "", "createHabitCardView", "detachCardView", "onAttachedToWindow", "onDetachedFromWindow", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "CardViewGestureDetector", "Controller", "TouchHelperCallback", "mula-main_debug"})
@com.google.auto.factory.AutoFactory()
public final class HabitCardListView extends androidx.recyclerview.widget.RecyclerView {
    private int checkmarkCount;
    private int dataOffset;
    private final java.util.List<org.mula.finance.activities.habits.list.views.HabitCardViewHolder> attachedHolders = null;
    private final androidx.recyclerview.widget.ItemTouchHelper touchHelper = null;
    private final org.mula.finance.activities.habits.list.views.HabitCardListAdapter adapter = null;
    private final HabitCardViewFactory cardViewFactory = null;
    private final dagger.Lazy<org.mula.finance.activities.habits.list.views.HabitCardListController> controller = null;
    
    public final int getCheckmarkCount() {
        return 0;
    }
    
    public final void setCheckmarkCount(int p0) {
    }
    
    public final int getDataOffset() {
        return 0;
    }
    
    public final void setDataOffset(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View createHabitCardView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View bindCardView(@org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.habits.list.views.HabitCardViewHolder holder, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit, double score, @org.jetbrains.annotations.NotNull()
    int[] checkmarks, boolean selected) {
        return null;
    }
    
    public final void attachCardView(@org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.habits.list.views.HabitCardViewHolder holder) {
    }
    
    public final void detachCardView(@org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.habits.list.views.HabitCardViewHolder holder) {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    @java.lang.Override()
    protected void onRestoreInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Parcelable state) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.os.Parcelable onSaveInstanceState() {
        return null;
    }
    
    public HabitCardListView(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityContext()
    @com.google.auto.factory.Provided()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    org.mula.finance.activities.habits.list.views.HabitCardListAdapter adapter, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    HabitCardViewFactory cardViewFactory, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    dagger.Lazy<org.mula.finance.activities.habits.list.views.HabitCardListController> controller) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HabitCardListView$Controller;", "", "drop", "", "from", "", "to", "onItemClick", "pos", "onItemLongClick", "startDrag", "position", "mula-main_debug"})
    public static abstract interface Controller {
        
        public abstract void drop(int from, int to);
        
        public abstract void onItemClick(int pos);
        
        public abstract void onItemLongClick(int pos);
        
        public abstract void startDrag(int position);
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void drop(org.mula.finance.activities.habits.list.views.HabitCardListView.Controller $this, int from, int to) {
            }
            
            public static void onItemClick(org.mula.finance.activities.habits.list.views.HabitCardListView.Controller $this, int pos) {
            }
            
            public static void onItemLongClick(org.mula.finance.activities.habits.list.views.HabitCardListView.Controller $this, int pos) {
            }
            
            public static void startDrag(org.mula.finance.activities.habits.list.views.HabitCardListView.Controller $this, int position) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HabitCardListView$CardViewGestureDetector;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "holder", "Lorg/mula/finance/activities/habits/list/views/HabitCardViewHolder;", "(Lorg/mula/finance/activities/habits/list/views/HabitCardListView;Lorg/mula/finance/activities/habits/list/views/HabitCardViewHolder;)V", "onLongPress", "", "e", "Landroid/view/MotionEvent;", "onSingleTapUp", "", "mula-main_debug"})
    final class CardViewGestureDetector extends android.view.GestureDetector.SimpleOnGestureListener {
        private final org.mula.finance.activities.habits.list.views.HabitCardViewHolder holder = null;
        
        @java.lang.Override()
        public void onLongPress(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e) {
        }
        
        @java.lang.Override()
        public boolean onSingleTapUp(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e) {
            return false;
        }
        
        public CardViewGestureDetector(@org.jetbrains.annotations.NotNull()
        org.mula.finance.activities.habits.list.views.HabitCardViewHolder holder) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HabitCardListView$TouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "(Lorg/mula/finance/activities/habits/list/views/HabitCardListView;)V", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onMove", "from", "to", "onSwiped", "", "direction", "mula-main_debug"})
    public final class TouchHelperCallback extends androidx.recyclerview.widget.ItemTouchHelper.Callback {
        
        @java.lang.Override()
        public int getMovementFlags(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            return 0;
        }
        
        @java.lang.Override()
        public boolean onMove(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.ViewHolder from, @org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.ViewHolder to) {
            return false;
        }
        
        @java.lang.Override()
        public void onSwiped(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int direction) {
        }
        
        @java.lang.Override()
        public boolean isItemViewSwipeEnabled() {
            return false;
        }
        
        @java.lang.Override()
        public boolean isLongPressDragEnabled() {
            return false;
        }
        
        public TouchHelperCallback() {
            super();
        }
    }
}