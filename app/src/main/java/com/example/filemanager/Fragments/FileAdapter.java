package com.example.filemanager.Fragments;

import android.content.Context;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filemanager.FileViewHolder;
import com.example.filemanager.R;

import java.io.File;
import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileViewHolder> {

    private Context context;
    private List<File> file;

    public FileAdapter(Context context, List<File> file) {
        this.context = context;
        this.file = file;
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FileViewHolder(LayoutInflater.from(context).inflate(R.layout.file_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {

        holder.tvName.setText(file.get(position).getName());
        holder.tvName.setSelected(true);

        int items = 0;
            if(file.get(position).isDirectory()){
                File[] files = file.get(position).listFiles();
                for(File singleFile : files){
                    if(!singleFile.isHidden()){
                        items++;
                    }
                }
                holder.tvSize.setText(String.valueOf(items) + "Files");
            }
            else{
                holder.tvSize.setText(Formatter.formatShortFileSize(context, file.get(position).length()));
            }

            if(file.get(position).getName().toLowerCase().endsWith(".jpeg")){
                holder.imgFile.setImageResource(R.drawable.jpeg_image_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".jpg")){
            holder.imgFile.setImageResource(R.drawable.jpeg_image_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".png")) {
                holder.imgFile.setImageResource(R.drawable.jpeg_image_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".pdf")) {
                holder.imgFile.setImageResource(R.drawable.pdf_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".doc")) {
                holder.imgFile.setImageResource(R.drawable.doc_file_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".mp3")) {
                holder.imgFile.setImageResource(R.drawable.music_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".wav")) {
                holder.imgFile.setImageResource(R.drawable.music_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".mp4")) {
                holder.imgFile.setImageResource(R.drawable.video_file_24);
            }
            else if(file.get(position).getName().toLowerCase().endsWith(".apk")) {
                holder.imgFile.setImageResource(R.drawable.android_24);
            }else{
                holder.imgFile.setImageResource(R.drawable.blue_folder_24);
            }


    }

    @Override
    public int getItemCount() {
        return file.size();
    }
}
