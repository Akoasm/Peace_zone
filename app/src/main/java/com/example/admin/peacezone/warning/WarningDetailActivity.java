package com.example.admin.peacezone.warning;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.peacezone.BaseActivity;
import com.example.admin.peacezone.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/9/1.
 */
public class WarningDetailActivity extends BaseActivity {


    @Bind(R.id.toolbar_return)
    ImageView toolbarReturn;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.warning_detail_typetv)
    TextView warningDetailTypetv;
    @Bind(R.id.warning_detail_note)
    TextView warningDetailNote;
    @Bind(R.id.warning_edit)
    EditText warningEdit;
    @Bind(R.id.warning_rl)
    RelativeLayout warningRl;
    @Bind(R.id.warning_detail_arrow)
    ImageView warningDetailArrow;
    @Bind(R.id.warning_detail_button)
    Button warningDetailButton;

    @Override
    public void setLayout() {
        setContentView(R.layout.warning_detail);
    }

    @Override
    public void setView() {
        warningRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = getResources().getStringArray(R.array.item);
                new AlertDialog.Builder(WarningDetailActivity.this).setTitle("请选择报警类型")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                new AlertDialog.Builder(WarningDetailActivity.this)
                                        .setTitle("您选择了：" + items[i])
                                        .setMessage("确定报警？")
                                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                warningDetailTypetv.setText(items[i]);
                                                warningDetailArrow.setVisibility(View.GONE);
                                            }
                                        })
                                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                //点击取消后的操作
                                            }
                                        }).show();
                            }
                        }).show();


            }
        });
        warningDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri sendUri = Uri.parse("smsto:");
                Intent intent = new Intent(Intent.ACTION_SENDTO, sendUri);
//                intent.putExtra("sms_body",smsBody);
                startActivity(intent);


            }
        });

    }

    @Override
    public void getdata() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
