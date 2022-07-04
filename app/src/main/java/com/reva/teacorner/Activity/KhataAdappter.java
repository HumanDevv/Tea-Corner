package com.reva.teacorner.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reva.teacorner.R;

import java.util.List;

public class KhataAdappter extends RecyclerView.Adapter<KhataAdappter.ViewHolder>{
    private Context mCtx;
    private List<Khata> khataList;

    public KhataAdappter(Context mCtx, List<Khata> khataList) {
        this.mCtx = mCtx;
        this.khataList = khataList;
    }

    @NonNull
    @Override
    public KhataAdappter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.row_khata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhataAdappter.ViewHolder holder, int position) {
Khata khata= khataList.get(position);
holder.tvname.setText(khata.getUsrname());
holder.tvdate.setText(khata.getDate());
holder.tvprice.setText(khata.getAmount());

      if (khata.getPaid()){
          holder.status.setText("Paid");
      }
      else {
          holder.status.setText("Pending");

      }
    }

    @Override
    public int getItemCount() {
        return khataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvname,tvdate,tvprice,status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvdate= itemView.findViewById(R.id.tvdate);
            tvname= itemView.findViewById(R.id.tvname);
            tvprice= itemView.findViewById(R.id.tvprice);
            status= itemView.findViewById(R.id.status);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            Khata khata=khataList.get(getAdapterPosition());
            Intent intent= new Intent(mCtx,UpdateActivity.class);
            intent.putExtra("khata",khata);
            mCtx.startActivity(intent);
        }
    }
}
