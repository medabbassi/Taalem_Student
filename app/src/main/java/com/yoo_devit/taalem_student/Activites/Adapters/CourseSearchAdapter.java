package com.yoo_devit.taalem_student.Activites.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yoo_devit.taalem_student.Beans.Course;
import com.yoo_devit.taalem_student.R;

import java.util.List;

public class CourseSearchAdapter extends RecyclerView.Adapter<CourseSearchAdapter.CourseViewHolder> {
    private Context mCtx;
    private List<Course> courseList;

            public CourseSearchAdapter(Context mCtx,List<Course> courseList){
                this.mCtx=mCtx;
                this.courseList=courseList;
            }

    @NonNull
    @Override
    public CourseSearchAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.course_list,null);

        return new CourseSearchAdapter.CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseSearchAdapter.CourseViewHolder holder, int i) {
        Course course =courseList.get(i);
        //Glide.with(mCtx).load(course.getImagePath()).into(holder.imageView);
        holder.courseTitle.setText(course.getCname());
        holder.courseDesc.setText(course.getSdesc());


    }

    @Override
    public int getItemCount() {
        return 0;}
        class  CourseViewHolder extends RecyclerView.ViewHolder{
            TextView courseTitle,courseDesc;

            public CourseViewHolder (View itemView){

                super (itemView);
                courseTitle=itemView.findViewById(R.id.textViewTitle);
                courseDesc=itemView.findViewById(R.id.textViewShortDesc);

                //imageView=itemView.findViewById(R.id.imageView);

            }

        }
}




