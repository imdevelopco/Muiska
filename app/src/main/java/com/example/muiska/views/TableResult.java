package com.example.muiska.views;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.muiska.models.AnswerQuestionsDAO;

import java.util.ArrayList;

public class TableResult {
    private TableLayout table;
    private TableRow row;
    private TextView cell;
    private String[] header;
    private ArrayList<String[]> data;
    private Context context;
    private int indexC,indexR;

    public TableResult(TableLayout table, Context context) {
        this.table = table;
        this.context = context;
    }

    public void addHeader(String[] header){
        this.header = header;
        createHeader();
    }

    public  void addData(ArrayList<String[]> data){
        this.data = data;
        createTable();
    }

    public void newRow(){
        row = new TableRow(context);
    }
    public void newCell(){
        cell = new TextView(context);
        cell.setGravity(Gravity.CENTER);
        cell.setTextSize(25);
        cell.setTextColor(Color.BLACK);
    }

    public void createHeader(){
        indexC=0;
        newRow();
        while (indexC<header.length){
            newCell();
            cell.setText(header[indexC++]);
            cell.setBackgroundColor(Color.YELLOW);
            row.addView(cell,params());
        }
        table.addView(row);
    }

    public void createTable(){
        String dato;

        for (indexR=1;indexR<=header.length;indexR++){
            newRow();
            for (indexC=0;indexC<header.length;indexC++){
                newCell();
                String[] c = data.get(indexR-1);
                dato =(indexC<c.length)?c[indexC]:"sddsd";
                cell.setText(dato);
                row.addView(cell,params());
            }
            table.addView(row);
        }
    }
    private TableRow.LayoutParams params(){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.setMargins(1,1,1,1);
        layoutParams.weight=1;
        return layoutParams;

    }

}
