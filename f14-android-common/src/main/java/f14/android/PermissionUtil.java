package f14.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by f14shm4n on 09.11.2017.
 */

public class PermissionUtil {

    /**
     * Determines whether the specified permission is granted.
     *
     * @param ctx        Context.
     * @param permission Permission.
     * @return True if granted or false if not.
     */
    public static boolean permissionGranted(@NonNull Context ctx, @NonNull String permission) {
        int permState = ContextCompat.checkSelfPermission(ctx, permission);
        return permissionGranted(permState);
    }

    /**
     * Checks the results of permissions.
     * @param permissionsStates Permissions grant results set.
     * @return True if granted or false if not.
     */
    public static boolean allPermissionsGranted(int[] permissionsStates) {
        for (int i = 0; i < permissionsStates.length; i++) {
            int state = permissionsStates[i];
            if (!permissionGranted(state)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the single result of permissions.
     * @param permissionState Permission grant result.
     * @return True if granted or false if not.
     */
    public static boolean permissionGranted(int permissionState) {
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }
}
