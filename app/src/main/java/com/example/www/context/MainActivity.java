package com.example.www.context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView article = (TextView)findViewById(R.id.article);
        registerForContextMenu(article);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.context_menu,menu);
    }

    public void displayToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.edit:
                displayToast(getString(R.string.edit_message));
                break;
            case R.id.share:
                displayToast(getString(R.string.share_message));
                break;
            case R.id.delete:
                displayToast(getString(R.string.delete_message));
            default:
                break;
        }

        return super.onContextItemSelected(item);
    }
}
