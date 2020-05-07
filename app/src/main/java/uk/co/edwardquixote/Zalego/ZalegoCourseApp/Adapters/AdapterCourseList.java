package uk.co.edwardquixote.Zalego.ZalegoCourseApp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uk.co.edwardquixote.Zalego.ZalegoCourseApp.DataModels.ModelCourse;
import uk.co.edwardquixote.Zalego.ZalegoCourseApp.R;

public class AdapterCourseList extends RecyclerView.Adapter<AdapterCourseList.ViewHolderCourseList> {

    private List<ModelCourse> listCourses;


    public AdapterCourseList(@NonNull List<ModelCourse> courseList) {
        super();

        this.listCourses = courseList;

    }


    @Override
    public int getItemCount() {
        return listCourses.size();
    }

    @NonNull
    @Override
    public ViewHolderCourseList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewRowLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_course, parent, false);
        ViewHolderCourseList classViewHolder = new ViewHolderCourseList(viewRowLayout);

        return classViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCourseList holder, int position) {

        ModelCourse classModelCourse = listCourses.get(position);

        String courseTitle = classModelCourse.getCourse_title();
        String courseDescription = classModelCourse.getCourse_description();

        holder.txtCourseTitle.setText(courseTitle);
        holder.txtCourseDescription.setText(courseDescription);

    }





    public static class ViewHolderCourseList extends RecyclerView.ViewHolder {

        private TextView txtCourseTitle;
        private TextView txtCourseDescription;


        public ViewHolderCourseList(@NonNull View itemView) {
            super(itemView);

            txtCourseTitle = (TextView) itemView.findViewById(R.id.txtCourseTitle);
            txtCourseDescription = (TextView) itemView.findViewById(R.id.txtCourseDescription);

        }
    }

}
