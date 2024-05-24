package at.htl.carshop;

import android.os.Bundle;

import androidx.activity.ComponentActivity;

import javax.inject.Inject;

import at.htl.carshop.ui.layout.MainViewBuilder;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {
    @Inject
    MainViewBuilder mainViewBuilder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewBuilder.setContentOfActivity(this);
    }
}
