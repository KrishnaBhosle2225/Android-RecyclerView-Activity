package com.krishna.recyclerviewactivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder>{

    Context mContext;
    List<UserDetails> mUserDetails;


    public AdapterUser(Context mContext, List<UserDetails> mUserDetails) {
        this.mContext = mContext;
        this.mUserDetails = mUserDetails;
    }

    @NonNull
    @Override
    public AdapterUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cityView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_custom_view, parent, false);

        return new ViewHolder(cityView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUser.ViewHolder holder, int position) {
        UserDetails details = mUserDetails.get(position);

        holder.name.setText(details.getName());
        holder.phone.setText(details.getPhone());
        holder.email.setText(details.getEmail());
        holder.website.setText(details.getWebsite());

    }

    @Override
    public int getItemCount() {
        return mUserDetails.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,phone,email,website;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);

            email = itemView.findViewById(R.id.textViewemail);
            website = itemView.findViewById(R.id.textViewWebsite);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,ShowDetails.class);
                    intent.putExtra("mName",name.getText().toString().trim());
                    intent.putExtra("mPhone",phone.getText().toString().trim());
                    intent.putExtra("mEmail",email.getText().toString().trim());
                    intent.putExtra("mWebsite",website.getText().toString().trim());
                    mContext.startActivity(intent);
                }
            });

            phone = itemView.findViewById(R.id.textViewPhone);
            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+"9082875143"));
                    mContext.startActivity(intent);
                }
            });

            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Intent intent = new Intent(Intent.ACTION_SEND);
//                    mContext.startActivity(intent);
                    Intent intentEmail = new Intent(Intent.ACTION_SEND);

                    intentEmail.putExtra(Intent.EXTRA_EMAIL,email.getText().toString().trim());
                    intentEmail.putExtra(Intent.EXTRA_SUBJECT,"Regarding to Visit");
                    intentEmail.putExtra(Intent.EXTRA_TEXT, "Hello how are you all !!!");


                    intentEmail.setType("message/rfc822");

                    mContext.startActivity(Intent.createChooser(intentEmail, "Choose an valid Email  :"));
                }
            });


            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://"+website.getText().toString().trim()));
                    mContext.startActivity(intent);
                }
            });

        }


    }



}
