package f14.android.collections;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import f14.common.functions.Function;

/**
 * Created by f14shm4n on 28.11.2017.
 */

public abstract class ExtendedAdapter<T> extends BaseAdapter {

    private List<T> list;
    private Context context;
    private int layoutId;

    private Function<View> viewFactory;

    public ExtendedAdapter(@NonNull Context context, @LayoutRes int layoutId, @NonNull List<T> objects) {
        this.context = context;
        this.list = objects;
        this.layoutId = layoutId;
    }

    public ExtendedAdapter(@NonNull Context context, @NonNull List<T> objects, @NonNull Function<View> viewFactory) {
        this.context = context;
        this.list = objects;
        this.viewFactory = viewFactory;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            if (viewFactory != null) {
                view = viewFactory.run();
            } else {
                view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(layoutId, parent, false);
            }
        }

        processView(position, view, parent, list.get(position));

        return view;
    }

    public abstract void processView(int position, @NonNull View view, ViewGroup parent, @NonNull T item);
}
