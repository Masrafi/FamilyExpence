package com.example.lenovo.familyexpence;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{
    private Context context;
    private List<Employee> employeeList;
    private ItemDeleteListener listener;

    public PersonAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
        listener = (ItemDeleteListener) context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(
                R.layout.employee_row, parent, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, final int position) {
        holder.nameTV.setText(employeeList.get(position).getName());
        holder.desgTV.setText(employeeList.get(position).getDesignation());
        holder.menuTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.person_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_edit:
                                //
                                break;
                            case R.id.menu_delete:
                                final int rowId = employeeList.get(position).getEmployeeId();
                                listener.onItemDelete(rowId);
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, employeeList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {
        //ImageView personIV;
        TextView nameTV, desgTV, menuTV;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            // personIV = itemView.findViewById(R.id.row_emp_image);
            nameTV = itemView.findViewById(R.id.row_emp_name);
            desgTV = itemView.findViewById(R.id.row_emp_desg);
            menuTV = itemView.findViewById(R.id.row_emp_info);
        }
    }

    public void updateList(List<Employee> employees){
        this.employeeList = employees;
        notifyDataSetChanged();
    }

    interface ItemDeleteListener{
        void onItemDelete(int rowId);
    }
}