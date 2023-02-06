package learn.android.demoalertdialog;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        Button btn = new Button(this);
        btn.setText("open AD");
        setContentView(btn);
        btn.setOnClickListener(view -> {
//            createAndOpenAlertDialog();
            createAndOpenAlertDialogWidthView();
        });
    }
    private void createAndOpenAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("super titre");
        builder.setMessage("hello");
        builder.setPositiveButton("ok", (dialogInterface, i) -> {
            Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("nop", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Nop", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("je sais pas", (dialogInterface, i) -> {
            finish();
        });
        builder.show();
    }
    private void createAndOpenAlertDialogWidthView() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("super titre");
        EditText ed = new EditText(context);
        final int id = View.generateViewId();
        ed.setId(id);
        builder.setView(ed);
        builder.setPositiveButton("ok", (dialogInterface, i) -> {
            Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("nop", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Nop", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("je sais pas", (dialogInterface, i) -> {
            AlertDialog alertDialog = (AlertDialog) dialogInterface;
            EditText editText = alertDialog.findViewById(id);
            Toast.makeText(context, "value : " + editText.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        builder.show();
    }
}