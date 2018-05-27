package com.sanat.nitolniloy.ndandroidown;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class GalleryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SweetAlertDialog sweetAlertDialog;
    Button btnSASuccess, btnSAError, btnSAWarning, btnSACustomIcon, btnSAConfirmButton, btnSACancelButton, btnSAChnageDialogStyle, btnSALoading;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSASuccess = (Button) findViewById(R.id.btnSASuccess);
        btnSASuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.SUCCESS_TYPE);
                sweetAlertDialog.setTitleText("Good job!");
                sweetAlertDialog.setContentText("You clicked the button!");
                sweetAlertDialog.show();
            }
        });

        btnSAError = (Button) findViewById(R.id.btnSAError);
        btnSAError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("Oops...");
                sweetAlertDialog.setContentText("Something went wrong!");
                sweetAlertDialog.show();
            }
        });

        btnSAWarning = (Button) findViewById(R.id.btnSAWarning);
        btnSAWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.WARNING_TYPE);
                sweetAlertDialog.setTitleText("Are you sure?");
                sweetAlertDialog.setContentText("Won't be able to recover this file!");
                sweetAlertDialog.setConfirmText("Yes,delete it!");
                sweetAlertDialog.show();
            }
        });

        btnSACustomIcon = (Button) findViewById(R.id.btnSACustomIcon);
        btnSACustomIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
                sweetAlertDialog.setTitleText("Sweet!");
                sweetAlertDialog.setContentText("This is a custome Messag. You can change me as you like.");
                sweetAlertDialog.setCustomImage(R.drawable.profile);
                sweetAlertDialog.show();
            }
        });

        btnSAConfirmButton = (Button) findViewById(R.id.btnSAConfirmButton);
        btnSAConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.WARNING_TYPE);
                sweetAlertDialog.setTitleText("Are you sure?");
                sweetAlertDialog.setContentText("Won't be able to recover this file!");
                sweetAlertDialog.setConfirmText("Yes,delete it!");
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
            }
        });

        btnSACancelButton = (Button) findViewById(R.id.btnSACancelButton);
        btnSACancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.WARNING_TYPE);
                sweetAlertDialog.setTitleText("Are you sure?");
                sweetAlertDialog.setContentText("Won't be able to recover this file!");
                sweetAlertDialog.setCancelText("No,cancel plx!");
                sweetAlertDialog.setConfirmText("Yes,delete it!");
                sweetAlertDialog.showCancelButton(true);
                sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                .show();
            }
        });

        btnSAChnageDialogStyle = (Button) findViewById(R.id.btnSAChnageDialogStyle);
        btnSAChnageDialogStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.WARNING_TYPE);
                sweetAlertDialog.setTitleText("Are you sure?");
                sweetAlertDialog.setContentText("Won't be able to recover this file!");
                sweetAlertDialog.setConfirmText("Yes,delete it!");
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog
                                .setTitleText("Deleted!")
                                .setContentText("Your imaginary file has been deleted!")
                                .setConfirmText("OK")
                                .setConfirmClickListener(null)
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                })
                .show();
            }
        });


        btnSALoading = (Button) findViewById(R.id.btnSALoading);
        btnSALoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sweetAlertDialog = new SweetAlertDialog(GalleryActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                sweetAlertDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                sweetAlertDialog.setTitleText("Loading");
                sweetAlertDialog.setCancelable(false);
                sweetAlertDialog.show();

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sweetAlertDialog.dismiss();
                    }
                },3000);
            }
        });





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_home){
            Toast.makeText(GalleryActivity.this, "This is Home", Toast.LENGTH_SHORT).show();
            Intent searchIntent = new Intent(GalleryActivity.this, MainActivity.class);
            finish();
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_camera) {
            Toast.makeText(GalleryActivity.this, "This is Camera", Toast.LENGTH_SHORT).show();
            Intent searchIntent = new Intent(GalleryActivity.this, ImportActivity.class);
            finish();
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(GalleryActivity.this, "This is Gallery", Toast.LENGTH_SHORT).show();
        }  else if (id == R.id.nav_tools) {
            Toast.makeText(GalleryActivity.this, "This is Tools", Toast.LENGTH_SHORT).show();
            Intent searchIntent = new Intent(GalleryActivity.this, ToolsActivity.class);
            finish();
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        } else if (id == R.id.nav_share) {
            Toast.makeText(GalleryActivity.this, "This is Share", Toast.LENGTH_SHORT).show();
            Intent searchIntent = new Intent(GalleryActivity.this, ShareActivity.class);
            finish();
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
