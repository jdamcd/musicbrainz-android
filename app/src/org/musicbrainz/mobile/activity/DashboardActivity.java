/*
 * Copyright (C) 2010 Jamie McDonald
 * 
 * This file is part of MusicBrainz for Android.
 * 
 * MusicBrainz for Android is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later version.
 * 
 * MusicBrainz for Android is distributed in the hope that it 
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MusicBrainz for Android. If not, see 
 * <http://www.gnu.org/licenses/>.
 */

package org.musicbrainz.mobile.activity;

import org.musicbrainz.android.api.webservice.HttpClient;
import org.musicbrainz.mobile.MusicBrainzApplication;
import org.musicbrainz.mobile.R;
import org.musicbrainz.mobile.fragment.WelcomeFragment;
import org.musicbrainz.mobile.util.PreferenceUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class DashboardActivity extends MusicBrainzActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == IntentIntegrator.BARCODE_REQUEST) {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            if (scanResult.getContents() != null) {
                Intent barcodeResult = new Intent(this, ReleaseActivity.class);
                barcodeResult.putExtra(Extra.BARCODE, scanResult.getContents());
                startActivity(barcodeResult);
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.scan_btn:
            IntentIntegrator.initiateScan(DashboardActivity.this, getString(R.string.zx_title),
                    getString(R.string.zx_message), getString(R.string.zx_pos), getString(R.string.zx_neg),
                    IntentIntegrator.PRODUCT_CODE_TYPES);
            break;
        case R.id.collection_btn:
            Toast.makeText(this, "Collections not implemented...", Toast.LENGTH_SHORT).show();
            break;
        case R.id.donate_btn:
            startActivity(new Intent(this, DonateActivity.class));
            break;
        case R.id.about_btn:
            startActivity(new Intent(this, AboutActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.dash, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_login).setVisible(!isUserLoggedIn());
        menu.findItem(R.id.menu_logout).setVisible(isUserLoggedIn());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.menu_logout) {
            logOut();
            updateWelcomeText();
            return true;
        }
        return false;
    }

    public void updateWelcomeText() {
        try {
            WelcomeFragment f = (WelcomeFragment) getSupportFragmentManager().findFragmentById(R.id.welcome_fragment);
            f.updateText();
        } catch (Exception e) {
            // Fragment not attached, nothing to do.
        }
    }

    private void logOut() {
        PreferenceUtils.clearUser(getApplicationContext());
        HttpClient.clearCredentials();
        MusicBrainzApplication app = (MusicBrainzApplication) getApplicationContext();
        app.updateLoginStatus(false);
        Toast.makeText(this, R.string.toast_logged_out, Toast.LENGTH_SHORT).show();
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

}