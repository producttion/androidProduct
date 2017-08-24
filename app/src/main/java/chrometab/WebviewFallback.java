package chrometab;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.example.teerasaksathu.production.WebviewActivity;

import chrometab.CustomTabActivityHelper;

/**
 * Created by Naetirat on 8/24/2017.
 */

public class WebviewFallback implements CustomTabActivityHelper.CustomTabFallback {
    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, WebviewActivity.class);
        intent.putExtra("KEY_URL", uri.toString());
        activity.startActivity(intent);

    }


}