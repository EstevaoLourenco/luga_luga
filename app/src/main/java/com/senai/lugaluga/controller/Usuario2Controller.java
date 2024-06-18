package com.senai.lugaluga.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Usuario2Controller {

    private SQLiteDatabase db;
    private CriarBanco banco;

    public Usuario2Controller(Context context){
        banco = new CriarBanco(context);
    }

    public boolean insereDados(String nome, String cpf, String dataNasc,
                              String cep, String municipio, String uf, String loagradouro,
                              int numero, String complemento, String bairro,
                              int telefone, String email, String senha){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.NOME, nome);
        valores.put(CriarBanco.CPF, cpf);
        valores.put(CriarBanco.DATA_NASC, dataNasc);
        valores.put(CriarBanco.CEP, cep);
        valores.put(CriarBanco.MUNICIPIO, municipio);
        valores.put(CriarBanco.UF, uf);
        valores.put(CriarBanco.LOGRADOURO, loagradouro);
        valores.put(CriarBanco.NUMERO, numero);
        valores.put(CriarBanco.COMPLEMENTO, complemento);
        valores.put(CriarBanco.BAIRRO, bairro);
        valores.put(CriarBanco.TELEFONE, telefone);
        valores.put(CriarBanco.EMAIL, email);
        valores.put(CriarBanco.SENHA, senha);

        resultado = db.insert(CriarBanco.NOME_TABELA, null, valores);
        db.close();

        if (resultado == -1){
            return false;
        }

        return true;

    }

    public boolean verificaUsuario(String email, String senha){

        String selection = "email = ? and senha = ?";

        String[] selectionArgs = {email, senha};

        Cursor cursor;
        db = banco.getReadableDatabase();
        cursor = db.query( CriarBanco.NOME_TABELA, null, selection, selectionArgs,
                null, null, null, null);

        if (cursor.getCount() > 0){
            return true;
        }

        return false;
    }

}
