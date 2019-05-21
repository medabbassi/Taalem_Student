package com.yoo_devit.taalem_student;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoo_devit.taalem_student.Beans.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context mCtx;
    private List<Course> courseList;
    public  CourseAdapter(Context mCtx,List<Course> courseList){
        this.mCtx=mCtx;
        this.courseList=courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.course_list,null);

        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course =courseList.get(position);
        //Glide.with(mCtx).load(course.getImagePath()).into(holder.imageView);
        holder.courseTitle.setText(course.getCname());
        holder.courseDesc.setText(course.getSdesc());
        holder.courseChap.setText(course.getNbchapter());
        holder.courseFee.setText(course.getCfee());


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    class  CourseViewHolder extends RecyclerView.ViewHolder{
        TextView courseTitle,courseDesc,courseChap,courseFee;
        ImageView imageView;
        public CourseViewHolder (View itemView){

            super (itemView);
            courseTitle=itemView.findViewById(R.id.textViewTitle);
            courseDesc=itemView.findViewById(R.id.textViewShortDesc);
            courseChap=itemView.findViewById(R.id.textViewRating);
            courseFee=itemView.findViewById(R.id.textViewRating);
            imageView=itemView.findViewById(R.id.imageView);

        }

    }
}
