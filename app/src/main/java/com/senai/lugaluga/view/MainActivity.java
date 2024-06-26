package com.senai.lugaluga.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.senai.lugaluga.R;
import com.senai.lugaluga.RecyclerItemClickListener;
import com.senai.lugaluga.model.Produto;
import com.senai.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList = new ArrayList<>();

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Produtos");
        myToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(myToolbar);

        recyclerView = findViewById(R.id.rvlistaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), produtoList.get(position).getStatus(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }

    public void CriarListaProdutos(){

        Produto produto;

        produto = new Produto("IPhone 13", "Iphone 13 64gb", 200.00, 10, "Disponível");
        produtoList.add(produto);

        produto = new Produto("Fone", "Bluetooth", 25.00, 120, "Indisponível");
        produtoList.add(produto);

        produto = new Produto("Notebook", "16gb RAM 1TB-SSD", 250, 5, "Indisponível");
        produtoList.add(produto);

        produto = new Produto("IPad", "8gb RAM", 200, 10, "Indisponível");
        produtoList.add(produto);

        produto = new Produto("Tablet", "SamSung 8gb", 50.00, 120, "Disponível");
        produtoList.add(produto);

        produto = new Produto("SmartPhone S23", "não compre", 70.00, 12, "Disponível");
        produtoList.add(produto);

        produto = new Produto("MacBook", "M3 1TB-SSD", 425.50 , 6, "Indisponível");
        produtoList.add(produto);

        produto = new Produto("IPhone 15", "124gb RAM", 125.90, 8, "Disponível");
        produtoList.add(produto);


    }

}