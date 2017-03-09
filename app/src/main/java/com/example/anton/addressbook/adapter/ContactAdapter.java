package com.example.anton.addressbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anton.addressbook.R;
import com.example.anton.addressbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 09/03/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactVH> {
    List<Contact> dataSet = new ArrayList<>();

    public void setDataSet(ArrayList<Contact> dataSet) {
        this.dataSet = dataSet;
    }

    public void addContact(Contact contact){
        dataSet.add(contact);
        notifyDataSetChanged();
    }

    public void removeContact(int position){
        dataSet.remove(position);
        notifyItemRemoved(position);
    }

    public void updateContact(String name, String surname, String phone, String email, int position){     //questo metodo aggiorna il contatto prendendolo da una certa posizione e mettendolo nella var contact
        Contact contact = dataSet.get(position);
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setEmail(email);
        notifyItemChanged(position);
    }

    @Override
    public ContactAdapter.ContactVH onCreateViewHolder(ViewGroup parent, int viewType) {  //quale layout devo andare a prendere
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactVH(view);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ContactVH holder, int position) {   //è quello che ti setta tutti i valori del ViewHolder
        holder.name.setText(dataSet.get(position).getName());
        holder.surname.setText(dataSet.get(position).getSurname());
    }

    @Override
    public int getItemCount() {       //ritorna la grandezza degli oggetti che gli stiamo dando: tramite questo metodo stabiliamo la grandezza della RecyclerView
        return dataSet.size();
    }

    public class ContactVH extends RecyclerView.ViewHolder {
        TextView name, surname;

        public ContactVH(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name_Tv);
            surname = (TextView) view.findViewById(R.id.surname_Tv);
        }
    }


}
