package f14.android;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by f14shm4n on 28.11.2017.
 */

public final class ViewUtil {

    @Nullable
    public static <V> V findViewById(@NonNull View root, @IdRes int id, @NonNull Class<V> caster) {
        View view = root.findViewById(id);
        if (view != null) {
            return caster.cast(view);
        }
        return null;
    }
}
